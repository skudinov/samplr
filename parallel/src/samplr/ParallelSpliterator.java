package samplr;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ParallelSpliterator implements Spliterator<String> {

  private final int parallelChunkCount;
  private final ExecutorCompletionService<Chunk> completor;
  private final int chunkSize;
  private final ExecutorService executor;
  private int fromIndex;
  private int maxSize;

  public ParallelSpliterator(int batchSize, int maxBatchCount, int parallelBatchCount) {
    this.chunkSize = batchSize;
    this.parallelChunkCount = parallelBatchCount;
    this.maxSize = maxBatchCount * batchSize;
    this.executor = Executors.newCachedThreadPool();
    this.completor = new ExecutorCompletionService<>(executor);
  }

  @Override
  public boolean tryAdvance(Consumer<? super String> action) {
    List<Chunk> chunks = new ArrayList();
    int taskCount = 0;
    for (int j=0; j < this.parallelChunkCount; j++, taskCount++) {
      int toIndex = this.fromIndex + this.chunkSize;
      if (toIndex > maxSize) {
        break;
      }
      completor.submit(new GetChunk(j, this.fromIndex, toIndex));
      this.fromIndex = toIndex;
    }

    boolean isLastChunk = false;
    int toBeSentChunkIndex = 0;
    try {
      for (int j = 0; j < taskCount; j++) {
        Chunk newChunk = completor.take().get();
        isLastChunk = newChunk.isLast();
        if (!isLastChunk) {
          chunks.add(newChunk);
        }
        for (int i = chunks.size(); --i >= 0; ) {
          Chunk oldChunk = chunks.get(i);
          if (oldChunk.getChunkIndex() == toBeSentChunkIndex) {
            action.accept(oldChunk.getResult());
            chunks.remove(i);
            toBeSentChunkIndex++;
            i = chunks.size();
          }
        }
      }
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }
    boolean canAdvance = !isLastChunk && this.fromIndex < this.maxSize;
    if (!canAdvance) {
      this.executor.shutdown();
    }
    return canAdvance;
  }

  @Override
  public Spliterator<String> trySplit() {
    return null;
  }

  @Override
  public long estimateSize() {
    return 0;
  }

  @Override
  public int characteristics() {
    return 0;
  }
}

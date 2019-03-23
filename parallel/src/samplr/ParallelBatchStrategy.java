package samplr;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ParallelBatchStrategy {

  private final int batchSize;
  private final int maxBatchCount;
  private final int parallelBatchCount;

  public ParallelBatchStrategy(int batchSize, int maxBatchCount, int parallelBatchCount) {
    this.batchSize = batchSize;
    this.maxBatchCount = maxBatchCount;
    this.parallelBatchCount = parallelBatchCount;
  }

  public Stream<String> search() {
    return StreamSupport.stream(new ParallelSpliterator(batchSize, maxBatchCount, parallelBatchCount), false);
  }
}

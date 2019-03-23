package samplr;

import java.util.Random;
import java.util.concurrent.Callable;

public class GetChunk implements Callable<Chunk> {
  private static Random rnd = new Random();
  private final int toIndex;
  private final int fromIndex;
  private final int chunkIndex;

  public GetChunk(int chunkIndex, int fromIndex, int toIndex) {
    this.chunkIndex = chunkIndex;
    this.fromIndex = fromIndex;
    this.toIndex = toIndex;
  }

  @Override
  public Chunk call() throws Exception {
    Thread.sleep(rnd.nextInt(3000));
    return new Chunk(chunkIndex, fromIndex, toIndex, rnd.nextBoolean() && rnd.nextBoolean()? "":
      "["+fromIndex+","+toIndex+"]");
  }

}

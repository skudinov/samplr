package samplr;

public class Chunk {
  private final int fromIndex;
  private final int toIndex;
  private final String result;
  private final int chunkIndex;

  public Chunk(int chunkIndex, int fromIndex, int toIndex, String result) {
    this.chunkIndex = chunkIndex;
    this.fromIndex = fromIndex;
    this.toIndex = toIndex;
    this.result = result;
  }

  public int getFromIndex() {
    return fromIndex;
  }

  public int getToIndex() {
    return toIndex;
  }

  public String getResult() {
    return result;
  }

  public boolean isLast() {
    return result==null || result.isEmpty();
  }

  public int getChunkIndex() {
    return chunkIndex;
  }


}

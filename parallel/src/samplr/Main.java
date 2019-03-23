package samplr;

import java.util.concurrent.ExecutionException;

public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ParallelBatchStrategy strategy = new ParallelBatchStrategy(500, 7, 3);
    strategy.search().forEach(System.out::println);
  }
}

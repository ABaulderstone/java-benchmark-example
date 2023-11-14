package benchmark;

public class Runner {

  public static void main(String[] args) {
    SorterBenchmark benchmark = new SorterBenchmark();
    benchmark.benchmarkSortByLetterFrequency();
  }
}

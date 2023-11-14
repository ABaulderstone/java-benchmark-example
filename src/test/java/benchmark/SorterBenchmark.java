package benchmark;

import io.nology.lettersort.Sorter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class SorterBenchmark {

  private String input; // Pre-generated input string

  @Setup(Level.Trial)
  public void setup() {
    input = generateRandomString(1000000000);
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public ArrayList<Character> benchmarkSortByLetterFrequency() {
    return Sorter.sortByLetterFrequency(input);
  }

  private String generateRandomString(int length) {
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      char letter = (char) (random.nextInt(26) + 'a');
      sb.append(letter);
    }

    return sb.toString();
  }
}

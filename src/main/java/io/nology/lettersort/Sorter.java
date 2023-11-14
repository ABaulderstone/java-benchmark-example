package io.nology.lettersort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Sorter {

  public static ArrayList<Character> sortByLetterFrequency(String input) {
    HashMap<Character, Integer> count = new HashMap<Character, Integer>();
    int strLength = input.length();
    for (int i = 0; i < strLength; i++) {
      Character letter = input.charAt(i);
      count.compute(letter, (k, v) -> (v == null) ? 1 : v + 1);
    }
    ArrayList<Character> sortedLetters = count
      .keySet()
      .stream()
      .sorted((a, b) -> count.get(b) - count.get(a))
      .collect(Collectors.toCollection(ArrayList::new));

    return sortedLetters;
  }
}

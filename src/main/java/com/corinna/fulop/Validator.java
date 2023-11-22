package com.corinna.fulop;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

  private final Reader reader;

  public Validator(Reader reader) {
    this.reader = reader;
  }

  public int checkSentences() throws IOException {
    List<String> sentences = reader.readEachLine();
    int counter = 0;

    for (int i = 0; i < sentences.size(); i++) {
      if (containsMoreThanOneWord(sentences.get(i)) && endsWithPunctuation(sentences.get(i)) && hasNoDuplications(sentences.get(i))) {
        System.out.println(sentences.get(i));
        counter++;
      }
    }

    System.out.println(counter);
    return counter;
  }

  private boolean containsMoreThanOneWord(String sentence) {
    return sentence.split(" ").length > 1;
  }

  private boolean endsWithPunctuation(String sentence) {
    List<Character> punctuation = Arrays.asList('!', '?', '.');
    return punctuation.contains(sentence.charAt(sentence.length() - 1));
  }

  private boolean hasNoDuplications(String sentence) {
    if (endsWithPunctuation(sentence)) {
      String[] splittedArray = sentence.substring(0,sentence.length()-1).split(" ");
      Set<String> splittedSet = new HashSet<>(Arrays.asList(splittedArray));

      return splittedArray.length == splittedSet.size();
    }
    return false;
  }

}

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

    for(int i = 0; i < sentences.size(); i++) {
      if(hasNoDuplications(sentences.get(i))) {
        counter++;
      }
    }

    System.out.println(counter);
    return counter;
  }

  private boolean hasNoDuplications (String sentence) {
    String[] splittedArray = sentence.split(" ");
    Set<String> splittedSet = new HashSet<>(Arrays.asList(splittedArray));

    return splittedArray.length == splittedSet.size();
  }


}

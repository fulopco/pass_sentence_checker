package com.corinna.fulop.validator_service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicationValidator implements ValidatorI {

  private final List<Character> PUNCTUATION = Arrays.asList('!', '?', '.');

  @Override
  public boolean validate(String sentence) {
    String sentenceWithoutPunctuation = sentence.substring(0, sentence.length() - 1);
    List<String> splittedArray = Arrays.stream(sentenceWithoutPunctuation.split(" ")).toList();
    Set<String> splittedSet = new HashSet<>(splittedArray);

    return splittedArray.size() == splittedSet.size() && !containsConsecutiveSpaces(splittedSet);
  }

  private boolean containsConsecutiveSpaces(Set<String> splittedSet) {
    return splittedSet.contains("");
  }
}
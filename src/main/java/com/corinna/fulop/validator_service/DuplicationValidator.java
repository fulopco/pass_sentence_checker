package com.corinna.fulop.validator_service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicationValidator implements ValidatorI {

  @Override
  public boolean validate(String sentence) {
    String[] splittedArray = sentence.substring(0, sentence.length() - 1).split(" ");
    Set<String> splittedSet = new HashSet<>(Arrays.asList(splittedArray));

    return splittedArray.length == splittedSet.size() && !splittedSet.contains(""); //2 spaces next to each other not allowed
  }

}
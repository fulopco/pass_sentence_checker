package com.corinna.fulop.validator_service;

import java.util.Arrays;
import java.util.List;

public class PunctuationValidator implements ValidatorI {

  private final List<Character> PUNCTUATION = Arrays.asList('!', '?', '.');

  @Override
  public boolean validate(String sentence) {
      return PUNCTUATION.contains(sentence.charAt(sentence.length() -1)) && sentence.charAt(sentence.length() -2) != ' ';
  }

}
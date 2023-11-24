package com.corinna.fulop.validator_service;

import java.util.Arrays;
import java.util.List;

public class PunctuationValidator implements ValidatorI {

  private final List<Character> PUNCTUATION = Arrays.asList('!', '?', '.');
  private final int ASCII_LOWERCASE_A = 97;
  private final int ASCII_LOWERCASE_Z = 122;

  @Override
  public boolean validate(String sentence) {
      char lastCharacter = sentence.charAt(sentence.length() -1);
      return PUNCTUATION.contains(lastCharacter) && endsWithOnePunctuation(sentence);
  }

  private boolean endsWithOnePunctuation(String sentence) {
    int charCodeOfLastLetter = (int) sentence.charAt(sentence.length() -2);
    return charCodeOfLastLetter >= ASCII_LOWERCASE_A && charCodeOfLastLetter <= ASCII_LOWERCASE_Z;
  }

}
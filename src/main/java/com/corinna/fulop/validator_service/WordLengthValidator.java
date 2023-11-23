package com.corinna.fulop.validator_service;

public class WordLengthValidator implements ValidatorI{

  private final int MINIMUM_LENGTH = 1;

  @Override
  public boolean validate(String sentence) {
    return sentence.split(" ").length > MINIMUM_LENGTH;
  }
}

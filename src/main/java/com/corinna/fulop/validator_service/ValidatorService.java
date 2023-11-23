package com.corinna.fulop.validator_service;

import com.corinna.fulop.Reader;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ValidatorService {

  private final Reader reader;
  private final Collection<ValidatorI> validators;

  public ValidatorService(Reader reader, Collection<ValidatorI> validators) {
    this.reader = reader;
    this.validators = validators;
  }

  public int checkSentences() throws IOException {
    List<String> sentences = reader.readEachLine();

    int counter = 0;

    for (String sentence : sentences) {
      if(validateSentence(sentence)) {
      counter++;
      }
    }

    System.out.println("Helyes jelmondatok száma: " + counter);
    return counter;
  }

  private boolean validateSentence(String sentence) {
    for (ValidatorI validator : validators) {
      if (!validator.validate(sentence)) {
        System.out.println(sentence);
        System.out.println(validator);
        return false;
      }
    }
    return true;
  }


}
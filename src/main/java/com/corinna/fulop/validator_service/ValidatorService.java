package com.corinna.fulop.validator_service;

import com.corinna.fulop.Reader;
import com.corinna.fulop.ui.ConsoleLogger;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ValidatorService {

  private final Reader reader;
  private final ConsoleLogger consoleLogger;
  private final Collection<ValidatorI> validators;

  public ValidatorService(Reader reader, ConsoleLogger consoleLogger, Collection<ValidatorI> validators) {
    this.reader = reader;
    this.consoleLogger = consoleLogger;
    this.validators = validators;
  }

  public int validSentenceCounter() throws IOException {
    List<String> sentences = reader.readEachLine();

    int counter = 0;

    for (String sentence : sentences) {
      if (validateSentence(sentence)) {
        counter++;
      }
    }

    consoleLogger.printTextToConsol("Helyes jelmondatok száma: " + counter);
    return counter;
  }

  private boolean validateSentence(String sentence) {
    for (ValidatorI validator : validators) {
      if (!validator.validate(sentence)) {
        return false;
      }
    }
    return true;
  }


}

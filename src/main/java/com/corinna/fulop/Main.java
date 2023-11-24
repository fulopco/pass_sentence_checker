package com.corinna.fulop;

import com.corinna.fulop.ui.ConsoleLogger;
import com.corinna.fulop.validator_service.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    Reader reader = new Reader();
    ConsoleLogger logger = new ConsoleLogger();
    Collection<ValidatorI> validators = List.of(
            new WordLengthValidator(),
            new PunctuationValidator(),
            new DuplicationValidator(),
            new LetterValidator()
    );

    ValidatorService validator = new ValidatorService(reader, validators);
    int result = validator.validSentenceCounter();
    logger.printTextToConsol(result);
  }


}
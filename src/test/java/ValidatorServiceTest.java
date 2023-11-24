import com.corinna.fulop.Reader;
import com.corinna.fulop.validator_service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidatorServiceTest {

  private Reader readerMock;
  private WordLengthValidator wordLengthValidatorMock;

  Collection<ValidatorI> validators;

  @BeforeEach
  public void setup() {
    readerMock = mock(Reader.class);
    wordLengthValidatorMock = mock(WordLengthValidator.class);
    validators = new ArrayList<>(List.of(
            wordLengthValidatorMock
    ));

  }

  @Test
  void serviceTest() throws IOException {
    ValidatorService validatorService = new ValidatorService(readerMock, validators);
    List<String> sentences = List.of("lorem impsum.");

    when(readerMock.readEachLine()).thenReturn(sentences);
    when(wordLengthValidatorMock.validate(sentences.get(0))).thenReturn(true);

    int actual = validatorService.validSentenceCounter();
    Assertions.assertEquals(1, actual);
  }
}
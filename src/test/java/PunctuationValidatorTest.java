import com.corinna.fulop.validator_service.PunctuationValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class PunctuationValidatorTest {

  @ParameterizedTest
  @MethodSource("provideValuesForPunctuationTest")
  void checkIfSentenceEndsWithPunctuation(String sentence, boolean expected) {
    PunctuationValidator punctuationValidator = new PunctuationValidator();
    boolean actual = punctuationValidator.validate(sentence);

    assertEquals(expected, actual);
  }

  private static Stream<Arguments> provideValuesForPunctuationTest() {
    return Stream.of(
            Arguments.of("The quick brown fox jumps over the lazy dog.", true),
            Arguments.of("123 Street .", false),
            Arguments.of("multiple punctuation marks!!", true),
            Arguments.of("space before punctuation !", false),
            Arguments.of("testing asd", false),
            Arguments.of("hello world!", true),
            Arguments.of("not valid", false),
            Arguments.of("valid sentence?", true),
            Arguments.of("this", false),
            Arguments.of("    !", false),
            Arguments.of("!!!", true)
    );
  }
}

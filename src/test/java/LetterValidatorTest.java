import com.corinna.fulop.validator_service.LetterValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class LetterValidatorTest {

  @ParameterizedTest
  @MethodSource("provideValuesForLowercaseEnglishABC")
  void checkCharacterSet(String sentence, boolean expected) {
    LetterValidator letterValidator = new LetterValidator();
    boolean actual = letterValidator.validate(sentence);

    assertEquals(expected, actual);
  }

  private static Stream<Arguments> provideValuesForLowercaseEnglishABC() {
    return Stream.of(
            Arguments.of("The quick brown fox jumps over the lazy dog.", false),
            Arguments.of("This stats with uppercase.", false),
            Arguments.of("no numbers allowed 123", false),
            Arguments.of("Special characters @ .", false),
            Arguments.of("sentence contains a number 42.", false),
            Arguments.of("tab at the end  ", true),
            Arguments.of("this is valid", true),
            Arguments.of("newline character\nnot allowed.", false),
            Arguments.of("special characters: $%^&*", false),
            Arguments.of("nem érti az ékezetet, ezért falsee", false),
            Arguments.of("ezt se érti", false),
            Arguments.of("ezt igen", true),
            Arguments.of("   spaces", true),
            Arguments.of("  tab       ", true),
            Arguments.of("  a", true),
            Arguments.of("   ", true),
            Arguments.of(" ", true)
    );
  }
}

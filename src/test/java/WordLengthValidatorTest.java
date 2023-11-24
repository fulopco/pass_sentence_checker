import com.corinna.fulop.validator_service.WordLengthValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class WordLengthValidatorTest {

  @ParameterizedTest
  @MethodSource("provideValuesForTestingWordLength")
  void checkNumberOfWordsAreBiggerThanOne(String sentence, boolean expected) {
    WordLengthValidator wordLengthValidator = new WordLengthValidator();
    boolean actual = wordLengthValidator.validate(sentence);

    assertEquals(expected, actual);
  }

  private static Stream<Arguments> provideValuesForTestingWordLength() {
    return Stream.of(
            Arguments.of("The quick brown fox jumps over the lazy dog.", true),
            Arguments.of("This is a valid   sentence.", true),
            Arguments.of("this    ", false),
            Arguments.of("space at the end    ", true),
            Arguments.of("hello world!", true),
            Arguments.of(" 123        Street     ", true),
            Arguments.of("     Special  characters @ .", true),
            Arguments.of("   ", false),
            Arguments.of("a", false),
            Arguments.of("     asd", false),
            Arguments.of("asd       ", false),
            Arguments.of("    asd     asd", true),
            Arguments.of("", false)
    );
  }


}

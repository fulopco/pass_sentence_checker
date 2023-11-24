import com.corinna.fulop.validator_service.DuplicationValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class DuplicationValidatorTest {

  @ParameterizedTest
  @MethodSource("provideValuesForDuplication")
  void sentenceOnlyAcceptableWhenNoDuplications(String sentence, boolean expected) {
    DuplicationValidator duplicationValidator = new DuplicationValidator();
    boolean actual = duplicationValidator.validate(sentence);

    assertEquals(expected, actual);
  }

  private static Stream<Arguments> provideValuesForDuplication() {
    return Stream.of(
            Arguments.of("korte korte !", false),
            Arguments.of("korte alma ! ", true),
            Arguments.of("there is 2  space next to each other!", false),
            Arguments.of("case Case sensitivity!", true),
            Arguments.of("Multiple   spaces.", false),
            Arguments.of("word1 word2 word1!", false),
            Arguments.of(" .", true),
            Arguments.of("asd  helloo!", false),
            Arguments.of("asd dsa    space   word !", false)
    );
  }

}

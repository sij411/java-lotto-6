package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void bonusIsContainedInWinningNumber() {
        assertThatThrownBy(() -> Validators.validateBonusNumberDuplicated(3, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void bonusNotInteger() {
        assertThatThrownBy(() -> Validators.validateStringIsIntegerConvertable("$"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
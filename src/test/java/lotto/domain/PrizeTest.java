package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    private static final List<Integer> WINNING = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static List<Integer> lotto;
    @BeforeEach
    void setUp() {
        lotto = new ArrayList<>(Arrays.asList(1,2,3,4,5,7));
    }

    @DisplayName("로또 번호와 당첨 번호를 올바르게 비교하는 지 확인한다.")
    @Test
    void checkCompareLottoAndWinningNumbers() {
        int count = Prize.compare(lotto,WINNING);
        assertThat(Integer.toString(count)).isEqualTo("5");
    }
}

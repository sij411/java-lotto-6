package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public int readMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String inputMoney = Console.readLine().trim();
        boolean passed = Validators.validateMoney(inputMoney);
        while (!passed) {
            System.out.println("구입금액을 입력해 주세요");
            inputMoney = Console.readLine().trim();
            passed = Validators.validateMoney(inputMoney);
        }
        return Integer.parseInt(inputMoney);
    }

    public String readWinning() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String inputWinningNumbers = Console.readLine().trim();
        boolean passedWinning = Validators.validateWinningNumbers(inputWinningNumbers);
        while (!passedWinning) {
            passedWinning = Validators.validateWinningNumbers(inputWinningNumbers);
            inputWinningNumbers = Console.readLine();
        }
        return inputWinningNumbers;
    }

    public int readBonus(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = "";
        while (!Validators.validateBonusNumber(bonusNumber, winningNumbers)) {
            bonusNumber = Console.readLine().trim();
            if (!Validators.validateBonusNumber(bonusNumber, winningNumbers)) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return Integer.parseInt(bonusNumber);
    }
}

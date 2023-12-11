package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.HashMap;
import java.util.List;

public class Application {
    static int readMoney() {
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

    static String readWinning() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String inputWinningNumbers = Console.readLine().trim();
        boolean passedWinning = Validators.validateWinningNumbers(inputWinningNumbers);
        while (!passedWinning) {
            passedWinning = Validators.validateWinningNumbers(inputWinningNumbers);
            inputWinningNumbers = Console.readLine();
        }
        return inputWinningNumbers;

    }

    static int readBonus(List<Integer> winningNumbers) {
        // 당첨 번호와 겹치면 안됨
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;

        while (!Validators.validateBonusNumber(bonusNumber, winningNumbers)) {
            String inputBonusNumber = Console.readLine().trim();
            try {
                bonusNumber = Integer.parseInt(inputBonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                continue;
            }

            if (!Validators.validateBonusNumber(bonusNumber, winningNumbers)) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return bonusNumber;
    }

    public static void main(String[] args) {
        Manager lottoManager = new Manager();
        int receivedMoney = readMoney();
        Customer customer = new Customer(receivedMoney);
        List<Lotto> customerTickets = lottoManager.printTickets(customer.numberOfTickets);
        List<Integer> winningNumbers= lottoManager.setWinningNumbers(readWinning());
        int bonusNumber = readBonus(winningNumbers);

        HashMap<String, Integer> prizeCountsRecords = Prize.compareAllLottoTickets(customerTickets, winningNumbers, bonusNumber);
        Prize.printResults(prizeCountsRecords);
        double rateOfReturn = customer.getRateOfReturn(prizeCountsRecords, receivedMoney);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);

    }
}

package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.InputView;
import lotto.domain.Lotto;
import lotto.domain.Manager;
import lotto.domain.Prize;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        Manager lottoManager = new Manager();
        int receivedMoney = input.readMoney();
        Customer customer = new Customer(receivedMoney);
        List<Lotto> customerTickets = lottoManager.printTickets(customer.numberOfTickets);
        List<Integer> winningNumbers = lottoManager.setWinningNumbers(input.readWinning());
        int bonusNumber = input.readBonus(winningNumbers);

        HashMap<String, Integer> prizeCountsRecords = Prize.compareAllLottoTickets(customerTickets, winningNumbers,
                bonusNumber);
        Prize.printResults(prizeCountsRecords);
        double rateOfReturn = customer.getRateOfReturn(prizeCountsRecords, receivedMoney);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);

    }
}

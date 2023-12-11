package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Manager {

    public List<Lotto> printTickets(int numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.", numberOfTickets);
        List<Lotto> customerTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            customerTickets.add(new Lotto(randomNumbers));
            System.out.println(customerTickets.get(i));
        }
        return customerTickets;
    }

    public List<Integer> setWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] stringWinningNumbers = inputWinningNumbers.split(",");
        winningNumbers = convertStringToIntegerList(stringWinningNumbers);
        winningNumbers.sort(Comparator.naturalOrder());

        return winningNumbers;
    }

    public static List<Integer> convertStringToIntegerList(String[] target) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String convertableNumber : target) {
            winningNumbers.add(Integer.parseInt(convertableNumber));
        }
        return winningNumbers;
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoVendingMachine {

    public static final int LOTTO_NUMBERS_SIZE = LottoDrawMachine.LOTTO_NUMBERS_SIZE;
    public static final int MIN_VALUE = LottoDrawMachine.MIN_VALUE;
    public static final int MAX_VALUE = LottoDrawMachine.MAX_VALUE;

    public static int getLottoTickets(int purchaseAmount) {
        int lottoTickets = purchaseAmount / 1000;
        System.out.printf("\n%d개를 구매했습니다.\n", lottoTickets);
        return lottoTickets;
    }

    public static List<Lotto> getLottos(int lottoTickets) throws IllegalArgumentException {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoTickets; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_NUMBERS_SIZE);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        print(lottos);
        return lottos;
    }

    private static void print(List<Lotto> lottos) {
        lottos.stream().forEach(System.out::println);
    }
}

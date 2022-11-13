package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Ui {

    public static int inputPurchaseAmount() {
        printPurchaseAmountInput();
        String input = inputString();
        throwExceptionIfNotNumber(input);
        int purchaseAmount = Integer.parseInt(input);
        throwExceptionIfNotDivisibleBy1000(purchaseAmount);
        return purchaseAmount;
    }

    private static void printPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static String inputString() {
        return Console.readLine();
    }

    private static void throwExceptionIfNotNumber(String str) {
        if (!isAllNumber(str)) {
            throw new IllegalArgumentException("ERROR: 구입금액은 숫자만 입력이 가능합니다.");
        }
    }

    private static boolean isAllNumber(String str) {
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (!isNumber(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(char ch) {
        if (ch < '0' || '9' < ch) {
            return false;
        }
        return true;
    }

    private static void throwExceptionIfNotDivisibleBy1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("ERROR: 구입금액이 1000으로 나누어 떨어지지 않습니다.");
        }
    }
}

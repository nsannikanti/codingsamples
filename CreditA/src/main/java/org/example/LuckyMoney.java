package org.example;

import java.util.stream.IntStream;

public class LuckyMoney {

    public static int countDonationCombinations(int money, int giftees) {
        return countCombinations(money, giftees, 0);
    }

    private static int countCombinations(int money, int giftees, int currentSum) {
        if (currentSum > money || giftees == 0) {
            return 0;
        }

        if (currentSum == money && giftees == 0) {
            return 1;
        }

        // Recursively count combinations by either choosing or not choosing the current giftee
        return countCombinations(money, giftees - 1, currentSum) +
                countCombinations(money, giftees - 1, currentSum + 1);
    }

    public static void main(String[] args) {
        // Example usage:
        int money = 12;
        int giftees = 2;

        int result = countDonationCombinations(money, giftees);

        // Print the result
        System.out.println(result);
    }
}


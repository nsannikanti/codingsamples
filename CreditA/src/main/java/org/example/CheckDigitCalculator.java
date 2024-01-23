package org.example;

public class CheckDigitCalculator {

    public static int computeCheckDigit(String identificationNumber) {
        if (identificationNumber == null || identificationNumber.length() < 1 || identificationNumber.length() > 12) {
            throw new IllegalArgumentException("Invalid identification number");
        }

        int sumEvenPositions = 0;
        int sumOddPositions = 0;

        for (int i = 0; i < identificationNumber.length(); i++) {
            int digit = Character.getNumericValue(identificationNumber.charAt(i));

            if (i % 2 == 0) {
                // Even positions
                sumEvenPositions += digit;
            } else {
                // Odd positions
                sumOddPositions += digit;
            }
        }

        int result = (sumEvenPositions * 3) + sumOddPositions;

        // Take the last digit of the result
        int lastDigit = result % 10;

        // Subtract from 10 if the last digit is not 0
        return (lastDigit != 0) ? (10 - lastDigit) : 0;
    }

    public static void main(String[] args) {
        // Example usage:
        String identificationNumber = "39847";

        // Print the result
        System.out.println("Check Digit: " + computeCheckDigit(identificationNumber));
    }
}


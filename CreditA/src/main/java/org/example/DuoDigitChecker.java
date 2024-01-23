package org.example;

public class DuoDigitChecker {

    public static String isDuoDigit(int number) {
        // Convert the absolute value of the number to a string
        String numberStr = Integer.toString(Math.abs(number));

        // Use a set to count unique digits
        int uniqueDigitCount = (int) numberStr.chars().distinct().count();

        // Check if the count of unique digits is at most 2
        return (uniqueDigitCount <= 2) ? "Y" : "N";
    }

    public static void main(String[] args) {
        // Example usage:
        int number1 = 1;
        int number2 = 2020;
        int number3 = -2021;

        // Print the results
        System.out.println("Number: " + number1 + ", Result: " + isDuoDigit(number1));
        System.out.println("Number: " + number2 + ", Result: " + isDuoDigit(number2));
        System.out.println("Number: " + number3 + ", Result: " + isDuoDigit(number3));
    }
}


package org.example;

public class MultiplesSum {

    public static int completeMultiplesSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // Example usage:
        int n = 11;
        int result = completeMultiplesSum(n);

        System.out.println("Sum of multiples of 3, 5, or 7 up to " + n + ": " + result);
    }
}


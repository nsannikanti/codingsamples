package org.example;

import java.util.Arrays;
import java.util.List;

public class ProfitAnalyzer {

    public static List<Integer> maxProfit(List<Integer> data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        int maxProfit = Integer.MIN_VALUE;
        int currentProfit = 0;
        int startIdx = 0;
        int endIdx = 0;
        int tempStartIdx = 0;

        for (int i = 0; i < data.size(); i++) {
            currentProfit += data.get(i);

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                startIdx = tempStartIdx;
                endIdx = i;
            }

            if (currentProfit < 0) {
                currentProfit = 0;
                tempStartIdx = i + 1;
            }
        }

        return Arrays.asList(startIdx, endIdx);
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> data = Arrays.asList(-1, 9, 0, 8, -5, 6, -24);
        List<Integer> result = maxProfit(data);

        // Print the result
        System.out.println("Range with max profit: " + result);
    }
}


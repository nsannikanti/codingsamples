package org.example;

import java.util.ArrayList;
import java.util.List;

public class SummerSales {

    public static int calculateTotalPrice(List<Double> prices, double discount) {
        if (prices == null || prices.isEmpty()) {
            return 0;
        }

        // Find the maximum price in the list
        double maxPrice = prices.stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0);

        // Apply the discount to the maximum price
        double discountedPrice = maxPrice * (1 - (discount / 100));

        // Calculate the total purchase price
        double totalPrice = prices.stream().mapToDouble(Double::doubleValue).sum();

        // Deduct the discounted price from the total
        totalPrice -= maxPrice - discountedPrice;

        // Return the total price as an integer (rounded down)
        return (int) totalPrice;
    }

    public static void main(String[] args) {
        // Example usage:
        List<Double> prices = new ArrayList<Double>();
        prices.add(50.0);
        prices.add(75.0);
        prices.add(60.0);
        prices.add(90.0);

        double discount = 20.0;

        // Print the result
        System.out.println("Total Price: " + calculateTotalPrice(prices, discount));
    }
}


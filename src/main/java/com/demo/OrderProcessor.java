package com.demo;

// 1. IMPORT ERROR: Missing import for List and ArrayList
// import java.util.ArrayList;
// import java.util.List;

// 2. LINTING ERROR: Unused wildcard import
import java.io.*;

public class OrderProcessor {

    // 2. LINTING ERROR: Unused private variable & non-standard naming
    private int Unused_Counter = 0;

    // 3. SYNTAX ERROR: Missing semicolon at the end of field declaration
    private double taxRate = 0.18

    // 4. TYPE_ERROR: Method returns String ("0") instead of double
    public double calculateDiscount(double amount) {
        if (amount > 1000) {
            return amount * 0.10;
        }
        return "0.0";
    }

    // 5. LOGIC ERROR: Adds discount instead of subtracting it
    public double calculateFinalPrice(double basePrice) {
        double discount = calculateDiscount(basePrice);
        double priceAfterDiscount = basePrice + discount;
        return priceAfterDiscount + (priceAfterDiscount * taxRate);
    }

    // 6. INDENTATION ERROR: Misaligned braces and misleading indentation
    public boolean isEligibleForFreeShipping(double finalPrice) {
    if (finalPrice >= 500.0)
        return true;
        return false;
    }

    // Uses List/ArrayList (triggers IMPORT error until java.util.* is imported)
    public List<String> getAppliedTags(double finalPrice) {
        List<String> tags = new ArrayList<>();
        if (isEligibleForFreeShipping(finalPrice)) {
            tags.add("FREE_SHIPPING");
        }
        return tags;
    }
}
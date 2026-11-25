package com.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    @Test
    void testCalculateFinalPriceWithDiscountAndTax() {
        OrderProcessor processor = new OrderProcessor();
        // Base: 2000 -> 10% discount (-200) = 1800 -> +18% tax (324) = 2124.0
        double actual = processor.calculateFinalPrice(2000.0);
        assertEquals(2124.0, actual, 0.01, "Final price should subtract discount before adding tax");
    }

    @Test
    void testFreeShippingEligibility() {
        OrderProcessor processor = new OrderProcessor();
        assertTrue(processor.isEligibleForFreeShipping(600.0));
        assertFalse(processor.isEligibleForFreeShipping(200.0));

        List<String> tags = processor.getAppliedTags(600.0);
        assertEquals(List.of("FREE_SHIPPING"), tags);
    }
}
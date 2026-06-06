package com.airtribe.meditrack.strategy;

import com.airtribe.meditrack.constants.Constants;

public class InsuranceBillingStrategy implements BillingStrategy{
    @Override
    public double calculateTotal(double consultationFee) {
        double discountedFee = 0.8*consultationFee;
        return discountedFee+(Constants.TAX_RATE*discountedFee);
    }
}

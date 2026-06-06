package com.airtribe.meditrack.strategy;

import com.airtribe.meditrack.constants.Constants;

public class StandardBillingStrategy implements BillingStrategy{
    @Override
    public double calculateTotal(double consultationFee) {
        return consultationFee+(Constants.TAX_RATE*consultationFee);
    }
}

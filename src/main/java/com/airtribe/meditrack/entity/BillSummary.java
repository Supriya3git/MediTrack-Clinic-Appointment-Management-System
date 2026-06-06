package com.airtribe.meditrack.entity;

public class BillSummary {
    private final int billId;
    private final String patientName;
    private final double totalAmount;

    public BillSummary(int billId, String patientName, double totalAmount) {
        this.billId = billId;
        this.patientName = patientName;
        this.totalAmount = totalAmount;
    }

    public int getBillId() {
        return billId;
    }

    public String getPatientName() {
        return patientName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "BillSummary{" +
                "billId=" + billId +
                ", patientName='" + patientName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

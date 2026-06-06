package com.airtribe.meditrack.entity;

public class Bill {
    private int billId;
    private int appointmentId;
    private double amount;
    private double tax;
    private double totalAmount;

    public Bill(int billId, int appointmentId, double amount, double tax, double totalAmount) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.tax = tax;
        this.totalAmount = totalAmount;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", appointmentId=" + appointmentId +
                ", amount=" + amount +
                ", tax=" + tax +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

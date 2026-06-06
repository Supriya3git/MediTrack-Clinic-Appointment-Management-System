package com.airtribe.meditrack.factory;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.strategy.BillingStrategy;
import com.airtribe.meditrack.util.IdGenerator;

public class BillFactory {

    private BillFactory() {}

    public static Bill createBill(Appointment appointment, BillingStrategy strategy) {
        double fee = appointment.getDoctor().getConsultationFee();
        double total = strategy.calculateTotal(fee);
        double tax = total - fee;
        int billId = IdGenerator.getInstance().getNextBillId();
        return new Bill(billId, appointment.getAppointmentId(), fee, tax, total);
    }
}
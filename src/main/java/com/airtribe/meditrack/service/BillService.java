package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.BillSummary;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.factory.BillFactory;
import com.airtribe.meditrack.strategy.BillingStrategy;

import java.util.HashMap;
import java.util.Map;

public class BillService {

    private final Map<Integer, Bill> bills = new HashMap<>();

    private final AppointmentService appointmentService;

    public BillService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public Bill generateBill(int appointmentId, BillingStrategy strategy) throws AppointmentNotFoundException {
        Appointment appointment = appointmentService.findAppointment(appointmentId);
        Bill bill = BillFactory.createBill(appointment, strategy);
        bills.put(bill.getBillId(), bill);
        return bill;
    }

    public BillSummary getBillSummary(int billId) {
        Bill bill = bills.get(billId);
        if (bill == null) {
            return null;
        }
        return new BillSummary(bill.getBillId(), "Patient", bill.getTotalAmount());
    }

    public void viewBills() {
        bills.values().forEach(System.out::println);
    }

    public Map<Integer, Bill> getBills() {
        return bills;
    }
}
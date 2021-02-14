package com.enigma.Vcom.services;

import com.enigma.Vcom.entities.Payment;
import com.enigma.Vcom.models.PaymentModel;

import java.util.List;

public interface PaymentService {

    void addPayment(PaymentModel payment);

    void updatePayment(PaymentModel payment);

    void deletePayment(Payment payment);

    Payment findPaymentById(Integer id);

    List<Payment> findAllPayment();
}

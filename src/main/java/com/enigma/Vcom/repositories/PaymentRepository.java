package com.enigma.Vcom.repositories;

import com.enigma.Vcom.entities.Payment;
import com.enigma.Vcom.models.PaymentModel;

import java.util.List;

public interface PaymentRepository {

    boolean save(PaymentModel payment);

    boolean update(PaymentModel payment);

    boolean delete(Payment payment);

    Payment findById(Integer id);

    List<Payment> findAll();
}

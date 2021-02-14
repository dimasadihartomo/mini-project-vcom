package com.enigma.Vcom.services.impls;


import com.enigma.Vcom.entities.Payment;
import com.enigma.Vcom.models.PaymentModel;
import com.enigma.Vcom.repositories.PaymentRepository;
import com.enigma.Vcom.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void addPayment(PaymentModel payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void updatePayment(PaymentModel payment) {
        paymentRepository.update(payment);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentRepository.delete(payment);
    }

    @Override
    public Payment findPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> findAllPayment() {
        return paymentRepository.findAll();
    }
}

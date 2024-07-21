package com.example.service;

import com.example.repository.*;
import com.example.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Integer id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            payment.setName(paymentDetails.getName());
            payment.setCcNumber(paymentDetails.getCcNumber());
            payment.setExpires(paymentDetails.getExpires());
            payment.setCcType(paymentDetails.getCcType());
            payment.setUserId(paymentDetails.getUserId());
            return paymentRepository.save(payment);
        }
        return null;
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }
}


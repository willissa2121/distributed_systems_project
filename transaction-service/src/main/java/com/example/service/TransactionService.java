package com.example.service;

import com.example.model.*;
import com.example.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Integer id, Transaction transactionDetails) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction != null) {
            transaction.setName(transactionDetails.getName());
            transaction.setDate(transactionDetails.getDate());
            transaction.setType(transactionDetails.getType());
            transaction.setAmount(transactionDetails.getAmount());
            transaction.setApproved(transactionDetails.getApproved());
            transaction.setUserId(transactionDetails.getUserId());
            return transactionRepository.save(transaction);
        }
        return null;
    }

    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}


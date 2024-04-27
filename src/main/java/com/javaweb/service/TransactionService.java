package com.javaweb.service;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionEntity> transactionCSKH(String code, Long customerId);

    List<TransactionEntity> transactionDDX(String code, Long customerId);

    void updateOrAddTransaction(TransactionDTO transactionDTO);
}

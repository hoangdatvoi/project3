package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConvert;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionConvert transactionConvert;

    @Override
    public List<TransactionEntity> transactionCSKH(String code, Long customerId) {

        if (code.equals("CSKH")) {
            List<TransactionEntity> list = transactionRepository.findByCodeAndCustomerId(code, customerId);

            return list;
        }
        return null;
    }

    @Override
    public List<TransactionEntity> transactionDDX(String code, Long customerId) {
        if (code.equals("DDX")) {
            List<TransactionEntity> list = transactionRepository.findByCodeAndCustomerId(code, customerId);

            return list;
        }
        return null;
    }

    @Override
    public void updateOrAddTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = transactionConvert.transactionEntity(transactionDTO);
        transactionRepository.save(transactionEntity);
    }
}

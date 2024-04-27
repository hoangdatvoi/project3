package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConvert {
    @Autowired
    private ModelMapper modelMapper;

    public TransactionEntity transactionEntity(TransactionDTO item) {
        TransactionEntity rs = modelMapper.map(item, TransactionEntity.class);
        rs.setNote(item.getTransactionDetail());
        return rs;

    }

}

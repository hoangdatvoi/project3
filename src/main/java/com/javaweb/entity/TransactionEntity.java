package com.javaweb.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
@DynamicUpdate
@DynamicInsert
public class TransactionEntity extends BaseEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "note")
    private String note;
    @Column(name = "customerid")
    private Long customerId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @PrePersist
    protected void onCreate() {
        // Đặt modifiedDate và modifiedBy thành null hoặc giá trị mặc định
        this.setModifiedDate(null); // hoặc this.setModifiedDate(new Date(0)) nếu muốn giá trị là mặc định
        this.setModifiedBy(null); // hoặc this.setModifiedBy("N/A") nếu muốn giá trị là mặc định
    }
}

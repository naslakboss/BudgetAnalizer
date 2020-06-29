package com.project.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public  class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenditureId;

    @NotNull
    private int value;

    private Date date;
    
    @NotNull
    private String expType;

    public long getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(long expenditureId) {
        this.expenditureId = expenditureId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public Expenditure(long expenditureId, int value, Date date, String expType) {
        this.expenditureId = expenditureId;
        this.value = value;
        this.date = date;
        this.expType = expType;
    }

    public Expenditure() {
    }
}

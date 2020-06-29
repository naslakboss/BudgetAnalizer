package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long revenueId;

    private int value;

    private String revenueType;

    private Date date;

    public Revenue(){

    }

    public Revenue(Long revenueId, String revenueType, Date date, int value) {
        this.revenueId = revenueId;
        this.revenueType = revenueType;
        this.date = date;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getRevenueId() {
        return revenueId;
    }

    public void setRevenueId(Long revenueId) {
        this.revenueId = revenueId;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

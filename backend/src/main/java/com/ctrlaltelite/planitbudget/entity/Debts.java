package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"debts\"")

public class Debts {
    public Debts() {
    }
    public Debts(String debtName, String timeSpan, Double monthlyAmount) {
        this.debtName = debtName;
        this.timeSpan = timeSpan;
        this.monthlyAmount = monthlyAmount;
    }   

    public Debts(Long money) {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
   
    @Column(name = "debtName",length = 700, nullable = false)
    private String debtName;

    @Column(name = "timeSpan", length = 700, nullable = false)
    private String timeSpan;

    @Column(name = "monthlyAmount", nullable = true)
    private Double monthlyAmount;

   
    public String getDebtName() {
        return this.debtName;
    }
    public void setDebtName(String debtName) {
        this.debtName = debtName;
    }
    public String getTimeSpan() {
        return this.timeSpan;
    }
    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan;
    }
    public Double getMonthlyAmount() {
        return this.monthlyAmount;
    }
    public void setMonthlyAmount(Double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    






}

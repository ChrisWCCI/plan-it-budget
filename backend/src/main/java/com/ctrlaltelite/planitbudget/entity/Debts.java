package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"debts\"")

public class Debts {
    public Debts() {
    }

    public Debts(String debtName, String timeSpan, Double monthlyAmount, Double balance) {
        this.debtName = debtName;
        this.timeSpan = timeSpan;
        this.monthlyAmount = monthlyAmount;
        this.balance = balance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "debtName", length = 700, nullable = false)
    private String debtName;

    @Column(name = "balance", nullable = true)
    private Double balance;

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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}

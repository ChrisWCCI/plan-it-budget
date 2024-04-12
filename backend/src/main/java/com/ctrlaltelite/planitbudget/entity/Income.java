package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"income\"")

public class Income {
    public Income() {
    }

    public Income(String date, String incomeSource, String payPeriod, Double paycheckAmount,
            Double monthlyCalculatedAmount, Double usableIncome) {
        this.date = date;
        this.incomeSource = incomeSource;
        this.payPeriod = payPeriod;
        this.paycheckAmount = paycheckAmount;
        this.monthlyCalculatedAmount = monthlyCalculatedAmount;
        this.usableIncome = usableIncome;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "incomeSource", length = 700, nullable = false)
    private String incomeSource;

    @Column(name = "payPeriod", nullable = true)
    private String payPeriod;

    @Column(name = "paycheckAmount", nullable = false)
    private Double paycheckAmount;

    @Column(name = "monthlyCalculatedAmount", nullable = false)
    private Double monthlyCalculatedAmount;

    @Column(name = "usableIncome", nullable = false)
    private Double usableIncome;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIncomeSource() {
        return this.incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public String getPayPeriod() {
        return this.payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Double getPaycheckAmount() {
        return this.paycheckAmount;
    }

    public void setPaycheckAmount(Double paycheckAmount) {
        this.paycheckAmount = paycheckAmount;
    }

    public Double getMonthlyCalculatedAmount() {
        return this.monthlyCalculatedAmount;
    }

    public void setMonthlyCalculatedAmount(Double monthlyCalculatedAmount) {
        this.monthlyCalculatedAmount = monthlyCalculatedAmount;
    }

    public Double getUsableIncome() {
        return this.usableIncome;
    }

    public void setUsableIncome(Double usableIncome) {
        this.usableIncome = usableIncome;
    }

    /**
     * Override method for the toString
     */
    @Override
    public String toString() {
        return "income [date=" + date + ", incomeSource=" + incomeSource + ", payPeriod=" + payPeriod
                + ", paycheckAmount="
                + paycheckAmount
                + ", monthlyCalculatedAmount=" + monthlyCalculatedAmount + ", usableIncome="
                + usableIncome + "]";
    }

}

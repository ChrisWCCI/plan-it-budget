package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "\"income\"")

public class Income {
    public Income() {
    }

    public Income(LocalDate payDate, String incomeSource, String payPeriod, Double paycheckAmount) {
        this.payDate = payDate;
        this.incomeSource = incomeSource;
        this.payPeriod = payPeriod;
        this.paycheckAmount = paycheckAmount;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "payDate", nullable = false)
    private LocalDate payDate;

    @Column(name = "incomeSource", length = 700, nullable = false)
    private String incomeSource;

    @Column(name = "payPeriod", nullable = true)
    private String payPeriod;

    @Column(name = "paycheckAmount", nullable = false)
    private Double paycheckAmount;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPayDate() {
        return this.payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
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

    /**
     * Override method for the toString
     */
    @Override
    public String toString() {
        return "income [payDate=" + payDate + ", incomeSource=" + incomeSource + ", payPeriod=" + payPeriod
                + ", paycheckAmount="
                + paycheckAmount + "]";
    }

}

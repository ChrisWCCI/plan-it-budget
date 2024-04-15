package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "\"expenses\"")

public class Expenses {
    public Expenses() {
    }

    public Expenses(LocalDate transactionDate, String expenseName, Double chargeAmount, Categories category) {
        this.transactionDate = transactionDate;
        this.expenseName = expenseName;
        this.chargeAmount = chargeAmount;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @Column(name = "transactionDate", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "expenseName", length = 700, nullable = false)
    private String expenseName;

    @Column(name = "chargeAmount", nullable = true)
    private Double chargeAmount;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getExpenseName() {
        return this.expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getChargeAmount() {
        return this.chargeAmount;
    }

    public void setChargeAmount(Double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Categories getCategory() {
        return this.category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

}

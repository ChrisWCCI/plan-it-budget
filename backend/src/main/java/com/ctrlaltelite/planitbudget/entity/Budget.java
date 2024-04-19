package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"budget\"")

public class Budget {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "budgetName", nullable = false)
    private String budgetName;

    @Column(name = "max", nullable = false)
    private Double max;

    public Budget() {
    }

    public Budget(String budgetName, Double max) {
        this.budgetName = budgetName;
        this.max = max;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBudgetName() {
        return this.budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public Double getMax() {
        return this.max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

}
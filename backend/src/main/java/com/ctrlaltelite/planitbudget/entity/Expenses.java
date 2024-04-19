package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"expenses\"")

public class Expenses {
    public Expenses() {
    }

    public Expenses(String description, Double chargeAmount, Budget budget) {
        this.description = description;
        this.chargeAmount = chargeAmount;
        this.budget = budget;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "chargeAmount", nullable = true)
    private Double chargeAmount;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getChargeAmount() {
        return this.chargeAmount;
    }

    public void setChargeAmount(Double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Budget getBudget() {
        return this.budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

}

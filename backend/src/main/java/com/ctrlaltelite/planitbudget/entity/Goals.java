package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"goals\"")

public class Goals {
    public Goals() {
    }

    public Goals(String goalName, Double goalAmount, String date, Double monthlyContribution) {
        this.goalName = goalName;
        this.goalAmount = goalAmount;
        this.date = date;
        this.monthlyContribution = monthlyContribution;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "goalName")
    private String goalName;

    @Column(name = "goalAmount")
    private Double goalAmount;

    @Column(name = "date")
    private String date;

    @Column(name = "monthly_Contribution")
    private Double monthlyContribution;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoalName() {
        return this.goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Double getGoalAmount() {
        return this.goalAmount;
    }

    public void setGoalAmount(Double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMonthlyContribution() {
        return this.monthlyContribution;
    }

    public void setMonthlyContribution(Double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

}

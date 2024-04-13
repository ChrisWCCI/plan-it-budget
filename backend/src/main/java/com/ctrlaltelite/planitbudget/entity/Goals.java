package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"goals\"")

public class Goals {
    public Goals() {
    }

    public Goals(String goalName, Double goalAmount, Double monthlyContribution, String timeSpan) {
        this.goalName = goalName;
        this.goalAmount = goalAmount;
        this.timeSpan = timeSpan;
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

    @Column(name = "timeSpan")
    private String timeSpan;

    @Column(name = "monthlyContribution")
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

    public Double getMonthlyContribution() {
        return this.monthlyContribution;
    }

    public void setMonthlyContribution(Double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    public String getTimeSpan() {
        return this.timeSpan;
    }

    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan;
    }
}

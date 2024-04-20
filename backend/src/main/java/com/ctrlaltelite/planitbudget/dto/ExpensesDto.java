package com.ctrlaltelite.planitbudget.dto;

public class ExpensesDto {

    private String description;
    private Double chargeAmount;
    private Long budgetId;

    public ExpensesDto() {
    }

    public ExpensesDto(String description, Double chargeAmount, Long budgetId) {
        this.description = description;
        this.chargeAmount = chargeAmount;
        this.budgetId = budgetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }
}

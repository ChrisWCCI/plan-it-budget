package com.ctrlaltelite.planitbudget.service;

import java.util.*;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.entity.Budget;
import com.ctrlaltelite.planitbudget.repository.BudgetRepository;
import com.ctrlaltelite.planitbudget.repository.ExpensesRepository;

import jakarta.transaction.Transactional;

@SuppressWarnings("null")
@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepo;

    @Autowired
    private ExpensesRepository expensesRepo;

    /*
     * saves Budget to the repository (db)
     */
    public Budget saveBudget(Budget budget) {
        double tempMax = budget.getMax();
        DecimalFormat dollarCentsFormat = new DecimalFormat("#.##");
        budget.setMax(Double.parseDouble(dollarCentsFormat.format(tempMax)));

        return this.budgetRepo.save(budget);
    }

    /*
     * Gets all the Budget that were saved (db)
     */
    public List<Budget> getAllBudget() {
        return this.budgetRepo.findAll();
    }

    // delete a saved Budget per selected Id
    @Transactional
    public void deleteBudget(long id) {
        Budget budget = this.budgetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found: " + id));
        // Delete all expenses associated with the budget
        expensesRepo.deleteByBudget(budget);
        this.budgetRepo.deleteById(id);
    }

    /*
     * Gets a specific Budget by its id
     */
    public Budget getBudgetById(long id) {
        return this.budgetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "budget not found: " + id));
    }

    /*
     * Updates an existing budget, found by a specific id.
     */
    public Budget updateBudget(long id, Budget updatedBudget) {
        Budget existingBudget = this.budgetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "budget not found: " + id));

        existingBudget.setBudgetName(updatedBudget.getBudgetName());
        existingBudget.setMax(updatedBudget.getMax());
        this.budgetRepo.save(existingBudget);

        return existingBudget;
    }

    /**
     * Method to find an budget by name
     */
    public Iterable<Budget> findByBudgetName(String budgetName) {
        Iterable<Budget> budget = new ArrayList<>();
        try {
            budget = budgetRepo.findByBudgetName(budgetName);
        } catch (Exception ex) {
            throw ex;
        }
        return budget;
    }

    /**
     * Method to find an budget by max
     */
    public Iterable<Budget> findByMax(Double max) {
        Iterable<Budget> budget = new ArrayList<>();
        try {
            budget = budgetRepo.findByMax(max);
        } catch (Exception ex) {
            throw ex;
        }
        return budget;
    }
}

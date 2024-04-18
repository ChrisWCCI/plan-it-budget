package com.ctrlaltelite.planitbudget.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.entity.Budget;
import com.ctrlaltelite.planitbudget.repository.BudgetRepository;

@SuppressWarnings("null")
@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepo;

    /*
     * saves Budget to the repository (db)
     */
    public void saveCategories(Budget budget) {
        this.budgetRepo.save(budget);
    }

    /*
     * Gets all the Budget that were saved (db)
     */
    public List<Budget> getAllCategories() {
        return this.budgetRepo.findAll();
    }

    // delete a saved Budget per selected Id
    public void deleteCategories(long id) {
        this.budgetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found: " + id));
        this.budgetRepo.deleteById(id);
    }

    /*
     * Gets a specific Budget by its id
     */
    public Budget getCategoriesById(long id) {
        return this.budgetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found: " + id));
    }

    /**
     * Method to find an category by name
     */
    public Iterable<Budget> findByCategoryName(String budgetName) {
        Iterable<Budget> budget = new ArrayList<>();
        try {
            budget = budgetRepo.findByBudgetName(budgetName);
        } catch (Exception ex) {
            throw ex;
        }
        return budget;
    }

    /**
     * Method to find an category by name
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

package com.ctrlaltelite.planitbudget.service;

import java.util.*;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;

import com.ctrlaltelite.planitbudget.entity.Expenses;
import com.ctrlaltelite.planitbudget.repository.ExpensesRepository;

@SuppressWarnings("null")
@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepo;

    /**
     * Default Constructor
     */
    public ExpensesService() {
    }

    /*
     * saves Expenses to the repository (db)
     */
    public void saveExpenses(Expenses expenses) {
        double tempChargeAmount = expenses.getChargeAmount();
        DecimalFormat dollarCentsFormat = new DecimalFormat("#.##");
        expenses.setChargeAmount(Double.parseDouble(dollarCentsFormat.format(tempChargeAmount)));
        this.expensesRepo.save(expenses);
    }

    /*
     * Gets all the Expenses that were saved (db)
     */
    public List<Expenses> getAllExpenses() {
        return this.expensesRepo.findAll();
    }

    // delete a saved Expense per selected Id
    public void deleteExpenses(long id) {
        this.expensesRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found: " + id));
        this.expensesRepo.deleteById(id);
    }

    /*
     * Gets a specific Expense by its id
     */
    public Expenses getExpensesById(long id) {
        return this.expensesRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found: " + id));
    }

    /**
     * Method to find an Expenses by transactionDate
     */
    public Iterable<Expenses> findByTransactionDate(LocalDate transactionDate) {
        Iterable<Expenses> expenses = new ArrayList<>();
        try {
            expenses = expensesRepo.findByTransactionDate(transactionDate);
        } catch (Exception ex) {
            throw ex;
        }
        return expenses;
    }

    /**
     * Method to find an Expenses by expenseName
     */
    public Iterable<Expenses> findByExpenseName(String expenseName) {
        Iterable<Expenses> expenses = new ArrayList<>();
        try {
            expenses = expensesRepo.findByExpenseName(expenseName);
        } catch (Exception ex) {
            throw ex;
        }
        return expenses;
    }

    /**
     * Method to find an Expenses by chargeAmount
     */
    public Iterable<Expenses> findByChargeAmount(Double chargeAmount) {
        Iterable<Expenses> expenses = new ArrayList<>();
        try {
            expenses = expensesRepo.findByChargeAmount(chargeAmount);
        } catch (Exception ex) {
            throw ex;
        }
        return expenses;
    }

}
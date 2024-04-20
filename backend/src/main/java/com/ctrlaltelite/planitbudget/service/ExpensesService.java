package com.ctrlaltelite.planitbudget.service;

import java.util.*;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.dto.ExpensesDto;
import com.ctrlaltelite.planitbudget.entity.Budget;
import com.ctrlaltelite.planitbudget.entity.Expenses;
import com.ctrlaltelite.planitbudget.repository.BudgetRepository;
import com.ctrlaltelite.planitbudget.repository.ExpensesRepository;

@SuppressWarnings("null")
@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepo;

    @Autowired
    private BudgetRepository budgetRepo;

    /**
     * Default Constructor
     */
    public ExpensesService() {
    }

    /*
     * saves Expenses to the repository (db)
     */
    public Expenses saveExpenses(ExpensesDto expenseDTO) {
        Budget budget = budgetRepo.findById(expenseDTO.getBudgetId()).orElse(null);
        if (budget != null) {
            double tempChargeAmount = expenseDTO.getChargeAmount();
            DecimalFormat dollarCentsFormat = new DecimalFormat("#.##");
            expenseDTO.setChargeAmount(Double.parseDouble(dollarCentsFormat.format(tempChargeAmount)));
            Expenses expense = new Expenses(expenseDTO.getDescription(), expenseDTO.getChargeAmount(), budget);
            expensesRepo.save(expense);
            return expensesRepo.save(expense);
        }
        return null;
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
    public Iterable<Expenses> findByDescription(String description) {
        Iterable<Expenses> expenses = new ArrayList<>();
        try {
            expenses = expensesRepo.findByDescription(description);
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
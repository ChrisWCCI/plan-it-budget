package com.ctrlaltelite.planitbudget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.entity.Expenses;
import com.ctrlaltelite.planitbudget.repository.ExpensesRepository;

@SuppressWarnings("null")
@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepo;

    /*
     * saves Expenses to the repository (db)
     */
    public void saveExpenses(Expenses expenses) {
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
}
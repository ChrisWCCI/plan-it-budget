package com.ctrlaltelite.planitbudget.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import com.ctrlaltelite.planitbudget.entity.Expenses;
import com.ctrlaltelite.planitbudget.service.ExpensesService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ExpensesController {

    @Autowired
    private ExpensesService expensesServ;

    // used as a way to make sure mapping is working
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    // save an Expense
    @PostMapping()
    public void saveExpenses(@RequestBody Expenses expenses) {
        this.expensesServ.saveExpenses(expenses);
    }

    // this allows us to get all
    @GetMapping()
    public List<Expenses> findAllExpenses() {
        return this.expensesServ.getAllExpenses();
    }

    // this allows us to find an Expenses by it Id
    @GetMapping("/{id}")
    public Expenses findExpensesById(@PathVariable long id) {
        return this.expensesServ.getExpensesById(id);
    }

    // this allows us to delete an expense based on its Id
    @DeleteMapping("/{id}")
    public void removeExpenses(@PathVariable long id) {
        this.expensesServ.deleteExpenses(id);
    }

    /**
     * Method to get Expenses by transactionDate
     */
    @GetMapping("transactionDate/{transactionDate}")
    public Iterable<Expenses> getByTransactionDate(@PathVariable LocalDate transactionDate) {
        return expensesServ.findByTransactionDate(transactionDate);
    }

    /**
     * Method to get Expenses by expenseName
     */
    @GetMapping("expenseName/{expenseName}")
    public Iterable<Expenses> findByExpenseName(@PathVariable String expenseName) {
        return expensesServ.findByExpenseName(expenseName);
    }

    /**
     * Method to get Expenses by chargeAmount
     */
    @GetMapping("paycheckAmount/{paycheckAmount}")
    public Iterable<Expenses> findByChargeAmount(@PathVariable Double chargeAmount) {
        return expensesServ.findByChargeAmount(chargeAmount);
    }
}
package com.ctrlaltelite.planitbudget.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
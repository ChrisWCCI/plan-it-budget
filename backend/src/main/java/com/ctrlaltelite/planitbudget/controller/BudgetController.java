package com.ctrlaltelite.planitbudget.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ctrlaltelite.planitbudget.entity.Budget;
import com.ctrlaltelite.planitbudget.service.BudgetService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/budget")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class BudgetController {

    @Autowired
    private BudgetService budgetServ;

    // used as a way to make sure mapping is working
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    // save a Budget
    @PostMapping()
    public ResponseEntity<Budget> saveBudget(@RequestBody Budget budget) {
        Budget savedBudget = this.budgetServ.saveBudget(budget);
        return new ResponseEntity<>(savedBudget, HttpStatus.CREATED);
    }

    // this allows us to get all
    @GetMapping()
    public List<Budget> findAllBudget() {
        return this.budgetServ.getAllBudget();
    }

    // this allows us to find a Budget by it Id
    @GetMapping("/{id}")
    public Budget findBudgetById(@PathVariable long id) {
        return this.budgetServ.getBudgetById(id);
    }

    // This allows us to Edit an budget based on its Id
    @PutMapping("/{id}")
    public Budget modifyBudget(@PathVariable long id, @RequestBody Budget updatedBudget) {
        return this.budgetServ.updateBudget(id, updatedBudget);
    }

    // this allows us to delete a debt based on its Id
    @DeleteMapping("/{id}")
    public void removeBudget(@PathVariable long id) {
        this.budgetServ.deleteBudget(id);
    }

    @GetMapping("budgetName/{budgetName}")
    public Iterable<Budget> getByBudgetName(@PathVariable String budgetName) {
        return budgetServ.findByBudgetName(budgetName);
    }

    @GetMapping("max/{max}")
    public Iterable<Budget> getByMax(@PathVariable Double max) {
        return budgetServ.findByMax(max);
    }
}

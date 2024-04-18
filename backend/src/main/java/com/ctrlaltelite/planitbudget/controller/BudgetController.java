package com.ctrlaltelite.planitbudget.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveCategories(@RequestBody Budget budget) {
        this.budgetServ.saveCategories(budget);
    }

    // this allows us to get all
    @GetMapping()
    public List<Budget> findAllCategories() {
        return this.budgetServ.getAllCategories();
    }

    // this allows us to find a Budget by it Id
    @GetMapping("/{id}")
    public Budget findCategoriesById(@PathVariable long id) {
        return this.budgetServ.getCategoriesById(id);
    }

    // this allows us to delete a debt based on its Id
    @DeleteMapping("/{id}")
    public void removeCategories(@PathVariable long id) {
        this.budgetServ.deleteCategories(id);
    }

    @GetMapping("budgetName/{budgetName}")
    public Iterable<Budget> getByCategoryName(@PathVariable String budgetName) {
        return budgetServ.findByCategoryName(budgetName);
    }

    @GetMapping("max/{max}")
    public Iterable<Budget> getByMax(@PathVariable Double max) {
        return budgetServ.findByMax(max);
    }
}

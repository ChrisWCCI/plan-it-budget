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

import com.ctrlaltelite.planitbudget.entity.Income;
import com.ctrlaltelite.planitbudget.service.IncomeService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/Income")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class IncomeController {

    @Autowired
    private IncomeService incomeServ;

    // used as a way to make sure mapping is working
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    // save an Income
    @PostMapping()
    public void saveIncome(@RequestBody Income income) {
        this.incomeServ.saveIncome(income);
    }

    // this allows us to get all
    @GetMapping()
    public List<Income> findAllIncome() {
        return this.incomeServ.getAllIncome();
    }

    // this allows us to find a Income by it Id
    @GetMapping("/{id}")
    public Income findIncomeById(@PathVariable long id) {
        return this.incomeServ.getIncomeById(id);
    }

    // this allows us to delete a debt based on its Id
    @DeleteMapping("/{id}")
    public void removeIncome(@PathVariable long id) {
        this.incomeServ.deleteIncome(id);
    }
}
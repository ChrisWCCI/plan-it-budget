package com.ctrlaltelite.planitbudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ctrlaltelite.planitbudget.entity.Income;
import com.ctrlaltelite.planitbudget.service.IncomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/income")
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
    public ResponseEntity<Income> saveIncome(@RequestBody Income income) {
        Income savedIncome = this.incomeServ.saveIncome(income);
        return new ResponseEntity<>(savedIncome, HttpStatus.CREATED);
    }

    // this allows us to get all
    @GetMapping()
    public Iterable<Income> findAllIncome() {
        return this.incomeServ.getAllIncome();
    }

    // this allows us to find an Income by it Id
    @GetMapping("/{id}")
    public Income findIncomeById(@PathVariable Long id) {
        return this.incomeServ.getIncomeById(id);
    }

    // this allows us to delete an Income based on its Id
    @DeleteMapping("/{id}")
    public void removeIncome(@PathVariable long id) {
        this.incomeServ.deleteIncome(id);
    }

    /**
     * Method to get Income by Date
     */
    @GetMapping("payDate/{payDate}")
    public Iterable<Income> getByPayDate(@PathVariable LocalDate payDate) {
        return incomeServ.findByPayDate(payDate);
    }

    /**
     * Method to get Income by IncomeSource
     */
    @GetMapping("incomeSource/{incomeSource}")
    public Iterable<Income> getByIncomeSource(@PathVariable String incomeSource) {
        return incomeServ.findByIncomeSource(incomeSource);
    }

    /**
     * Method to get Income by PayPeriod
     */
    @GetMapping("payPeriod/{payPeriod}")
    public Iterable<Income> getByPayPeriod(@PathVariable String payPeriod) {
        return incomeServ.findByPayPeriod(payPeriod);
    }

    /**
     * Method to get Income by PaycheckAmount
     */
    @GetMapping("paycheckAmount/{paycheckAmount}")
    public Iterable<Income> getByPaycheckAmount(@PathVariable Double paycheckAmount) {
        return incomeServ.findByPaycheckAmount(paycheckAmount);
    }

}
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

import com.ctrlaltelite.planitbudget.entity.Debts;
import com.ctrlaltelite.planitbudget.service.DebtsService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/debts")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class DebtsController {

    @Autowired
    private DebtsService debtsServ;

    // used as a way to make sure mapping is working
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    // save a debts
    @PostMapping()
    public void saveDebts(@RequestBody Debts debts) {
        this.debtsServ.saveDebts(debts);
    }

    // this allows us to get all
    @GetMapping()
    public List<Debts> findAllDebts() {
        return this.debtsServ.getAllDebts();
    }

    // this allows us to find a debts by it Id
    @GetMapping("/{id}")
    public Debts findDebtsById(@PathVariable long id) {
        return this.debtsServ.getDebtsById(id);
    }

    // this allows us to delete a debt based on its Id
    @DeleteMapping("/{id}")
    public void removeDebts(@PathVariable long id) {
        this.debtsServ.deleteDebts(id);
    }

    /**
     * Method to get Debts by DebtsSource
     */
    @GetMapping("debtName/{debtName}")
    public Iterable<Debts> getByDebtName(@PathVariable String DebtName) {
        return debtsServ.findByDebtName(DebtName);
    }

    /**
     * Method to get Debts by PayPeriod
     */
    @GetMapping("timeSpan/{timeSpan}")
    public Iterable<Debts> getByTimeSpan(@PathVariable String timeSpan) {
        return debtsServ.findByTimeSpan(timeSpan);
    }

    /**
     * Method to get Debts by PaycheckAmount
     */
    @GetMapping("monthlyAmount/{monthlyAmount}")
    public Iterable<Debts> getByMonthlyAmount(@PathVariable Double monthlyAmount) {
        return debtsServ.findByMonthlyAmount(monthlyAmount);
    }

    /**
     * Method to get Debts by PaycheckAmount
     */
    @GetMapping("balance/{balance}")
    public Iterable<Debts> getByBalance(@PathVariable Double balance) {
        return debtsServ.findByBalance(balance);
    }
}

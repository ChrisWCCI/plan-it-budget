package com.ctrlaltelite.planitbudget.service;

import java.util.*;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.entity.Debts;
import com.ctrlaltelite.planitbudget.repository.DebtsRepository;

@SuppressWarnings("null")
@Service
public class DebtsService {

    @Autowired
    private DebtsRepository debtsRepo;

    /**
     * Default Constructor
     */
    public DebtsService() {
    }

    /*
     * saves Debts to the repository (db)
     */
    public void saveDebts(Debts debts) {
        double tempMonthlyAmount = debts.getMonthlyAmount();
        DecimalFormat dollarCentsFormat = new DecimalFormat("#.##");
        debts.setMonthlyAmount(Double.parseDouble(dollarCentsFormat.format(tempMonthlyAmount)));
        this.debtsRepo.save(debts);
    }

    /*
     * Gets all the Debts that were saved (db)
     */
    public List<Debts> getAllDebts() {
        return this.debtsRepo.findAll();
    }

    // delete a saved Debts per selected Id
    public void deleteDebts(long id) {
        this.debtsRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found: " + id));
        this.debtsRepo.deleteById(id);
    }

    /*
     * Gets a specific Debts by its id
     */
    public Debts getDebtsById(long id) {
        return this.debtsRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found: " + id));
    }

    /**
     * Method to find an debt by debtName
     */
    public Iterable<Debts> findByDebtName(String debtName) {
        Iterable<Debts> debts = new ArrayList<>();
        try {
            debts = debtsRepo.findByDebtName(debtName);
        } catch (Exception ex) {
            throw ex;
        }
        return debts;
    }

    /**
     * Method to find an debt by timespan
     */
    public Iterable<Debts> findByTimeSpan(String timeSpan) {
        Iterable<Debts> debts = new ArrayList<>();
        try {
            debts = debtsRepo.findByTimeSpan(timeSpan);
        } catch (Exception ex) {
            throw ex;
        }
        return debts;
    }

    /**
     * Method to find an Debt by MonthlyAmount
     */
    public Iterable<Debts> findByMonthlyAmount(Double monthlyAmount) {
        Iterable<Debts> debts = new ArrayList<>();
        try {
            debts = debtsRepo.findByMonthlyAmount(monthlyAmount);
        } catch (Exception ex) {
            throw ex;
        }
        return debts;
    }
}
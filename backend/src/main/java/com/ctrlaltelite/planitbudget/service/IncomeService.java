package com.ctrlaltelite.planitbudget.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.entity.Income;
import com.ctrlaltelite.planitbudget.repository.IncomeRepository;

@SuppressWarnings("null")
@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepo;

    /**
     * Default Constructor
     */
    public IncomeService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param organicPetRepository organic pet repository
     */
    public IncomeService(IncomeRepository incomeRepo) {
        this.incomeRepo = incomeRepo;
    }

    /*
     * saves income to the repository (db)
     */
    public Income saveIncome(Income income) {
        return this.incomeRepo.save(income);
    }

    /*
     * Gets all the income that were saved (db)
     */
    public List<Income> getAllIncome() {
        return this.incomeRepo.findAll();
    }

    // delete a saved Income per selected Id
    public void deleteIncome(long id) {
        this.incomeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found: " + id));
        this.incomeRepo.deleteById(id);
    }

    /*
     * Gets a specific Income by its id
     */
    public Income getIncomeById(long id) {
        return this.incomeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found: " + id));
    }

    /**
     * Method to find an Income by date
     */
    public Iterable<Income> findByDate(String date) {
        Iterable<Income> income = new ArrayList<>();
        try {
            income = incomeRepo.findByDate(date);
        } catch (Exception ex) {
            throw ex;
        }
        return income;
    }

    /**
     * Method to find an Income by IncomeSource
     */
    public Iterable<Income> findByIncomeSource(String incomeSource) {
        Iterable<Income> income = new ArrayList<>();
        try {
            income = incomeRepo.findByIncomeSource(incomeSource);
        } catch (Exception ex) {
            throw ex;
        }
        return income;
    }

    /**
     * Method to find an Income by PayPeriod
     */
    public Iterable<Income> findByPayPeriod(String payPeriod) {
        Iterable<Income> income = new ArrayList<>();
        try {
            income = incomeRepo.findByPayPeriod(payPeriod);
        } catch (Exception ex) {
            throw ex;
        }
        return income;
    }

    /**
     * Method to find an Income by PaycheckAmount
     */
    public Iterable<Income> findByPaycheckAmount(Double paycheckAmount) {
        Iterable<Income> income = new ArrayList<>();
        try {
            income = incomeRepo.findByPaycheckAmount(paycheckAmount);
        } catch (Exception ex) {
            throw ex;
        }
        return income;
    }

    /**
     * Method to find an Income by monthlyCalculated
     */
    public Iterable<Income> findByMonthlyCalculatedAmount(Double monthlyCalculatedAmount) {
        Iterable<Income> income = new ArrayList<>();
        try {
            income = incomeRepo.findByMonthlyCalculatedAmount(monthlyCalculatedAmount);
        } catch (Exception ex) {
            throw ex;
        }
        return income;
    }

    /**
     * Method to find an Income by usableIncome
     */
    public Iterable<Income> findByUsableIncome(Double usableIncome) {
        Iterable<Income> income = new ArrayList<>();
        try {
            income = incomeRepo.findByUsableIncome(usableIncome);
        } catch (Exception ex) {
            throw ex;
        }
        return income;
    }

}
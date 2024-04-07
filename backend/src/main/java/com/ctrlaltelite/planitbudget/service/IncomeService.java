package com.ctrlaltelite.planitbudget.service;

import java.util.List;

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

    /*
     * saves income to the repository (db)
     */
    public void saveIncome(Income income) {
        this.incomeRepo.save(income);
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
}
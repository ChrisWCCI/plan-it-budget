package com.ctrlaltelite.planitbudget.service;

import java.util.List;

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

    /*
     * saves Debts to the repository (db)
     */
    public void saveDebts(Debts debts) {
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
}
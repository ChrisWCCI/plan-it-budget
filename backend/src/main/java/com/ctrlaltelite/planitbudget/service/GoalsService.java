package com.ctrlaltelite.planitbudget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.entity.Goals;
import com.ctrlaltelite.planitbudget.repository.GoalsRepository;

@SuppressWarnings("null")
@Service
public class GoalsService {

    @Autowired
    private GoalsRepository goalsRepo;

    /*
     * saves goals to the repository (db)
     */
    public void saveGoals(Goals goals) {
        this.goalsRepo.save(goals);
    }

    /*
     * Gets all the goals that were saved (db)
     */
    public List<Goals> getAllGoals() {
        return this.goalsRepo.findAll();
    }

    // delete a saved goal per selected Id
    public void deleteGoals(long id) {
        this.goalsRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal not found: " + id));
        this.goalsRepo.deleteById(id);
    }

    /*
     * Gets a specific goal by its id
     */
    public Goals getGoalsById(long id) {
        return this.goalsRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal not found: " + id));
    }
}
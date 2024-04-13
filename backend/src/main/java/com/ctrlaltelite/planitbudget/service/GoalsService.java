package com.ctrlaltelite.planitbudget.service;

import java.util.*;

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

    /**
     * Default Constructor
     */
    public GoalsService() {
    }

    /*
     * saves goals to the repository (db)
     */
    public Goals saveGoals(Goals goals) {
        return this.goalsRepo.save(goals);
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

    /**
     * Method to find an Goals by GoalName
     */
    public Iterable<Goals> findByGoalName(String goalName) {
        Iterable<Goals> goals = new ArrayList<>();
        try {
            goals = goalsRepo.findByGoalName(goalName);
        } catch (Exception ex) {
            throw ex;
        }
        return goals;
    }

    /**
     * Method to find an Goals by goalAmount
     */
    public Iterable<Goals> findByGoalAmount(Double goalAmount) {
        Iterable<Goals> goals = new ArrayList<>();
        try {
            goals = goalsRepo.findByGoalAmount(goalAmount);
        } catch (Exception ex) {
            throw ex;
        }
        return goals;
    }

    /**
     * Method to find an Goals by monthlyContribution
     */
    public Iterable<Goals> findByMonthlyContribution(Double monthlyContribution) {
        Iterable<Goals> goals = new ArrayList<>();
        try {
            goals = goalsRepo.findByMonthlyContribution(monthlyContribution);
        } catch (Exception ex) {
            throw ex;
        }
        return goals;
    }

    /**
     * Method to find an Goals by PaycheckAmount
     */
    public Iterable<Goals> findByTimeSpan(String timeSpan) {
        Iterable<Goals> goals = new ArrayList<>();
        try {
            goals = goalsRepo.findByTimeSpan(timeSpan);
        } catch (Exception ex) {
            throw ex;
        }
        return goals;
    }

}
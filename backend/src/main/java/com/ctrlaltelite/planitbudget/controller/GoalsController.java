package com.ctrlaltelite.planitbudget.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ctrlaltelite.planitbudget.entity.Goals;
import com.ctrlaltelite.planitbudget.service.GoalsService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class GoalsController {

    @Autowired
    private GoalsService goalsServ;

    // used as a way to make sure mapping is working
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    // save a Goals
    @PostMapping()
    public void saveGoals(@RequestBody Goals goals) {
        this.goalsServ.saveGoals(goals);
    }

    // this allows us to get all
    @GetMapping()
    public List<Goals> findAllGoals() {
        return this.goalsServ.getAllGoals();
    }

    // this allows us to find a Goals by it Id
    @GetMapping("/{id}")
    public Goals findGoalsById(@PathVariable long id) {
        return this.goalsServ.getGoalsById(id);
    }

    // this allows us to delete a goal based on its Id
    @DeleteMapping("/{id}")
    public void removeGoals(@PathVariable long id) {
        this.goalsServ.deleteGoals(id);
    }

    /**
     * Method to get Goals by goalName
     */
    @GetMapping("goalName/{goalName}")
    public Iterable<Goals> getByGoalName(@PathVariable String goalName) {
        return goalsServ.findByGoalName(goalName);
    }

    /**
     * Method to get Goals by goalAmount
     */
    @GetMapping("goalAmount/{goalAmount}")
    public Iterable<Goals> getByGoalAmount(@PathVariable Double goalAmount) {
        return goalsServ.findByGoalAmount(goalAmount);
    }

    /**
     * Method to get Goals by MonthlyContribution
     */
    @GetMapping("monthlyContribution/{monthlyContribution}")
    public Iterable<Goals> getByMonthlyContribution(@PathVariable Double monthlyContribution) {
        return goalsServ.findByMonthlyContribution(monthlyContribution);
    }

    /**
     * Method to get Goals by timeSpan
     */
    @GetMapping("paycheckAmount/{paycheckAmount}")
    public Iterable<Goals> getByTimeSpan(@PathVariable String timeSpan) {
        return goalsServ.findByTimeSpan(timeSpan);
    }
}
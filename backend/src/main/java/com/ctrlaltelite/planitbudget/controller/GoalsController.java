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

    // this allows us to delete a debt based on its Id
    @DeleteMapping("/{id}")
    public void removeGoals(@PathVariable long id) {
        this.goalsServ.deleteGoals(id);
    }
}
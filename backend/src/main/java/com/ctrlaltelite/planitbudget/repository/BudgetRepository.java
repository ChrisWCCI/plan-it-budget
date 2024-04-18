package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltelite.planitbudget.entity.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Iterable<Budget> findByBudgetName(String budgetName);

    Iterable<Budget> findByMax(Double max);


}
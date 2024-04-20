package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltelite.planitbudget.entity.Budget;
import com.ctrlaltelite.planitbudget.entity.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    Iterable<Expenses> findByDescription(String description);

    Iterable<Expenses> findByChargeAmount(Double chargeAmount);

    void deleteByBudget(Budget budget);
}

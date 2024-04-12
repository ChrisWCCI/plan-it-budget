package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltelite.planitbudget.entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    Iterable<Income> findByDate(String date);

    Iterable<Income> findByIncomeSource(String incomeSource);

    Iterable<Income> findByPayPeriod(String payPeriod);

    Iterable<Income> findByPaycheckAmount(Double paycheckAmount);

    Iterable<Income> findByNumberOfPaychecksForTheMonth(int numberOfPaychecksForTheMonth);

    Iterable<Income> findByMonthlyCalculatedAmount(Double monthlyCalculatedAmount);

    Iterable<Income> findByUsableIncome(Double usableIncome);

}

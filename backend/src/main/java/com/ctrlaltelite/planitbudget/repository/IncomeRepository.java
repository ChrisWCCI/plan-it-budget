package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

import com.ctrlaltelite.planitbudget.entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    Iterable<Income> findByPayDate(LocalDate payDate);

    Iterable<Income> findByIncomeSource(String incomeSource);

    Iterable<Income> findByPayPeriod(String payPeriod);

    Iterable<Income> findByPaycheckAmount(Double paycheckAmount);
    
}

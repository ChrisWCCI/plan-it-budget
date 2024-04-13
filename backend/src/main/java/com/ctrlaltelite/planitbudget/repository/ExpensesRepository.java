package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

import com.ctrlaltelite.planitbudget.entity.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    Iterable<Expenses> findByTransactionDate(LocalDate transactionDate);

    Iterable<Expenses> findByExpenseName(String expenseName);

    Iterable<Expenses> findByChargeAmount(Double chargeAmount);

}

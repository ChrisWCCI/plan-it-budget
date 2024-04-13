package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltelite.planitbudget.entity.Debts;

@Repository
public interface DebtsRepository extends JpaRepository<Debts, Long> {

    Iterable<Debts> findByDebtName(String debtName);

    Iterable<Debts> findByTimeSpan(String timeSpan);

    Iterable<Debts> findByMonthlyAmount(Double monthlyAmount);
}


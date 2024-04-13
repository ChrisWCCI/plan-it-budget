package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltelite.planitbudget.entity.Goals;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Long> {

    Iterable<Goals> findByGoalName(String goalName);

    Iterable<Goals> findByGoalAmount(Double goalAmount);

    Iterable<Goals> findByMonthlyContribution(Double monthlyContribution);

    Iterable<Goals> findByTimeSpan(String timeSpan);

}

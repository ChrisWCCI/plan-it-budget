package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ctrlaltelite.planitbudget.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}

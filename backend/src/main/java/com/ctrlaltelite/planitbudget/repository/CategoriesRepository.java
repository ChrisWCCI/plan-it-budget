package com.ctrlaltelite.planitbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltelite.planitbudget.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
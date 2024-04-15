package com.ctrlaltelite.planitbudget.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.planitbudget.entity.Categories;
import com.ctrlaltelite.planitbudget.repository.CategoriesRepository;

@SuppressWarnings("null")
@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepo;

    /*
     * saves Categories to the repository (db)
     */
    public void saveCategories(Categories categories) {
        this.categoriesRepo.save(categories);
    }

    /*
     * Gets all the Categories that were saved (db)
     */
    public List<Categories> getAllCategories() {
        return this.categoriesRepo.findAll();
    }

    // delete a saved Categories per selected Id
    public void deleteCategories(long id) {
        this.categoriesRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found: " + id));
        this.categoriesRepo.deleteById(id);
    }

    /*
     * Gets a specific Categories by its id
     */
    public Categories getCategoriesById(long id) {
        return this.categoriesRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found: " + id));
    }

     /**
     * Method to find an category by name
     */
    public Iterable<Categories> findByCategoryName(String categoryName) {
        Iterable<Categories> categories = new ArrayList<>();
        try {
            categories = categoriesRepo.findByCategoryName(categoryName);
        } catch (Exception ex) {
            throw ex;
        }
        return categories;
    }
}

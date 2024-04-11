package com.ctrlaltelite.planitbudget.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlaltelite.planitbudget.entity.Categories;
import com.ctrlaltelite.planitbudget.service.CategoriesService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CategoriesController {

    @Autowired
    private CategoriesService categoriesServ;

    // used as a way to make sure mapping is working
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    // save a Categories
    @PostMapping()
    public void saveCategories(@RequestBody Categories categories) {
        this.categoriesServ.saveCategories(categories);
    }

    // this allows us to get all
    @GetMapping()
    public List<Categories> findAllCategories() {
        return this.categoriesServ.getAllCategories();
    }

    // this allows us to find a Categories by it Id
    @GetMapping("/{id}")
    public Categories findCategoriesById(@PathVariable long id) {
        return this.categoriesServ.getCategoriesById(id);
    }

    // this allows us to delete a debt based on its Id
    @DeleteMapping("/{id}")
    public void removeCategories(@PathVariable long id) {
        this.categoriesServ.deleteCategories(id);
    }
}
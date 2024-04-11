package com.ctrlaltelite.planitbudget.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"category\"")

public class Categories {
    public Categories() {
    }

    public Categories(Long money) {

    }

    @Id
@Column()
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@Column()
private String categoryName;


}
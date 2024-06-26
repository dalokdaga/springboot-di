package com.daniel.springboot.di.app.springbootdi.services;

import java.util.List;

import com.daniel.springboot.di.app.springbootdi.models.Product;

public interface ProductService {
    
    List<Product> findAll();
    
    Product findById(Long id);
}

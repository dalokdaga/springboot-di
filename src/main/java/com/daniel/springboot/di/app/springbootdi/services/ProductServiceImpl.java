package com.daniel.springboot.di.app.springbootdi.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.springboot.di.app.springbootdi.models.Product;
import com.daniel.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository repository;

    // @Autowired
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }
    
    
    // public ProductServiceImpl(ProductRepository repository) {
    //     this.repository = repository;
    // }


    // public ProductServiceImpl() {
    // }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }
    
    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
package com.daniel.springboot.di.app.springbootdi.repositories;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.daniel.springboot.di.app.springbootdi.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    
    List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria conrsair 32", 300L),
            new Product(2L, "Cpu Intel Core i9", 820L),
            new Product(3L, "Teclado Razer Mini 60%", 180L),
            new Product(4L, "Motherboard", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(data);
    }
    
    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}

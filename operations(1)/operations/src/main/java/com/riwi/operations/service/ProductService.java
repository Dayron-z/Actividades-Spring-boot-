package com.riwi.operations.service;


import com.riwi.operations.entities.Product;
import com.riwi.operations.repository.ProductRepository;
import com.riwi.operations.service.abstract_service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*Beandear = Todas las inyecciones de dependencias tienen que venir de una interfaz*/
@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public Product save(Product objProduct) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Product objProduct) {
        return false;
    }
}

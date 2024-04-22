package com.riwi.operations.controllers;

import com.riwi.operations.entities.Product;
import com.riwi.operations.service.abstract_service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {



    //El detecta que una vez usemos las interfaz, estamos usando como tal el productService (Product service lleva como tal los metodos que nos proporciona el jpaRepository (La inyecciòn de depedendencia que usamos en Product service es "ProductRepository productRepository;")).
    @Autowired
    private final IProductService objProductService;


            //ResponseEntity lo usamos para responder con los status http
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return  ResponseEntity.ok(this.objProductService.getAll());
    }

}

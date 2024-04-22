package com.riwi.operations.service.abstract_service;

import com.riwi.operations.entities.Product;

import java.util.List;


/*Utilizamos una interfaz para ser utilizada como inyección de dependencias en el controlador, mantiene integridad, desacoplamiento y prinicipios solid
 (Prinicipio de la i)*/


public interface IProductService {
    public Product save(Product objProduct);
    public List<Product> getAll();
    public Product getById(Long id);
    public boolean delete(Long id);
    public boolean update(Product objProduct);
}

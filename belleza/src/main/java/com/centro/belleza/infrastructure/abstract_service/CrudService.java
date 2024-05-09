package com.centro.belleza.infrastructure.abstract_service;


/* * RQ = Request
 * RS = Response
 * ID = Tipo de dato de la llave primaria de la entidad*/


import org.springframework.data.domain.Page;

//El genérico recibe todo_ lo que le deseemos pasar para estructurar
public interface CrudService<RQ, RS, ID> {
    public void delete(ID id);
    public RS create(RQ request);
    public RS update(ID id, RQ request);
    public Page<RS> getAll(int page, int  size);
}



package com.centro.belleza.infrastructure.abstract_service;

import com.centro.belleza.api.dto.request.ServicioRequest;
import com.centro.belleza.api.dto.response.ServicioResponse;

public interface IServicioService extends CrudService<ServicioRequest, ServicioResponse, Long>{
    //SI necesitamos métodos muy específicos se hacen desde esta interfaz
    public ServicioResponse getById(Long id);
}

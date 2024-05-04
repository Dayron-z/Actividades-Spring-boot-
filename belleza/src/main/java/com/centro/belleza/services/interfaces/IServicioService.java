package com.centro.belleza.services.interfaces;

import com.centro.belleza.utils.dto.request.ServicioRequest;
import com.centro.belleza.utils.dto.response.ServicioResponse;

public interface IServicioService extends CrudService<ServicioRequest, ServicioResponse, Long>{
    //SI necesitamos métodos muy específicos se hacen desde esta interfaz
    public ServicioResponse getById(Long id);
}

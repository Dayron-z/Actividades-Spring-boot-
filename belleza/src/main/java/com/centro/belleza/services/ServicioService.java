package com.centro.belleza.services;

import com.centro.belleza.entities.Cita;
import com.centro.belleza.entities.Servicio;
import com.centro.belleza.repositories.ServicioRepository;
import com.centro.belleza.services.interfaces.IServicioService;
import com.centro.belleza.utils.dto.request.ServicioRequest;
import com.centro.belleza.utils.dto.response.CitaToServiceResponse;
import com.centro.belleza.utils.dto.response.ServicioResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ServicioService implements IServicioService {

    //Inyectamos el repository
    @Autowired
    private final ServicioRepository servicioRepository;


    @Override
    public void delete(Long aLong) {

    }

    @Override
    public ServicioResponse create(ServicioRequest request) {
        //Convertimos el ServicioRequest en la entidad
        Servicio servicio = this.requestToEntity(request, new Servicio());


        //El repository como tal recibe a la entidad base
        //El mapeo que le realizamos para que pase a entityToResponse es lo que genera la respuesta con nuestras especificaciones
        return this.entityToResponse(this.servicioRepository.save(servicio));
    }

    @Override
    public ServicioResponse update(Long aLong, ServicioRequest request) {
        return null;
    }

    @Override
    public Page<ServicioResponse> getAll(int page, int size) {

        if (page < 0){
            page = 0;
        }


         PageRequest objPage = PageRequest.of(page, size);

        //Necesitamos companyResponse que es el dto.
        return this.servicioRepository.findAll(objPage).map(servicio -> this.entityToResponse(servicio));


           /* return this.servicioRepository.findAll(objPage) retorna como tal Page<Servicio> pero necesitamos retorna es el <ServicioResponse>, esto en la diapositiva es el mapeo de datos*/

        //(expresiones lambda 1 (Primera forma) - Flecha 2  (Segunda forma)  - inferencial)
        // Queremos mapear cada servicio, por ende el iterador que es cada servicio es el que se mapea

    }
        //Método para pasar de entidad a response
        //Acá es donde vamos a mapear
        private ServicioResponse entityToResponse(Servicio entity){
        ServicioResponse response = new ServicioResponse();
        BeanUtils.copyProperties(entity, response);
        //Como tal lo que hacemos acá es setear atributos pero mediante anotación
        //Retornamos reponse que es el directamente mutado

            //Mapeamos las citas conviritiendo cada una de ellas al dto respuesta que le queremos dar al usuario (ServicioResponse que creamos)

            //Como tal necesitamos recuperar los datos de la cita, para eso usamos CitaToServiceResponse que nos proporciona el método citaToResponse
            //Que es el response que generamos en la carpeta dto, que me proporciona los datos de la cita, sin el servicio
            response.setCitas(entity.getCitas().stream().map(cita -> this.citaToResponse(cita)).collect(Collectors.toList()));


        return response;
        }




        private CitaToServiceResponse citaToResponse(Cita entity){
            CitaToServiceResponse response = new CitaToServiceResponse();
            BeanUtils.copyProperties(entity, response);


            return response;
        }



        private Servicio requestToEntity(ServicioRequest request, Servicio servicio){
            BeanUtils.copyProperties(request, servicio);
            servicio.setCitas(new ArrayList<>());

            return servicio;
        }




}

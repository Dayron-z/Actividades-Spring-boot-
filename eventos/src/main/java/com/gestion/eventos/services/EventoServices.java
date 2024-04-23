package com.gestion.eventos.services;

import com.gestion.eventos.entities.Evento;
import com.gestion.eventos.repository.EventoRepository;
import com.gestion.eventos.services.abstract_services.IEventoServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Implementamos la interfaz que creamos para EventoServices, hasta acá sigue un flujo común, por ende, tomamos a todo_ lo relacionado por service como un flujo lógico
@Service
@AllArgsConstructor
public class EventoServices implements IEventoServices {
    //Una vez aplicamos los términos del "contrato" (Usamos los métodos de la interfaz)
       //-- Procedemos a hacer una inyección de dependencia de la clase interfaz, EventoRepository

    @Autowired
    private final EventoRepository objEventoRepository;

    @Override
    public Evento guardar(Evento objEvento) {
        return this.objEventoRepository.save(objEvento);
    }
    @Override
    public List<Evento> listarEventos() {
        return null;
    }
    @Override
    public Evento findById(String id) {
        return null;
    }
    @Override
    public boolean actualizar(Evento objEvento) {
        return false;
    }
    @Override
    public boolean eliminar(String id) {
        return false;
    }
}

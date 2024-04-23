package com.gestion.eventos.services.abstract_services;

import com.gestion.eventos.entities.Evento;

import java.util.List;

//Al ser una interfaz creada por nosotros para nuestro proyecto, no extendemos de ninguna clase, es el contrato que llevaremos a cabo para el service.
//Modificar en caso de ser necesario, borrar esto en caso de no modificar.
public interface IEventoServices {
    //Entiendo para que necesitamos el objeto, no entiendo para que lo retorno
    public Evento guardar(Evento objEvento);
    public List<Evento> listarEventos();
    public Evento findById(String id);
    public boolean actualizar(Evento objEvento);
    public boolean eliminar(String id);
}


package com.gestion.eventos.controller;

import com.gestion.eventos.entities.Evento;
import com.gestion.eventos.services.abstract_services.IEventoServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/evento")
@AllArgsConstructor
public class EventoController {
    //Inyección de dependencias
    //Haremos inyeccion de la interfaz IEventoServices
    @Autowired
    private final IEventoServices objIEventoServices;

    @PostMapping("/crear")
    /*    @RequestBody permite que un método de controlador tome un objeto automáticamente deserializado del cuerpo de una solicitud HTTP, utilizando convertidores de mensajes HTTP.*/

    /*@RequestBody en Spring MVC es una herramienta poderosa para recibir datos estructurados en el cuerpo de una solicitud HTTP y mapearlos directamente a objetos Java correspondientes, facilitando así la manipulación de datos en tus controladores.*/

    public ResponseEntity<String> crear(@RequestBody Evento objEvento){
        // Guardar el objeto que nos llega en la solicitud POST en la base de datos
        objIEventoServices.guardar(objEvento);
        // Retornar una respuesta indicando que el objeto ha sido creado satisfactoriamente
        return ResponseEntity.status(HttpStatus.CREATED).body("Objeto creado satisfactoriamente");
    }





}

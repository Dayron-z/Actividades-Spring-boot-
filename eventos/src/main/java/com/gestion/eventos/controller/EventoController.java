package com.gestion.eventos.controller;

import com.gestion.eventos.entities.Evento;
import com.gestion.eventos.services.abstract_services.IEventoServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evento")
@AllArgsConstructor
public class EventoController {
    //Inyección de dependencias
    //Haremos inyeccion de la interfaz IEventoServices
    @Autowired
    private final IEventoServices objIEventoServices;

    @PostMapping
    /*    @RequestBody permite que un método de controlador tome un objeto automáticamente deserializado del cuerpo de una solicitud HTTP, utilizando convertidores de mensajes HTTP.*/

    /*@RequestBody en Spring MVC es una herramienta poderosa para recibir datos estructurados en el cuerpo de una solicitud HTTP y mapearlos directamente a objetos Java correspondientes, facilitando así la manipulación de datos en tus controladores.*/
    public ResponseEntity<String> crear(@RequestBody Evento objEvento){
        // Guardar el objeto que nos llega en la solicitud POST en la base de datos
        objIEventoServices.guardar(objEvento);
        // Retornar una respuesta indicando que el objeto ha sido creado satisfactoriamente
        return ResponseEntity.status(HttpStatus.CREATED).body("Objeto creado satisfactoriamente");
    }


    @GetMapping
    public ResponseEntity<List<Evento>>listarEventos(){
        List<Evento> listaDeEventos = this.objIEventoServices.listarEventos();
        return ResponseEntity.ok(listaDeEventos);
    }



    //Se puede dejar el getMapping sin especificar pero en este caso que haremos uso de un extracto del http
    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> BuscarPorId(@PathVariable String id){
        Evento objEvento = this.objIEventoServices.findById(id);
        return ResponseEntity.ok(objEvento);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> editarEvento(@RequestBody Evento objEvento){
        //Lo que queremos hacer con los dos parametros que recibimos es lo siguiente:
            /*1-*/ /*Con el id buscamos el objeto especifico que deseamos modificar*/
            /*2-*/ /*EL RequestBody que seria la deserialización, obtenemos el objeto que nos debe proporcionar el usuario con los nuevos datos*/
        Boolean validacion = this.objIEventoServices.actualizar(objEvento);

        if (validacion == true){
            return ResponseEntity.ok("Eliminado corecctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El evento con el ID " +   objEvento  + " no ha sido encontrado");
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEvento(@PathVariable String id){
        Boolean validacion = this.objIEventoServices.eliminar(id);
        if (validacion == true){
            return ResponseEntity.ok("Eliminado corecctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El evento con el ID " + id + " no ha sido encontrado");
        }

    }


}

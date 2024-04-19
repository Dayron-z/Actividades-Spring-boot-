package com.todo_list.ToDoList.controller;

import com.todo_list.ToDoList.entity.Tarea;
import com.todo_list.ToDoList.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/*Creamos la ruta con la que accedemos como base de la url, en este caso es como indexar lo consiguiente a localhost:8080*/
@RequestMapping
public class TareaControlller {
    @Autowired
    private TareaService objTareaService;

    public String mostrarTarea(Model objModel,
            /*Definir RequestParam cuando se entienda el concepto
                   * En Spring Boot, @RequestParam es una anotación que se utiliza para vincular los parámetros de una solicitud HTTP a los parámetros de un método de controlador en un controlador de Spring.
                               *
                               * */
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "2") int size
                               ){
        Page<Tarea> listaDeTareas = this.objTareaService.findAllPaginate(page - 1, size);

        //El model es el envío de datos a la vista. Con addAttribute llenamos el carrito de cierta manera.
        objModel.addAttribute("listaTareas", listaDeTareas);  /*Clave - Valor*/
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPage", listaDeTareas.getTotalPages());
        return "viewCoders";
    }





}

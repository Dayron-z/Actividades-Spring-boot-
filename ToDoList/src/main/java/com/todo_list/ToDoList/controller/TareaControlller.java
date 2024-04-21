package com.todo_list.ToDoList.controller;

import com.todo_list.ToDoList.entity.Tarea;
import com.todo_list.ToDoList.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;


/*Creamos la ruta con la que accedemos como base de la url, en este caso es como indexar lo consiguiente a localhost:8080*/
@Controller
@RequestMapping("/")
public class TareaControlller {
    @Autowired
    private TareaService objTareaService;

    @GetMapping
    /*Definir RequestParam cuando se entienda el concepto
     * En Spring Boot, @RequestParam es una anotación que se utiliza para vincular los parámetros de una solicitud HTTP a los parámetros de un método de controlador en un controlador de Spring.
     *
     * */
    public String mostrarTarea(Model objModel,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "5") int size
    ) {
        Page<Tarea> listaDeTareas = this.objTareaService.findAllPaginate(page - 1, size);

        //El model es el envío de datos a la vista. Con addAttribute llenamos el carrito de cierta manera.
        objModel.addAttribute("listaTareas", listaDeTareas);  /*Clave - Valor*/
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPage", listaDeTareas.getTotalPages());
        return "ToDoList";
    }


    @GetMapping("tarea")
    public String showViewForm(Model model) {
        //Creamos un objeto tarea vacio cada que ingresemos a esa url

        /* En el controlador, cuando creas una nueva instancia de Tarea, estableces los valores para fechaCreacion y horaCreacion utilizando LocalDate.now() y LocalTime.now(), respectivamente. Estos valores son parte del objeto Tarea, pero aún no se envían al formulario HTML.*/

        Tarea objTarea = new Tarea();
        objTarea.setFechaCreacion(LocalDate.now());
        objTarea.setHoraCreacion(LocalTime.now());

        model.addAttribute("nuevaTarea", objTarea);
        //Una vez el objeto vacío sea creado le proporcionamos una
        model.addAttribute("action", "/crear-tarea");
        //Una vez accedamos a la vista de
        return "tareas";
    }


    @PostMapping("crear-tarea")
    public String crearTarea(@ModelAttribute Tarea objTarea) {
        this.objTareaService.crearTarea(objTarea);

        return "redirect:/";
    }


    @GetMapping("/eliminar/{id}")
    public String elimnarTarea(@PathVariable Long id){
        this.objTareaService.eliminarTarea(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String editarTarea(@PathVariable Long id, Model model){
        //Obtenemos la tarea
        Tarea objTarea =  this.objTareaService.findById(id);
        model.addAttribute("nuevaTarea", objTarea);
        model.addAttribute("action", "/edit/" + id);


        return "tareas";
    }


        @PostMapping("edit/{id}")
        public String editarTarea(@PathVariable Long id, @ModelAttribute Tarea objTarea) {
            this.objTareaService.editarTarea(id, objTarea);
            return "redirect:/";
        }











}

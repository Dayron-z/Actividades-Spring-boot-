package com.todo_list.ToDoList.service;


import com.todo_list.ToDoList.entity.Tarea;
import com.todo_list.ToDoList.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    //Hacemos la inyección de dependencias
    @Autowired
    private TareaRepository objTareaRepository;


    //El service tiene que ver con la logica del negocio por cual accedemos a todos los metodos que nos proporciona repository para que desde el controller se invoquen desde una inyecciòn de dependencias ya

    public List<Tarea> findAll(){
        return this.objTareaRepository.findAll();
    }



    //Desde acá le indicamos la pagina y
    public Page<Tarea> findAllPaginate(int page, int size) {
        /* Validar que la página no sea menor a 0 */
        if (page < 0) {
            page = 0;
        }

        /* Crear la paginación */
        Pageable objPage = PageRequest.of(page, size);
        return this.objTareaRepository.findAll(objPage);
    }



}

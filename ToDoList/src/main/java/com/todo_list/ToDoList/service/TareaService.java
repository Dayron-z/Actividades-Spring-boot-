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
// Se crea la paginación por medio de una solicitud, en el cual se le indica la página que queremos visualizar y la cantidad de datos que deseamos ver en cada consulta de página
        Pageable objPage = PageRequest.of(page, size);

        /*Entonces tengamos en cuenta que find all hace una consulta completa a la base de datos, pero en este caso le vamos a pasar como param*/
        return this.objTareaRepository.findAll(objPage);
    }
    /*Creación de una tarea*/
    public Tarea crearTarea(Tarea objTarea){
        /*Cuando nostros hagamos uso de crear tarea en controller se ejecutrá el save con el cual guardaremos los datos ingresados en la base de datos */
        return this.objTareaRepository.save(objTarea);
    }
    public void eliminarTarea(Long id){
        this.objTareaRepository.deleteById(id);
    }


    //Para editar buscamos por id la tarea especifica
    public Tarea findById(Long id){
        return this.objTareaRepository.findById(id).orElse(null);
    }


    public Tarea editarTarea(Long id, Tarea tarea){
        /*Buscamos la tarea por el id*/
        Tarea objTarea = this.findById(id);

        if (objTarea == null){
            return null;
        }
        objTarea = tarea;
        /* El método save verifica, si el objeto tiene la llave primaria
         * llena entonces actualizar de lo contrario , crea un nuevo registro
                */
        return this.objTareaRepository.save(objTarea);
    }








}

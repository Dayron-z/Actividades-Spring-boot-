package com.centro.belleza.utils.dto.request;


//No es una entidad, es una clase propia de nuestras aplicación

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder //Estudiar

public class ServicioRequest {
    private String nombre;
    private String descripcion;
    private Double precio;
}



/*
en un DTO (Objeto de Transferencia de Datos) de tipo request se definen los datos que el usuario o el cliente de la aplicación deberá proporcionar al servicio para que este último pueda llevar a cabo una operación específica, como almacenar los datos en la base de datos.

Por lo tanto, un DTO de request contendrá los campos y la estructura necesarios para que la solicitud sea procesada correctamente por el servicio. Estos campos suelen corresponder a los datos que el usuario proporciona a través de la interfaz de usuario, formularios web, aplicaciones móviles u otros medios de entrada de datos.*/

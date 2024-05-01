package com.centro.belleza.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


/*Cambiar este valor no afectará la relación entre las entidades o la forma en que se mapean las relaciones en la base de datos, pero sí determinará el nombre de la tabla en la base de datos.*/
    @Entity(name = "servicio")
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class Servicio {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        /*Con column le damos especificaciones específicas a cada atributo de la entidad*/
        @Column(length = 40, nullable = false)
        private String nombre;
        private String descripcion;
        @Column(nullable = false)
        private Double precio;
/*    fetch EAGER: Carga Ansiosa. Los datos asociados se cargan de inmediato cuando se recupera la entidad principal.
        fetch LAZY: Carga Perezosa. Los datos asociados se cargarán solo cuando se acceda explícitamente a ellos.*/
        //. En este caso, mappedBy se refiere al nombre del atributo en la entidad inversa (Citas) que establece la relación.
        @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private List<Cita> citas;
    }

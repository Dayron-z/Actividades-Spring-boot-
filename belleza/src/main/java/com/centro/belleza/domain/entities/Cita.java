package com.centro.belleza.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity(name = "cita")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private int duracion;
    @Column(nullable = false)
    private String comentario;
    //Muchas citas pueden estar asociadas a un solo cliente.
/*    Por lo tanto, no es tanto que EAGER esté asociado a un "traeme todos", sino que EAGER está asociado a "traeme todo_ esto junto con la entidad principal". EAGER puede ser útil cuando siempre necesitas los datos relacionados cada vez que recuperas la entidad principal.

    Por otro lado, si solo necesitas los datos relacionados en determinadas circunstancias o quieres evitar cargar datos innecesarios, LAZY puede ser una mejor opción.*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;



}

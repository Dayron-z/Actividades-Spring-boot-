package com.centro.belleza.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String primer_nombre;
    @Column(length = 40)
    private String segundo_nombre;
    @Column(length = 40, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String telefono;
    @Column(length = 40, nullable = false)
    private String role;


/*     Un empleado puede tener asignadas múltiples citas.*/
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cita> citas;
}

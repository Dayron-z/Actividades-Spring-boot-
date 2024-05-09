package com.centro.belleza.domain.entities;


import com.centro.belleza.utils.enums.RoleEmployee;
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
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private RoleEmployee role;


/*     Un empleado puede tener asignadas múltiples citas.*/
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cita> citas;
}

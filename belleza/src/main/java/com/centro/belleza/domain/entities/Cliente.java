package com.centro.belleza.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40, nullable = false)
    private String primer_nombre;
    @Column(length = 40)
    private String segundo_nombre;
    @Column(length = 40, nullable = false)
    private String telefono;
    @Column(length = 40, nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cita>citas;
}

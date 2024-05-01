package com.centro.belleza.utils.dto.request;

import com.centro.belleza.entities.Servicio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaRequest {
    private LocalDateTime fecha;
    private int duracion;
    private String comentario;
    private Long servicio_id;
}

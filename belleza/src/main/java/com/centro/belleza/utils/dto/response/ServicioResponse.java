package com.centro.belleza.utils.dto.response;

import com.centro.belleza.entities.Cita;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioResponse {
    private String nombre;
    private String descripcion;
    private Double precio;

    //Esta es opcional según se requiera
    //¿A la hora de ver un servicio queremos ver la lista de citas qué están asociadas?
    private List<Cita> citas;
}

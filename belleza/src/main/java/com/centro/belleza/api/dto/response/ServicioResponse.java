package com.centro.belleza.api.dto.response;

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
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    //Esta es opcional según se requiera
    //¿A la hora de ver un servicio queremos ver la lista de citas qué están asociadas?
    private List<CitaToServiceResponse> citas;
}

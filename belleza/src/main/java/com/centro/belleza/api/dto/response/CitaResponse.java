package com.centro.belleza.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitaResponse {
    private Long id;
    private LocalDateTime fecha;
    private int duracion;

    //Respondemos con servicio response, ya que son los datos que queremos que el usuario pueda ver, pasarle todo_ el servicio sería no darle uso a nuestras respuestas personalizadas
    private ServicioResponse servicio;
}

package com.centro.belleza.api.dto.request;

import jakarta.validation.constraints.*;
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
    @FutureOrPresent(message = "La fecha y hora debe ser futura")
    @NotBlank(message = "La fecha y hora de la cita es requerida")
    private LocalDateTime fecha;
    @Min(value = 5)
    @Max(value = 760)
    @NotNull(message = "La duración es requerida")
    private Integer duracion;
    private String comentario;
    @NotNull(message = "El id del servicio es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long servicioId;
    @NotNull(message = "El id del cliente es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long clienteId;
    @NotNull(message = "El id del empleado es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long empleadoId;
}

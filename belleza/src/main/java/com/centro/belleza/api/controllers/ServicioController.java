package com.centro.belleza.api.controllers;

import com.centro.belleza.infrastructure.abstract_service.IServicioService;
import com.centro.belleza.api.dto.request.ServicioRequest;
import com.centro.belleza.api.dto.response.ServicioResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/servicio")
public class ServicioController  {

    private final IServicioService IServicioService;

    @GetMapping
    public ResponseEntity<Page<ServicioResponse>> get(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size){
        return ResponseEntity.ok(this.IServicioService.getAll(page - 1,size));
    }

    @PostMapping
    public ResponseEntity<ServicioResponse>post(@RequestBody ServicioRequest servicioRequest){
        return ResponseEntity.ok(this.IServicioService.create(servicioRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioResponse>put(@RequestBody ServicioRequest servicioRequest, @PathVariable Long id){
        return ResponseEntity.ok(this.IServicioService.update(id, servicioRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        this.IServicioService.delete(id);
        return ResponseEntity.ok("Usuario eliminado satisfactoriamente") ;
    }





}

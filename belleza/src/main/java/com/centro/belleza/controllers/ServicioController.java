package com.centro.belleza.controllers;

import com.centro.belleza.services.interfaces.IServicioService;
import com.centro.belleza.utils.dto.request.ServicioRequest;
import com.centro.belleza.utils.dto.response.ServicioResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/servicio")
public class ServicioController  {

    private final IServicioService servicioService;

    @GetMapping
    public ResponseEntity<Page<ServicioResponse>> get(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size){
        return ResponseEntity.ok(this.servicioService.getAll(page - 1,size));
    }

    @PostMapping
    public ResponseEntity<ServicioResponse>post(@RequestBody ServicioRequest servicioRequest){
        return ResponseEntity.ok(this.servicioService.create(servicioRequest));
    }






}

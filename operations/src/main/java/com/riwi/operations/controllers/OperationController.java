package com.riwi.operations.controllers;

import com.riwi.operations.entities.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {


    //RequestBody = El usuario me tiene que enviar por cuerpo la misma estructura
    @PostMapping("/sum")
    public String sum(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + " + " + num2  + "=" + (num1 + num2);
    }

    @PostMapping("/rest")
    public String rest(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + "-" + num2  + "=" + (num1 - num2);
    }

    @PostMapping("/div")
    public String div(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + "/" + num2  + "=" + (num1 / num2);
    }

    @PostMapping("/mult")
    public String mult(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + "*" + num2  + "=" + (num1 * num2);
    }

}

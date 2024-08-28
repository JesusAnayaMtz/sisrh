package com.sistema.rh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEcontradooException extends RuntimeException{
    public RecursoNoEcontradooException(String mensaje){
        super(mensaje);
    }
}

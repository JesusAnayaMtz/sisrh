package com.sistema.rh.controller;

import com.sistema.rh.exception.RecursoNoEcontradooException;
import com.sistema.rh.model.Empleado;
import com.sistema.rh.service.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("rh-app")
public class EmpleadoController {

    //se usara para mandar informacion a consola
    private final static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        return empleados;
    }

    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agergar: " + empleado);
        return empleadoServicio.saveEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoId(@PathVariable Long id){
        Empleado empleadoEncontrado = empleadoServicio.findById(id);
        if(empleadoEncontrado == null){
            throw new RecursoNoEcontradooException("No se encontro el id " + id);
        }
        return ResponseEntity.ok(empleadoEncontrado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        Empleado empleadoActualizar = empleadoServicio.findById(id);
        if (empleadoActualizar == null){
            throw new RecursoNoEcontradooException("El id recibido no existe " + id);
        } else {
            empleadoActualizar.setNombre(empleado.getNombre());
            empleadoActualizar.setDepartamento(empleadoActualizar.getDepartamento());
            empleadoActualizar.setSueldo(empleado.getSueldo());

            empleadoServicio.saveEmpleado(empleadoActualizar);

            return ResponseEntity.ok(empleadoActualizar);
        }
    }
}

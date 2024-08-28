package com.sistema.rh.service;

import com.sistema.rh.model.Empleado;
import com.sistema.rh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicio implements IEmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados;
    }

    @Override
    public Empleado findById(Long id) {
        Optional<Empleado> empleadoBuscado = empleadoRepository.findById(id);

        if (empleadoBuscado.isPresent()){
            Empleado empleado = empleadoBuscado.get();
            return empleado;
        } else {
            return null;
        }

    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}

package com.sistema.rh.service;


import com.sistema.rh.model.Empleado;

import java.util.List;

public interface IEmpleadoService {

    public List<Empleado> listarEmpleados();

    public Empleado findById(Long id);

    public Empleado saveEmpleado(Empleado empleado);

    public void deleteEmpleado(Long id);

}

package com.dp.main;
import java.time.LocalDate;
import java.util.List;

import com.dp.implementacion.Empleado;
import com.dp.implementacion1.EmpleadoServiceImpl;
import com.dp.interfaces.Interface;


public class Main {
    public static void main(String[] args) {
    	Interface  empleadoService = new EmpleadoServiceImpl();

       
        Empleado emp1 = new Empleado(1, "Alexander ", "Arquitecto", 25000, LocalDate.of(2020, 1, 15), "Construccion");
        Empleado emp2 = new Empleado(2, "Sofia", "Administracion de empresas", 10000, LocalDate.of(2018, 3, 22), "Administracion");
        
        empleadoService.registrarEmpleado(emp1);
        empleadoService.registrarEmpleado(emp2);

 
        List<Empleado> empleados = empleadoService.listarEmpleados();
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " - " + emp.getPuestoTrabajo());
        }


        double igssEmp1 = empleadoService.calcularIgss(emp1);
        double irtraEmp1 = empleadoService.calcularIrtra(emp1);

        System.out.println("IGSS de " + emp1.getNombre() + ": " + igssEmp1);
        System.out.println("IRTRA de " + emp1.getNombre() + ": " + irtraEmp1);

  
        empleadoService.agregarBono(emp1, 500);
        empleadoService.agregarDescuento(emp1, 200);

        empleadoService.bajarEmpleado(1);

       
        empleados = empleadoService.listarEmpleados();
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " - " + emp.getPuestoTrabajo());
        }
    }
}

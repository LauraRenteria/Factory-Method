/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.grafosciudades.controller;

import co.edu.umanizales.grafosciudades.domain.model.Empleado;
import co.edu.umanizales.grafosciudades.domain.dto.RespuestaDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laura
 */
@RestController
@RequestMapping(path="grafo")
@Validated


public class GrafoCiudadesController 
{        
 List<Empleado> listado = new ArrayList<>();
 
 public GrafoCiudadesController()
 {
 listado.add(new Empleado("Laura Renteria",1500000));
 listado.add(new Empleado("Sebastian Canon",2000000));
 listado.add(new Empleado("Pedro Perez",2080000));
 listado.add(new Empleado("Juan Juarez",1800000));
 listado.add(new Empleado("Alejandro Cardona",1800000));
 }  
    
    @PostMapping
    public Empleado calcularSalarioEmpleado(@RequestBody Empleado empleado)
    {
    empleado.calcularSalario(5, 13000);
    return empleado;
    }
    
    @GetMapping
    public RespuestaDTO obtenerEmpleados()
    {
    if (listado.size()==0)
    {
    return new RespuestaDTO(400,"No hay empleados", null);
    }
    RespuestaDTO resp= new RespuestaDTO(200,"Exitoso", listado);
    return resp;
    
    }
    
    @GetMapping("{texto}")
    public RespuestaDTO ObtenerEmpleadoxContieneTexto
        (@PathVariable("texto")String texto)
    {
          if (listado.size()==0)
    {
    return new RespuestaDTO(400,"No hay empleados", null);
    }
     List<Empleado> listaTex = new ArrayList<>();
       for(Empleado emp: listado)
       {
       if (emp.getNombre().toLowerCase().contains(texto.toLowerCase()))
       {
       listaTex.add(emp);
       }
           }
    return new RespuestaDTO(200, "Exitoso",listaTex);
     
    }
     @GetMapping("{salario1}/{salario2}")
    public RespuestaDTO ObtenerEmpleadoxRangoSalarial(@PathVariable("salario1")
    double salario1, @PathVariable("salario2") double salario2)
    {
        if (salario1>= salario2)
                {
                return new RespuestaDTO(500, "El Salario1 debe ser inferior"
                        + " al salario2", null);
                }
        List<Empleado> listaTemp = new ArrayList<>();
       for(Empleado emp: listado)
       {
       if (emp.getSalario()>=salario1 && emp.getSalario()<= salario2)
       {
       listaTemp.add(emp);
       }
           }
    return new RespuestaDTO(200, "Exitoso",listaTemp);
    }
}

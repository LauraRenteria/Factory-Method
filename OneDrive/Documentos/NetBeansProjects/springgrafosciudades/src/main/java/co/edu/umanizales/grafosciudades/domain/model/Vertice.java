/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.grafosciudades.domain.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import springfox.documentation.spring.web.json.Json;

/**
 *
 * @author laura
 */
public class Vertice implements Serializable{
    
    @Id
    private int codigo;
    
    private Json dato;

    public Vertice(int codigo, Json dato) {
        this.codigo = codigo;
        this.dato = dato;
    }

    public Vertice() {
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the dato
     */
    public Json getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Json dato) {
        this.dato = dato;
    }
    
    
    

    
    
    
}

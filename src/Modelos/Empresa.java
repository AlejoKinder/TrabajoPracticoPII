/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author alejo
 */
public class Empresa {
    private Integer cuit;
    private String nombre, direccion, repreLegal, repreTecnico;
    private ArrayList<Obra> obrasEmpresa = new ArrayList();

    public Empresa(Integer cuit, String nombre, String direccion, String repreLegal, String repreTecnico) { //Contructor que crea la empresa sin pasarle obras.
        this.cuit = cuit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.repreLegal = repreLegal;
        this.repreTecnico = repreTecnico;
    }
    
    public Integer getCuit() {
        return cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRepreLegal() {
        return repreLegal;
    }

    public String getRepreTecnico() {
        return repreTecnico;
    }
   
    
}

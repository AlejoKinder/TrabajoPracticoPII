/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author alejo
 */
public class Empresa {
    private Integer cuit;
    private String nombre, direccion, repreLegal, repreTecnico;
    private Obra obras;

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

    public Obra getObras() {
        return obras;
    }
    
    
}

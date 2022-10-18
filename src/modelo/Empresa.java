/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dany_
 */
public class Empresa {
    
    private Integer vCuit;
    private String vNombre;
    private String vDireccion;
    private String vRepresentanteLegal;
    private String vRepresentanteTecnico;

    public Empresa(Integer vCuit, String vNombre, String vDireccion, String vRepresentanteLegal, String vRepresentanteTecnico) {
        this.vCuit = vCuit;
        this.vNombre = vNombre;
        this.vDireccion = vDireccion;
        this.vRepresentanteLegal = vRepresentanteLegal;
        this.vRepresentanteTecnico = vRepresentanteTecnico;
    }

    public Integer getvCuit() {
        return vCuit;
    }

    public String getvNombre() {
        return vNombre;
    }

    public String getvDireccion() {
        return vDireccion;
    }

    public String getvRepresentanteLegal() {
        return vRepresentanteLegal;
    }

    public String getvRepresentanteTecnico() {
        return vRepresentanteTecnico;
    }
    
    //--------------------------------------------------------------------------
    
    
}

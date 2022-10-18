/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dany_
 */
public class Financiacion {
    
    private Integer vIdFinanciacion;
    private String vDescripcion;

    public Financiacion(Integer vIdFinanciacion, String vDescripcion) {
        this.vIdFinanciacion = vIdFinanciacion;
        this.vDescripcion = vDescripcion;
    }

    public Integer getvIdFinanciacion() {
        return vIdFinanciacion;
    }

    public String getvDescripcion() {
        return vDescripcion;
    }
    
    //--------------------------------------------------------------------------
    
}

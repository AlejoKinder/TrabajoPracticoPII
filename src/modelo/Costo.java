/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dany_
 */
public class Costo {
    
    private Integer vIdCosto;
    private Double vMonto;
    private String vFechaInicioVigencia;

    public Costo(Integer vIdCosto, Double vMonto, String vFechaInicioVigencia) {
        this.vIdCosto = vIdCosto;
        this.vMonto = vMonto;
        this.vFechaInicioVigencia = vFechaInicioVigencia;
    }

    public Integer getvIdCosto() {
        return vIdCosto;
    }

    public Double getvMonto() {
        return vMonto;
    }

    public String getvFechaInicioVigencia() {
        return vFechaInicioVigencia;
    }

    //--------------------------------------------------------------------------
    
}

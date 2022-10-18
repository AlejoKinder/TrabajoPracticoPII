/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio
 */
public class RenglonCertificado {
    
    private Integer vIdRenglon;
    private Double vCostoActual;
    private Integer vAvance;
    private Double vCostoAPagar;

    public RenglonCertificado(Integer vIdRenglon, Double vCostoActual, Integer vAvance) {
        this.vIdRenglon = vIdRenglon;
        this.vCostoActual = vCostoActual;
        this.vAvance = vAvance;
        this.vCostoAPagar = (vCostoActual * vAvance)/100;
    }

    public Integer getvIdRenglon() {
        return vIdRenglon;
    }

    public Double getvCostoActual() {
        return vCostoActual;
    }

    public Integer getvAvance() {
        return vAvance;
    }

    public Double getvCostoAPagar() {
        return vCostoAPagar;
    }
    
    
    
}

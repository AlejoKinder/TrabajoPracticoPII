/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author alejo
 */
public class Costo_Item {
    private Integer id_costo;
    private double monto;
    private String inicio_periodo_vigencia;

    public Costo_Item(Integer id_costo, double monto, String inicio_periodo_vigencia) {
        this.id_costo = id_costo;
        this.monto = monto;
        this.inicio_periodo_vigencia = inicio_periodo_vigencia;
    }

    public Integer getId_costo() {
        return id_costo;
    }

    public double getMonto() {
        return monto;
    }

    public String getInicio_periodo_vigencia() {
        return inicio_periodo_vigencia;
    }

    public void setId_costo(Integer id_costo) {
        this.id_costo = id_costo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setInicio_periodo_vigencia(String inicio_periodo_vigencia) {
        this.inicio_periodo_vigencia = inicio_periodo_vigencia;
    }
    
    
    
}

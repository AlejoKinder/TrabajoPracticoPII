/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author alejo
 */
public class Renglon_certificado {
    private Integer id_concepto;
    private double importe_parcial;
    private String denominacion;
    private float porcentaje_Avance;

    public Renglon_certificado(Integer id_concepto, double importe_parcial, String denominacion, float porcentaje_Avance) {
        this.id_concepto = id_concepto;
        this.importe_parcial = importe_parcial;
        this.denominacion = denominacion;
        this.porcentaje_Avance = porcentaje_Avance;
    }

    public Integer getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(Integer id_concepto) {
        this.id_concepto = id_concepto;
    }

    public double getImporte_parcial() {
        return importe_parcial;
    }

    public void setImporte_parcial(double importe_parcial) {
        this.importe_parcial = importe_parcial;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public float getPorcentaje_Avance() {
        return porcentaje_Avance;
    }

    public void setPorcentaje_Avance(float porcentaje_Avance) {
        this.porcentaje_Avance = porcentaje_Avance;
    }
    
    
}

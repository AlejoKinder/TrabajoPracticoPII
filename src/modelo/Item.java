/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import metodosIlegales.*;

/**
 *
 * @author dany_
 */
public class Item {
    
    private Integer vIdItem;
    private String vDenominacion;
    private Integer vOrden;
    private Integer vIncidencia;
    private Float vImpuestoFlete;
    private Float vImpuestoGastos;
    private Float vImpuestoUtilidad;
    private ArrayList<Costo> vCostos = new ArrayList(); 

    public Item(Integer vIdItem, String vDenominacion, Integer vOrden, Integer vIncidencia, Float vImpuestoFlete, Float vImpuestoGastos, Float vImpuestoUtilidad) {
        this.vIdItem = vIdItem;
        this.vDenominacion = vDenominacion;
        this.vOrden = vOrden;
        this.vIncidencia = vIncidencia;
        this.vImpuestoFlete = vImpuestoFlete;
        this.vImpuestoGastos = vImpuestoGastos;
        this.vImpuestoUtilidad = vImpuestoUtilidad;
    }

    public Integer getvIdItem() {
        return vIdItem;
    }

    public String getvDenominacion() {
        return vDenominacion;
    }

    public Integer getvOrden() {
        return vOrden;
    }

    public Integer getvIncidencia() {
        return vIncidencia;
    }

    public Float getvImpuestoFlete() {
        return vImpuestoFlete;
    }

    public Float getvImpuestoGastos() {
        return vImpuestoGastos;
    }

    public Float getvImpuestoUtilidad() {
        return vImpuestoUtilidad;
    }
    
    public ArrayList<Costo> getvCostos() {
        return vCostos;
    }
    
    //--------------------------------------------------------------------------

    public void setvOrden(Integer vOrden) {
        this.vOrden = vOrden;
    }

    public void setvIncidencia(Integer vIncidencia) {
        this.vIncidencia = vIncidencia;
    }
    
    //--------------------------------------------------------------------------

    Auxiliar vAux = new Auxiliar();
    
    public void AgregarCosto (Costo vNuevoCosto){
        this.vCostos.add(vNuevoCosto);
    }
    
    public Costo DevolverCostoVigente () throws Exception{
        if (!vCostos.isEmpty()){
            
            if (vCostos.size() != 1){
                
                Integer[] vFechaMayor = new Integer[3];
                
                vFechaMayor[0] = 0;
                vFechaMayor[1] = 0;
                vFechaMayor[2] = 0;
                Costo vCostoVigente = null;
                
                for (Costo a: vCostos){
                    
                    Integer[] vFecha = new Integer[3];
                    vFecha = vAux.TransformarFecha(a.getvFechaInicioVigencia());
                    
                    vFechaMayor = vAux.DevolverFechaMayor(vFecha, vFechaMayor);
                    
                    if (vFechaMayor == vFecha){
                        vCostoVigente = a;
                    }
                }
                
                return vCostoVigente;

            }else{
                return vCostos.get(0);
            }
        }else{
            throw new Exception ("El item no tiene costos relacionados");
        }
    }
    
}

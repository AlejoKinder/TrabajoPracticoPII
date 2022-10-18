/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dany_
 */
public class RenglonFoja {
    
    private Integer vIdRenglon;
    private Integer vPorcentajeAnterior;
    private Integer vPorcentajeActual;
    private Integer vPorcentajeAcumulado;
    private Item vItem;

    public RenglonFoja(Integer vIdRenglon, Integer vPorcentajeAnterior, Item vItem) {
        this.vIdRenglon = vIdRenglon;
        this.vPorcentajeAnterior = vPorcentajeAnterior;
        this.vPorcentajeActual = 0;
        this.vPorcentajeAcumulado = vPorcentajeAnterior;
        this.vItem = vItem;
    }

    public Integer getvIdRenglon() {
        return vIdRenglon;
    }

    public Integer getvPorcentajeAnterior() {
        return vPorcentajeAnterior;
    }

    public Integer getvPorcentajeActual() {
        return vPorcentajeActual;
    }

    public Integer getvPorcentajeAcumulado() {
        return vPorcentajeAcumulado;
    }

    public Item getvItem() {
        return vItem;
    }

    public void DefinirPorcentajeActual(Integer vPorcentajeActual) throws Exception {
        if ((vPorcentajeActual + this.vPorcentajeAnterior)<=100){
            this.vPorcentajeActual = vPorcentajeActual;
            this.vPorcentajeAcumulado = vPorcentajeActual + this.vPorcentajeAnterior;
        }else{
            throw new Exception ("La suma de porcentajes da un valor mayor al 100%");
        }
    }

    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author dany_
 */
public class Obra {
    
    private Integer vIdObra;
    private String vDenominacion;
    private String vLocalidad;
    private Integer vCantidadViviendas;
    private String vFechaInicio;
    private Integer vPlazo;
    private Empresa vEmpresa;
    private Financiacion vFinanciacion;
    private ArrayList<Item> vItems = new ArrayList(); 

    public Obra(Integer vIdObra, String vDenominacion, String vLocalidad, Integer vCantidadViviendas, String vFechaInicio, Integer vPlazo, Empresa vEmpresa, Financiacion vFinanciacion) {
        this.vIdObra = vIdObra;
        this.vDenominacion = vDenominacion;
        this.vLocalidad = vLocalidad;
        this.vCantidadViviendas = vCantidadViviendas;
        this.vFechaInicio = vFechaInicio;
        this.vPlazo = vPlazo;
        this.vEmpresa = vEmpresa;
        this.vFinanciacion = vFinanciacion;
    }

    public Integer getvIdObra() {
        return vIdObra;
    }

    public String getvDenominacion() {
        return vDenominacion;
    }

    public String getvLocalidad() {
        return vLocalidad;
    }

    public Integer getvCantidadViviendas() {
        return vCantidadViviendas;
    }

    public String getvFechaInicio() {
        return vFechaInicio;
    }

    public Integer getvPlazo() {
        return vPlazo;
    }

    public Empresa getvEmpresa() {
        return vEmpresa;
    }

    public Financiacion getvFinanciacion() {
        return vFinanciacion;
    }

    public ArrayList<Item> getvItems() {
        return vItems;
    }
    
    //--------------------------------------------------------------------------
    
    public void AgregarItem (Item vNuevoItem){
        this.vItems.add(vNuevoItem);
    }
    
    public Item BuscarItemId (Integer vIdItem)throws Exception{
        for (Item a: this.vItems){
            if (Objects.equals(vIdItem, a.getvIdItem())){
                return a;
            }
        }
        return null;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.util.*;

/**
 *
 * @author alejo
 */
public class Obra {
    private Integer id_Obra;
    private String nombre;
    private float porc_flete;
    private float porc_gastos;
    private float porc_utilidad;
    private float porc_IVA_vivienda;
    private float porc_IVA_infraestructura;
    private Empresa empr;
    private Financiacion fin;
    private ArrayList<Item> items = new ArrayList();
    
    public Obra(Integer id_Obra, String nombre, float porc_flete, float porc_gastos, float porc_utilidad, float porc_IVA_vivienda, float porc_IVA_infraestructura, Empresa em, Financiacion finan) {
        this.id_Obra = id_Obra;
        this.nombre = nombre;
        this.porc_flete = porc_flete;
        this.porc_gastos = porc_gastos;
        this.porc_utilidad = porc_utilidad;
        this.porc_IVA_vivienda = porc_IVA_vivienda;
        this.porc_IVA_infraestructura = porc_IVA_infraestructura;
        this.empr = em;
        this.fin = finan;
    }
    
    public void agregarItem(String denominacion, int tipo){
        if(cantItems() < 30){
            Item it = new Item(cantItems() + 2, denominacion, tipo);
            items.add(it);
        }else System.out.println("NO SE PUEDE INSERTAR ITEM PORQUE YA ALCANZO EL MAXIMO DE 30 POR OBRA!...");            
    }
    
    public void getItems(){
        for(Item a : items) System.out.println (a.getId_item() + " " + a.getDenominacion() + " " + a.getTipo());
    }

    public Integer getId_Obra() {
        return id_Obra;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPorc_flete() {
        return porc_flete;
    }

    public float getPorc_gastos() {
        return porc_gastos;
    }

    public float getPorc_utilidad() {
        return porc_utilidad;
    }

    public float getPorc_IVA_vivienda() {
        return porc_IVA_vivienda;
    }

    public float getPorc_IVA_infraestructura() {
        return porc_IVA_infraestructura;
    }
    
    public int cantItems(){ //trae la cantidad de items que tiene la coleccion de items.
        int retorno = items.size() - 1;
        return retorno;
    }
}

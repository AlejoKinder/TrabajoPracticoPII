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
public class Item {
    private Integer id_item;
    private String denominacion;
    private int tipo;
    private ArrayList<Costo_Item> = new ArrayList();

    public Item(Integer id_item, String denominacion, int tipo) {
        this.id_item = id_item;
        this.denominacion = denominacion;
        this.tipo = tipo;
    }
    
    public void crearCosto()

    public Integer getId_item() {
        return id_item;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}

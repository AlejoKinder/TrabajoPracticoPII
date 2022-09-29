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
    private ArrayList<Costo_Item> costos = new ArrayList();

    public Item(Integer id_item, String denominacion, int tipo) {
        this.id_item = id_item;
        this.denominacion = denominacion;
        this.tipo = tipo;
    }
    
    public void crearCosto(double monto, Integer inicio_periodo_vigencia){
        Costo_Item cos = new Costo_Item(ultimoCosto() + 1, monto, inicio_periodo_vigencia);
        costos.add(cos);
    }
    
    public String getUltimoCosto(){
        if((ultimoObjCosto()) != null) {
            Costo_Item cost = ultimoObjCosto();
            System.out.println (cost.getId_costo() + " " + cost.getMonto() + " " + cost.getInicio_periodo_vigencia());
        }        
        return "";
    }

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
    
    private int ultimoCosto(){ //busca el ultimo costo.
        int ultimo = costos.size() - 1;
        if (ultimo >= 0) {
            Costo_Item ultimoObj = costos.get(ultimo);
            return ultimoObj.getId_costo();
        }else{
            return 0;
        }
    }
    
    private Costo_Item ultimoObjCosto(){ //busca el ultimo costo.
        int ultimo = costos.size() - 1;
        if (ultimo >= 0) {
            Costo_Item ultimoObj = costos.get(ultimo);
            return ultimoObj;
        }else{
            return null;
        }
    }
}

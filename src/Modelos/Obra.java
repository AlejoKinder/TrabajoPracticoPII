/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.util.*;
import FuncionesIlegales.*;

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
    private Financiacion finan;
    private ArrayList<Item> items = new ArrayList();
    private ArrayList<Foja_Medicion> vFojas = new ArrayList();
    
    public Obra(Integer id_Obra, String nombre, float porc_flete, float porc_gastos, float porc_utilidad, float porc_IVA_vivienda, float porc_IVA_infraestructura, Empresa em, Financiacion finan) {
        this.id_Obra = id_Obra;
        this.nombre = nombre;
        this.porc_flete = porc_flete;
        this.porc_gastos = porc_gastos;
        this.porc_utilidad = porc_utilidad;
        this.porc_IVA_vivienda = porc_IVA_vivienda;
        this.porc_IVA_infraestructura = porc_IVA_infraestructura;
        this.empr = em;
        this.finan = finan;
    }
    
    metodos vMet = new metodos();
    
    public void AgregarItem(Item vNuevoItem) throws Exception {
        if(items.size() < 30){
            items.add(vNuevoItem);
        }else {
            throw new Exception ("No se pueden agregar mas de 30 renglones en una obra");
        }
    }
    
    // Agregar exception de "Si no existe item"
    
    public void agregarCostoItem(Integer vIdItem, Costo_Item vCostoNuevo){
        Item vItem = buscarItem(vIdItem);
        vItem.AgregarCosto(vCostoNuevo);
    }
    
    private Item buscarItem(Integer id){
        for(Item p : items){
            if((p.getId_item()).equals(id)) return p;
        }    
        return null;
    }

    //--------------------------------------------------------------------------
    
    public void AgregarFoja (Foja_Medicion vNuevaFoja){
        this.vFojas.add(vNuevaFoja);
    }
    
    public Foja_Medicion DevolverUltimaFoja() {
        if (vFojas.isEmpty()) {
            return null;
        }else{
            Foja_Medicion vUltimaFoja = null;
            Integer vUltimaFecha[] = new Integer [3];
            
            for (Foja_Medicion f: vFojas) {
                if (vUltimaFoja == null){
                    vUltimaFoja = f;
                }else{
                    vUltimaFecha = vMet.DevolverFechaMayor(vUltimaFoja.getvFechaCreacion(), f.getvFechaCreacion());
                    
                    if (vUltimaFecha == vMet.TransformarFecha(f.getvFechaCreacion())){
                        vUltimaFoja = f;
                    }
                }
            }
            return vUltimaFoja;
        }
    }
    
    //--------------------------------------------------------------------------
    
    public ArrayList<Item> getItems() {
        return items;
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
    
}

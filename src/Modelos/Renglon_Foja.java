/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author alejo
 */
public class Renglon_Foja {
    private Integer id_renglon_foja;
    private float porc_avance_anterior;
    private float porc_avance_actual;
    private float porc_acumulada;
    private Item itemsObra;

    public Renglon_Foja(Integer id_renglon_foja, float porc_avance_anterior, Item itemsObra) {
        this.id_renglon_foja = id_renglon_foja;
        this.porc_avance_anterior = porc_avance_anterior;
        this.porc_avance_actual = 0;
        this.porc_acumulada = porc_avance_anterior;
        this.itemsObra = itemsObra;
    }

    public Integer getId_renglon_foja() {
        return id_renglon_foja;
    }

    public float getPorc_avance_anterior() {
        return porc_avance_anterior;
    }

    public float getPorc_avance_actual() {
        return porc_avance_actual;
    }

    public float getPorc_acumulada() {
        return porc_acumulada;
    }

    public Item getItemsObra() {
        return itemsObra;
    }
 
    
    
}

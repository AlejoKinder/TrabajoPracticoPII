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
public class Foja_Medicion {
    
    private Integer vIdFoja;
    private String vFechaCreacion;
    private String vDescripcion;
    
    private Obra vObra;
    private ArrayList<Renglon_Foja> vRenglones = new ArrayList();
    
    //--------------------------------------------------------------------------

    public Foja_Medicion(Integer vIdFoja, String vFechaCreacion, String vDescripcion, Obra vObra) {
        this.vIdFoja = vIdFoja;
        this.vFechaCreacion = vFechaCreacion;
        this.vDescripcion = vDescripcion;
        this.vObra = vObra;
    }

    public Integer getvIdFoja() {
        return vIdFoja;
    }

    public String getvFechaCreacion() {
        return vFechaCreacion;
    }

    public String getvDescripcion() {
        return vDescripcion;
    }

    public Obra getvObra() {
        return vObra;
    }

    public ArrayList<Renglon_Foja> getvRenglones() {
        return vRenglones;
    }
    
    //--------------------------------------------------------------------------
    
    public void CrearRenglonesFoja() {
    
        Foja_Medicion vUltimaFoja = vObra.DevolverUltimaFoja();
        ArrayList<Renglon_Foja> vRenglonesUltimaFoja = new ArrayList();
        if (vUltimaFoja != null){
            vRenglonesUltimaFoja = vUltimaFoja.getvRenglones();
        }
        
        ArrayList<Item> vItems = new ArrayList();
        vItems = vObra.getItems();
        
        for (Item i: vItems){
            Renglon_Foja vNuevoRenglon;
            
            if (vUltimaFoja == null){
                vNuevoRenglon = new Renglon_Foja((vRenglones.size()+1), 0, i);
            } else {
                vNuevoRenglon = new Renglon_Foja((vRenglones.size()+1), (vRenglonesUltimaFoja.get((vRenglones.size()+1)).getPorc_acumulada()), i);
            }
            
            vRenglones.add(vNuevoRenglon);
        }
    
    }
    
}
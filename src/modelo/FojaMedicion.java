/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author dany_
 */
public class FojaMedicion {
    
    private Integer vIdFoja;
    private String vFechaEmision;
    private Obra vObra;
    private ArrayList<RenglonFoja> vRenglones = new ArrayList(); 
    
    //--------------------------------------------------------------------------

    public FojaMedicion(Integer vIdFoja, String vFechaEmision, Obra vObra) {
        this.vIdFoja = vIdFoja;
        this.vFechaEmision = vFechaEmision;
        this.vObra = vObra;
    }

    public Integer getvIdFoja() {
        return vIdFoja;
    }

    public String getvFechaEmision() {
        return vFechaEmision;
    }

    public Obra getvObra() {
        return vObra;
    }

    public ArrayList<RenglonFoja> getvRenglones() {
        return vRenglones;
    }
    
    //--------------------------------------------------------------------------
    
    public void AgregarRenglon (RenglonFoja vNuevoRenglon){
        vRenglones.add(vNuevoRenglon);
    }
    
    public void CrearRenglones (FojaMedicion vUltimaFoja) {
        
        for (Item a: this.vObra.getvItems()){
            
            RenglonFoja vNuevoRenglon = null;
            if (vUltimaFoja == null){
                vNuevoRenglon = new RenglonFoja (this.vRenglones.size()+1, 0, a);
            }else{
                vNuevoRenglon = new RenglonFoja (this.vRenglones.size()+1, this.DevolverAvanceAnterior(a), a);
            }
            
            this.vRenglones.add(vNuevoRenglon);
        }
    
    }
    
    public Integer DevolverAvanceAnterior(Item vItem){
    
        for (RenglonFoja a: vRenglones){
            if (a.getvItem() == vItem){
                return a.getvPorcentajeAcumulado();
            }
        }
        
        return 0;
    }
    
}

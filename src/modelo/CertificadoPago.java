/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class CertificadoPago {
 
    private Integer vIdCertificado;
    private Double vCostoTotal;
    private String vFechaEmision;
    private Obra vObra;
    private FojaMedicion vFoja;
    private ArrayList<RenglonCertificado> vRenglones = new ArrayList(); 

    public CertificadoPago(Integer vIdCertificado, String vFechaEmision, Obra vObra, FojaMedicion vFoja) {
        this.vIdCertificado = vIdCertificado;
        this.vCostoTotal = (double)0;
        this.vFechaEmision = vFechaEmision;
        this.vObra = vObra;
        this.vFoja = vFoja;
    }

    public Integer getvIdCertificado() {
        return vIdCertificado;
    }

    public Double getvCostoTotal() {
        return vCostoTotal;
    }

    public String getvFechaEmision() {
        return vFechaEmision;
    }

    public Obra getvObra() {
        return vObra;
    }

    public FojaMedicion getvFoja() {
        return vFoja;
    }

    public ArrayList<RenglonCertificado> getvRenglones() {
        return vRenglones;
    }
    
    //--------------------------------------------------------------------------
    
    public void AgregarRenglon (RenglonCertificado vNuevoRenglon){
        this.vRenglones.add(vNuevoRenglon);
    }
    
    public void CrearRenglones() throws Exception{
    
        Integer vPos = 0;
        for (RenglonFoja a: this.vFoja.getvRenglones()){
            RenglonCertificado vNuevoRenglon = new RenglonCertificado(this.vRenglones.size()+1, this.vObra.getvItems().get(vPos).DevolverCostoVigente().getvMonto(), a.getvPorcentajeActual());
            
            this.vRenglones.add(vNuevoRenglon);
            vPos = vPos + 1;
        }
        
        this.vCostoTotal = this.CalcularMontoTotal();
        
    }
    
    public Double CalcularMontoTotal (){
    
        Double vMonto = (double)0;
        for(RenglonCertificado a: this.vRenglones){
            
            System.out.println("Valor agregado: " + a.getvCostoAPagar());
            vMonto = vMonto + a.getvCostoAPagar();
        }
        
        return vMonto;
    }
    
    
}

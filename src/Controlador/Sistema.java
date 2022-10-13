/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.*;
import Modelos.*;

/**
 * Pongan los metodos con los nombres completos, no abrevien palabras
 * AHHHHHH
 */
public class Sistema {
    
    private ArrayList <Obra> obras = new ArrayList();
    private ArrayList <Empresa> empresas = new ArrayList();
    private ArrayList <Foja_Medicion> fojas = new ArrayList();
    private ArrayList <Financiacion> finan = new ArrayList();
    private ArrayList <Certificado> certificados = new ArrayList();
    
    //--ItemObra-------------------------------------------------------------------------------------------------
    
    public void crearItemObra(String vDenominacion, Integer vTipo, Integer idObra, double vMontoInicial, String vInicioPeriodoVigencia){
        try {
            Obra vObra = buscarObra(idObra);
        
            Item vNuevoItem = new Item((vObra.getItems().size()+1), vDenominacion, vTipo);
            vObra.AgregarItem(vNuevoItem);

            Costo_Item vNuevoCosto = new Costo_Item(0, vMontoInicial, vInicioPeriodoVigencia);
            vObra.agregarCostoItem(vNuevoItem.getId_item(), vNuevoCosto);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    //--CostoItem-------------------------------------------------------------------------------------------------
    
    public void crearCostoItem(double vMonto, String inicio_periodo_vigencia, Integer idObra, Integer idItem){
        Obra vObra = buscarObra(idObra);
        
        Costo_Item vNuevoCosto = new Costo_Item(0, vMonto, inicio_periodo_vigencia);
        vObra.agregarCostoItem(idItem, vNuevoCosto);
    }
    
    //--Certificado-------------------------------------------------------------------------------------------------
    
    
    //El importe total deberia calcular solo
    public void crearCertificado(String fecha_de_creacion, Integer vIdFoja, Integer vIdObra){
        Foja_Medicion foja = BuscarFoja(vIdFoja, vIdObra);
        
        if(foja != null){
            Certificado cert = new Certificado(certificados.size() + 1, fecha_de_creacion, false, 5000, foja);
            certificados.add(cert);
        }else System.out.println("FOJA NO EXISTENTE!...");
    }
    
    public void crearRenglonCertificado(double importe_parcial, String denominacion, float porcentaje_Avance, Integer idCert){
        Certificado cert = buscarCertificado(idCert);
        
        if(cert != null){
            cert.crearConcepto(importe_parcial, denominacion, porcentaje_Avance);
        }System.out.println("CERTIFICADO NO EXISTENTE!...");
    }
    
    private Certificado buscarCertificado(Integer id){
        for(Certificado p : certificados){
            if(Objects.equals(p.getId_certificado(), id)){
                return p;
            }
        }
        
        return null;
    }
    
    //--Obra-------------------------------------------------------------------------------------------------
    
    public void crearObra(String nombre, float porc_flete, float porc_gastos, float porc_utilidad, float porc_IVA_vivienda, float porc_IVA_infraestructura, String nombre_finan, Integer cuitEmpresa){
        Empresa vEmpresa = buscarEmpresa(cuitEmpresa);
        Financiacion vFinanciacion = buscarFinanciacion (nombre_finan);
        
        Obra vNuevaObra = new Obra(obras.size() + 1, nombre, porc_flete, porc_gastos, porc_utilidad, porc_IVA_vivienda, porc_IVA_infraestructura, vEmpresa, vFinanciacion);
        obras.add(vNuevaObra);
    }
    
    private Obra buscarObra(Integer id){
        for(Obra p : obras){
            if(Objects.equals(id, p.getId_Obra())) {
                return p;
            }
        }
        return null;
    }
    
    public void getObrasEItems(){
        for(Obra p : obras){
            System.out.println(p.getId_Obra() + " " + p.getNombre() + " ");
            p.getItems();            
        }
    }
    
    
    //--Empresa-------------------------------------------------------------------------------------------------
    
    public void crearEmpresa(Integer cuit, String nombre, String direccion, String repreLegal, String repreTecnico){
        if(buscarEmpresa(cuit) == null){
               Empresa obj = new Empresa(cuit, nombre, direccion, repreLegal, repreTecnico);
               empresas.add(obj);
        }else{
            //Deberia tirar un exception aca
        }
    }
    
    private Empresa buscarEmpresa(Integer cuit){ //verifica si existe una empresa o no.
        for(Empresa p : empresas){
            if(((p.getCuit()).equals(cuit))) return p; 
        }
        return null;
    }
    
    public void getEmpresas(){
        for(Empresa p : empresas){
            System.out.println(p.getCuit() + " " + p.getNombre() + " " + p.getDireccion() + " " + p.getRepreLegal() + " " + p.getRepreTecnico());
        }
    }     
    
    //--Foja-------------------------------------------------------------------------------------------------
    
    public void crearFoja(Integer vIdObra, String vFechaCreacion, String vDescripcion){
        Obra vObra = buscarObra(vIdObra);
        
        Foja_Medicion vNuevaFoja = new Foja_Medicion ((vObra.DevolverUltimaFoja().getvIdFoja())+1, vFechaCreacion, vDescripcion, vObra);
        
        vNuevaFoja.CrearRenglonesFoja();
        vObra.AgregarFoja(vNuevaFoja);
        this.fojas.add(vNuevaFoja);
    }
    
    public Foja_Medicion BuscarFoja (Integer vIdFoja, Integer vIdObra){
        Obra vObra = buscarObra(vIdObra);
        
        for(Foja_Medicion p : this.fojas){
            if(p.getvObra()==vObra){
                if(Objects.equals(p.getvIdFoja(), vIdFoja)){
                    return p;
                }
            }
        }
        return null;
    }
    
    
    
    //--Financiacion-------------------------------------------------------------------------------------------------
    
    public void crearFinanciacion(String nombre){
        if ((buscarFinanciacion(nombre)) == null){
            Financiacion obj = new Financiacion(finan.size() + 1, nombre);
            finan.add(obj);
        }else{
            //Deberia tirar un exception aca
        }
    }
    
    private Financiacion buscarFinanciacion(String nombre){ //verifica si existe una empresa o no.
        for(Financiacion p : finan){
            if((p.getNombre()).equals(nombre)) return p;                 
        }
        return null;
    }
    
    public void getFinanciaciones(){
        for(Financiacion p : finan){
            System.out.println(p.getId() + " " + p.getNombre());
        }
    }   
    
}

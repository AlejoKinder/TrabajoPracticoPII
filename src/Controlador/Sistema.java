/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.*;
import Modelos.*;

/**
 * probando
 probando ramassss
 * Prueba de mauricio
 * Ale tu mama no mea
 * @author alejo
 */
public class Sistema {
    private ArrayList<Obra> obras = new ArrayList();
    private ArrayList<Empresa> empresas = new ArrayList();
    private ArrayList<Foja_Medicion> fojas = new ArrayList();
    private ArrayList<Financiacion> finan = new ArrayList();
    private ArrayList<Certificado> certificados = new ArrayList();
    
    public void crearEmpresa(Integer cuit, String nombre, String direccion, String repreLegal, String repreTecnico){
        if(existenciaEmpresa(cuit) != true){
               Empresa obj = new Empresa(cuit, nombre, direccion, repreLegal, repreTecnico);
               empresas.add(obj);
        }else System.out.println("NUMERO DE CUIT: " + cuit + ", YA REGISTRADO!...");
    }
    
    public void crearFinanciacion(String nombre){
        if ((existenciaFinanciacion(nombre)) != true){
            Financiacion obj = new Financiacion(ultimoIdFinan() + 1, nombre);
            finan.add(obj);
        }else System.out.printfln("NOMBRE DE FINANCIACION YA EXISTENTE!...");
    }
    
    public void crearObra(String nombre, float porc_flete, float porc_gastos, float porc_utilidad, float porc_IVA_vivienda, float porc_IVA_infraestructura, String nombre_finan, Integer cuitEmpresa){
        Empresa em = buscarEmpresa(cuitEmpresa);
        Financiacion finan = buscarFinanciacion (nombre_finan);
        Obra ob = new Obra(ultimaObra() + 1, nombre, porc_flete, porc_gastos, porc_utilidad, porc_IVA_vivienda, porc_IVA_infraestructura, em, finan);
        obras.add(ob);
    }
    
    public void crearItemObra(String denominacion, int tipo, Integer idObra){
        Obra obr = buscarObra(idObra);
        obr.agregarItem(denominacion, tipo);        
    }
    
    public void crearCostoItem()
    
    public void getObrasEItems(){
        for(Obra p : obras){
            System.out.println(p.getId_Obra() + " " + p.getNombre() + " ");
            p.getItems();
        }
    }
    
    public void getFinanciaciones(){
        for(Financiacion p : finan){
            System.out.println(p.getId() + " " + p.getNombre());
        }
    }   
    
    public void getEmpresas(){
        for(Empresa p : empresas){
            System.out.println(p.getCuit() + " " + p.getNombre() + " " + p.getDireccion() + " " + p.getRepreLegal() + " " + p.getRepreTecnico());
        }
    }     
    
    private int ultimaObra(){ //busca la ultima obra para hacer autoincremental el id obra.
        int ultimo = obras.size() - 1;
        if (ultimo >= 0) {
            Obra ultimoObj = obras.get(ultimo);
            return ultimoObj.getId_Obra();
        }else{
            return 0;
        }
    }
    
    private Obra buscarObra(Integer id){
        for(Obra p : obras){
            if((p.getId_Obra()).equals(id)) return p;
        }
        return null;
    }
    
    private Integer ultimoIdFinan(){ //busca el ultimo id de financiacion para sumarle 1 y asignarle eso al proximo financiacion a insertar       
        int ultimo = finan.size() - 1;
        if (ultimo >= 0) {
            Financiacion ultimoObj = finan.get(ultimo);
            return ultimoObj.getId();
        }else{
            return 0;
        }        
    }
     
    private Empresa buscarEmpresa(Integer cuit){ //verifica si existe una empresa o no.
        boolean existencia = false;
        for(Empresa p : empresas){
            if(((p.getCuit()).equals(cuit))) return p; 
        }
        return null;
    }
    
    private boolean existenciaEmpresa(Integer cuit){ //verifica si existe una empresa o no.
        boolean existencia = false;
        for(Empresa p : empresas){
            if((p.getCuit()).equals(cuit)) existencia = true; 
        }
        return existencia;
    }
    private boolean existenciaFinanciacion(String nombre){ //verifica si existe una empresa o no.
        boolean existencia = false;
        for(Financiacion p : finan){
            if((p.getNombre()).equals(nombre)) existencia = true;                  
        }
        return existencia;
    }
    
    private Financiacion buscarFinanciacion(String nombre){ //verifica si existe una empresa o no.
        for(Financiacion p : finan){
            if((p.getNombre()).equals(nombre)) return p;                 
        }
        return null;
    }
    
}

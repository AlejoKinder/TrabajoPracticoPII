/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.*;
import Modelos.*;

/**
 * probando
 hola buenas noches
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
            Integer id = ultimoIdFinan() + 1;
            Financiacion obj = new Financiacion(id, nombre);
            finan.add(obj);
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
    
    private Integer ultimoIdFinan(){ //busca el ultimo id de financiacion para sumarle 1 y asignarle eso al proximo financiacion a insertar       
        int ultimo = finan.size() - 1;
        if (ultimo >= 0) {
            Financiacion ultimoObj = finan.get(ultimo);
            return ultimoObj.getId();
        }else{
            return 0;
        }        
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
    
}

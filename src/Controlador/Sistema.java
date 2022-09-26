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
        }
    }
    private boolean existenciaEmpresa(Integer cuit){ //verifica si existe una empresa o no.
        boolean existencia = false;
        for(Empresa p : empresas){
            if((p.getCuit()) == cuit) existencia = true;                  
        }
        return existencia;
    }
    
}

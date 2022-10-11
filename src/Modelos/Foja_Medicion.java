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
    private Integer id_foja;
    private String fecha_de_creacion;
    private Obra obra;
    private Certificado certificados;
    private String descripcion;
    private float avancAnt, avacMes, avancAcumulado;
    private Certificado cert;
    private ArrayList<Renglon_Foja> vRenglones = new ArrayList();

    public Foja_Medicion(Integer id_foja, String fecha_de_creacion, Obra obras, String descrp, float avancAnt, float avacMes, float avancAcumulado) {
        this.id_foja = id_foja;
        this.fecha_de_creacion = fecha_de_creacion;
        this.obra = obras;
        this.descripcion = descrp;
        this.avancAnt = avancAnt;
        this.avacMes = avacMes;
        this.avancAcumulado = avancAcumulado;
    }

    public Integer getId_foja() {
        return id_foja;
    }

    public String getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public Obra getObra() {
        return obra;
    }

    public Certificado getCertificados() {
        return certificados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getAvancAnt() {
        return avancAnt;
    }

    public float getAvacMes() {
        return avacMes;
    }

    public float getAvancAcumulado() {
        return avancAcumulado;
    }

    public Certificado getCert() {
        return cert;
    }

    public ArrayList<Renglon_Foja> getvRenglones() {
        return vRenglones;
    }
    
    
   
    //--------------------------------------------------------------------------
    
    public void CrearRenglonesFoja() {
    
        Foja_Medicion vUltimaFoja = obra.DevolverUltimaFoja();
        ArrayList<Renglon_Foja> vRenglonesUltimaFoja = new ArrayList();
        if (vUltimaFoja != null){
            vRenglonesUltimaFoja = vUltimaFoja.getvRenglones()
        }
        
        ArrayList<Item> vItems = new ArrayList();
        vItems = obra.getItems();
        
        for (Item i: vItems){
            if (vUltimaFoja == null){
                Renglon_Foja vNuevoRenglon = new Renglon_Foja((vRenglones.size()+1), 0, i);
            } else {
                Renglon_Foja vNuevoRenglon = new Renglon_Foja((vRenglones.size()+1), (vRenglonesUltimaFoja.get((vRenglones.size()+1)).getPorc_acumulada(), i);
            }
            
            vRenglones.add(vNuevoRenglon);
        }
    
    }
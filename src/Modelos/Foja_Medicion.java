    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author alejo
 */
public class Foja_Medicion {
    private Integer id_foja;
    private Integer fecha_de_creacion;
    private Obra obras;
    private Certificado certificados;
    private String descrp;
    private float avancAnt, avacMes, avancAcumulado;
    private Certificado cert;

    public Foja_Medicion(Integer id_foja, Integer fecha_de_creacion, Obra obras, String descrp, float avancAnt, float avacMes, float avancAcumulado) {
        this.id_foja = id_foja;
        this.fecha_de_creacion = fecha_de_creacion;
        this.obras = obras;
        this.descrp = descrp;
        this.avancAnt = avancAnt;
        this.avacMes = avacMes;
        this.avancAcumulado = avancAcumulado;
    }

    public Integer getId_foja() {
        return id_foja;
    }

    public void setId_foja(Integer id_foja) {
        this.id_foja = id_foja;
    }

    public Integer getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(Integer fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    public Obra getObras() {
        return obras;
    }

    public void setObras(Obra obras) {
        this.obras = obras;
    }

    public Certificado getCertificados() {
        return certificados;
    }

    public void setCertificados(Certificado certificados) {
        this.certificados = certificados;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public float getAvancAnt() {
        return avancAnt;
    }

    public void setAvancAnt(float avancAnt) {
        this.avancAnt = avancAnt;
    }

    public float getAvacMes() {
        return avacMes;
    }

    public void setAvacMes(float avacMes) {
        this.avacMes = avacMes;
    }

    public float getAvancAcumulado() {
        return avancAcumulado;
    }

    public void setAvancAcumulado(float avancAcumulado) {
        this.avancAcumulado = avancAcumulado;
    }
    
        
}

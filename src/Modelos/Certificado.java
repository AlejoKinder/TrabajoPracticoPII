/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.util.*;

/**
 * Cambiado por Mauri
 */
public class Certificado {
    private Integer id_certificado;
    private String fecha_de_creacion;
    private boolean pagado;
    private double importe_total;
    private Foja_Medicion foja;
    private ArrayList<Renglon_certificado> renglones = new ArrayList();

    public Certificado(Integer id_certificado, String fecha_de_creacion, boolean pagado, double importe_total, Foja_Medicion foja) {
        this.id_certificado = id_certificado;
        this.fecha_de_creacion = fecha_de_creacion;
        this.pagado = pagado;
        this.importe_total = importe_total;
        this.foja = foja;
    }

    //--------------------------------------------------------------------------
    
    public void crearConcepto(double importe_parcial, String denominacion, float porcentaje_Avance){
        if(renglones.size() < 30){ //se fija que no hayan 30 renglones para dejar incertar un error.
            Renglon_certificado renglon = new Renglon_certificado(renglones.size() + 1, importe_parcial, denominacion, porcentaje_Avance);
            renglones.add(renglon);
        }System.out.println("YA EXISTE MAS DE 30 O MAS RENGLONES!...");
    }
    
    public Integer getId_certificado(){
        return id_certificado;
    }

    public String getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public boolean isPagado() {
        return pagado;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public Foja_Medicion getFoja() {
        return foja;
    }

    public ArrayList<Renglon_certificado> getRenglones() {
        return renglones;
    }
    
    //--------------------------------------------------------------------------
    
    /*public void AgregarRenglon (Renglon_certificado vNuevoRenglon) throws Exception {
        if (renglones.size() < 30) {
            renglones.add(vNuevoRenglon);
        } else {
            throw new Exception("No se pueden agregar mas renglones de certificado");
        }
    }*/
   
    
    
    


    
    
 
    
    
    
}

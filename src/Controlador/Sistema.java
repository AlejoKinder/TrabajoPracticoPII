/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Vista.*;
import java.util.ArrayList;
import java.util.Objects;
import modelo.*;
import metodosIlegales.*;

/**
 *
 * @author dany_
 */
public class Sistema {
    
    private ArrayList<Financiacion> vFinanciaciones = new ArrayList(); 
    private ArrayList<Empresa> vEmpresas = new ArrayList(); 
    private ArrayList<Obra> vObras = new ArrayList();
    private ArrayList<FojaMedicion> vFojas = new ArrayList();
    private ArrayList<CertificadoPago> vCertificados = new ArrayList();
    
    //--------------------------------------------------------------------------
    
    Auxiliar vAux = new Auxiliar();
    
    VistaMenuPrincipal vVistaA = null;
    VistaEmpresas vVista1 = null;
    VistaFinanciaciones vVista2 = null;
    VistaObras1 vVista3 = null;
    VistaObras2 vVista3A = null;
    
    //--------------------------------------------------------------------------
    
    public void CrearEmpresa (Integer vCuit, String vNombre, String vDireccion, String vRepresentanteLegal, String vRepresentanteTecnico) throws Exception{
        if (BuscarEmpresaCuit(vCuit) == null){
            Empresa vNuevaEmpresa = new Empresa (vCuit, vNombre, vDireccion, vRepresentanteLegal, vRepresentanteTecnico);
            vEmpresas.add(vNuevaEmpresa);
        }else{
            throw new Exception ("ERROR: Ya existe una empresa con el CUIT ingresado");
        }
    }
  
    public Empresa BuscarEmpresaCuit (Integer vCuit){
        for (Empresa a: vEmpresas){
            if (Objects.equals(vCuit, a.getvCuit())){
                return a;
            }
        }
        return null;
    }
    
    public String [][] DevolverEmpresasVista (){
        String[][] vArray = new String[this.vEmpresas.size()][5];
        
        Integer vPos = 0;
        for (Empresa a: vEmpresas){
        
            vArray[vPos][0] = a.getvCuit().toString();
            vArray[vPos][1] = a.getvNombre();
            vArray[vPos][2] = a.getvDireccion();
            vArray[vPos][3] = a.getvRepresentanteLegal();
            vArray[vPos][4] = a.getvRepresentanteTecnico();
            
            vPos = vPos + 1;
        }
        
        return vArray;
    }
    
    //--------------------------------------------------------------------------
    
    public void CrearFinanciacion (String vDescripcion){
        Financiacion vNuevaFinanciacion = new Financiacion (vFinanciaciones.size()+1, vDescripcion);
        vFinanciaciones.add(vNuevaFinanciacion);
    }
    
    public Financiacion BuscarFinanciacionId (Integer vIdFinanciacion){
        for (Financiacion a: vFinanciaciones){
            if (Objects.equals(vIdFinanciacion, a.getvIdFinanciacion())){
                return a;
            }
        }
        return null;
    }
    
    public String [][] DevolverFinanciacionesVista (){
        String[][] vArray = new String[this.vFinanciaciones.size()][2];
        
        Integer vPos = 0;
        for (Financiacion a: this.vFinanciaciones){
        
            vArray[vPos][0] = a.getvIdFinanciacion().toString();
            vArray[vPos][1] = a.getvDescripcion();
            
            vPos = vPos + 1;
        }
        
        return vArray;
    }
    
    //--------------------------------------------------------------------------
    
    public void CrearObra (String vDenominacion, String vLocalidad, Integer vCantidadViviendas, String vFechaInicio, Integer vPlazo, Integer vCuit, Integer vIdFinanciacion) throws Exception{
        
        Financiacion vFinanciacion = BuscarFinanciacionId(vIdFinanciacion);
        if (vFinanciacion != null){
           
            Empresa vEmpresa = BuscarEmpresaCuit(vCuit);
            if (vEmpresa != null){
                
                Obra vNuevaObra = new Obra (vObras.size()+1, vDenominacion, vLocalidad, vCantidadViviendas, vFechaInicio, vPlazo, vEmpresa, vFinanciacion);
                vObras.add(vNuevaObra);
            }else{
                throw new Exception ("La empresa ingresada, no existe");
            }
        }else{
            throw new Exception ("La financiacion ingresada, no existe");
        }
    }
    
    public Obra BuscarObraId (Integer vIdObra){
        for (Obra a: vObras){
            if (Objects.equals(vIdObra, a.getvIdObra())){
                return a;
            }
        }
        return null;
    }
    
    public void RedefinirIncidenciaItems (Integer vIdObra, Integer vValores[]) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        if (vObra != null){
            
            if (!vObra.getvItems().isEmpty()){
                
                if (vValores.length == vObra.getvItems().size()){
                    
                    Integer vValorSumado = vAux.SumarArray(vValores);
                    if (vValorSumado == 100){

                        Integer vPos = 0;
                        for (Item a: vObra.getvItems()){
                            a.setvIncidencia(vValores[vPos]);
                            vPos = vPos + 1;
                        }
                    }else{
                        throw new Exception ("La suma total de los valores ingresados, no da 100%, da " + vValorSumado + "%");
                    }
                }else{
                    throw new Exception ("La cantidad de valores ingresada, no es igual a la cantidad de items de la obra");
                }
            }else{
                throw new Exception ("La obra ingresada, no tiene items incluidos");
            }
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }
    
    public void RedefinirOrdenItems (Integer vIdObra, Integer vValores[]) throws Exception {
        Obra vObra = BuscarObraId(vIdObra);
        if (vObra != null){
            
            if (!vObra.getvItems().isEmpty()){
                
                if (vValores.length == vObra.getvItems().size()){
                    
                    if (vAux.BuscarValorArray(vValores, null) == false){
                        
                        if (vAux.ValoresRepetidosArray(vValores) == false){

                            Integer vPos = 0;
                            for (Item a: vObra.getvItems()){
                                a.setvOrden(vValores[vPos]);
                                vPos = vPos + 1;
                            }
                        }else{
                            throw new Exception ("Hay dos o mas items con el mismo numero de orden");
                        }
                    }else{
                        throw new Exception ("No se puede asignar orden null a un item");
                    }
                }else{
                    throw new Exception ("La cantidad de valores ingresada, no es igual a la cantidad de items de la obra");
                }
            }else{
                throw new Exception ("La obra ingresada, no tiene items incluidos");
            }
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }
    
    public Integer DevolverAvanceObra (Integer vIdObra) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        if (vObra != null){
            
            if (!vObra.getvItems().isEmpty()){
                
                FojaMedicion vUltimaFoja = this.BuscarUltimaFoja(vIdObra);
                if (vUltimaFoja != null){
                    
                    Double vAvance = 0.0;
                    Integer vPos = 0;
                    for (RenglonFoja a: vUltimaFoja.getvRenglones()){
                    
                        vAvance = vAvance + ((a.getvPorcentajeAcumulado()*vObra.getvItems().get(vPos).getvIncidencia())/100);
                        vPos = vPos + 1;
                    }
                    
                    return (int)Math.floor(vAvance);
                }else{
                    return 0;
                }
            }else{
                throw new Exception ("La obra ingresada, no tiene items incluidos");
            }
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }
    
    public void DevolverCostosItems (Integer vIdObra) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        if (vObra != null){
            
            if (!vObra.getvItems().isEmpty()){
                
                for (Item a: vObra.getvItems()) {
                    System.out.println("El costo vigente de el item " + a.getvDenominacion() + " es de: " + a.DevolverCostoVigente().getvMonto());
                }
                
            }else{
                throw new Exception ("La obra ingresada, no tiene items incluidos");
            }
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }
    
    public String [][] DevolverObrasVista1 (){
        String[][] vArray = new String[this.vObras.size()][6];
        
        Integer vPos = 0;
        for (Obra a: this.vObras){
        
            vArray[vPos][0] = a.getvIdObra().toString();
            vArray[vPos][1] = a.getvDenominacion();
            vArray[vPos][2] = a.getvLocalidad();
            vArray[vPos][3] = a.getvCantidadViviendas().toString();
            vArray[vPos][4] = a.getvFechaInicio();
            vArray[vPos][5] = a.getvPlazo().toString();
            
            vPos = vPos + 1;
        }
        
        return vArray;
    }
    
    public String [][] DevolverObrasVista2 (){
        String[][] vArray = new String[this.vObras.size()][6];
        
        Integer vPos = 0;
        for (Obra a: this.vObras){
        
            vArray[vPos][0] = a.getvIdObra().toString();
            vArray[vPos][1] = a.getvDenominacion();
            vArray[vPos][2] = a.getvEmpresa().getvNombre();
            vArray[vPos][3] = a.getvFinanciacion().getvDescripcion();
            
            try{
                vArray[vPos][4] = this.DevolverAvanceObra(a.getvIdObra()).toString() + "%";
            }catch (Exception e){
                vArray[vPos][4] = "Error";
            }
            
            vArray[vPos][5] = "IMPLEMENTAR";   
            
            vPos = vPos + 1;
        }
        
        return vArray;
    }
    
    //--------------------------------------------------------------------------
    
    public void CrearItem (Integer vIdObra, String vDenominacion, Float vImpuestoFlete, Float vImpuestoGastos, Float vImpuestoUtilidad, Double vMontoInicial, String vFechaInicioVigencia) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        
        if (vObra != null){
            Item vNuevoItem = new Item (vObra.getvItems().size()+1, vDenominacion, 0, 0, vImpuestoFlete, vImpuestoGastos, vImpuestoUtilidad);
            vObra.AgregarItem(vNuevoItem);
            
            Costo vCostoInicial = new Costo (1, vMontoInicial, vFechaInicioVigencia);
            vNuevoItem.AgregarCosto(vCostoInicial);
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }
    
    public String [][] DevolverItemsVista1 (Obra vObra) throws Exception{
        String[][] vArray = new String[vObra.getvItems().size()][6];
        
        Integer vPos = 0;
        for (Item a: vObra.getvItems()){
        
            vArray[vPos][0] = a.getvIdItem().toString();
            vArray[vPos][1] = a.getvDenominacion();
            vArray[vPos][2] = a.getvOrden().toString();
            vArray[vPos][3] = a.getvIncidencia().toString() + "%";
            vArray[vPos][4] = "$" + a.DevolverCostoVigente().getvMonto().toString();
            vArray[vPos][5] = a.DevolverCostoVigente().getvFechaInicioVigencia();
            
            vPos = vPos + 1;
        }
        
        return vArray;
    }
    
    public String [][] DevolverItemsVista2 (Obra vObra) throws Exception{
        String[][] vArray = new String[vObra.getvItems().size()][5];
        
        Integer vPos = 0;
        for (Item a: vObra.getvItems()){
        
            vArray[vPos][0] = a.getvIdItem().toString();
            vArray[vPos][1] = a.getvDenominacion();
            vArray[vPos][2] = a.getvImpuestoFlete().toString() + "%";
            vArray[vPos][3] = a.getvImpuestoGastos().toString() + "%";
            vArray[vPos][4] = a.getvImpuestoUtilidad().toString() + "%";
            
            vPos = vPos + 1;
        }
        
        return vArray;
    }
    
    //--------------------------------------------------------------------------
    
    public void CrearCosto (Integer vIdObra, Integer vIdItem, Double vMonto, String vFechaInicioVigencia) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        
        if (vObra != null){
            Item vItem = vObra.BuscarItemId(vIdItem);
            
            if (vItem != null){
                
                Costo vNuevoCosto = new Costo (vItem.getvCostos().size()+1, vMonto, vFechaInicioVigencia);
                vItem.AgregarCosto(vNuevoCosto);
            }else{
                throw new Exception ("El item ingresado, no existe");
            }
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }

    //--------------------------------------------------------------------------
    
    public void CrearFojaMedicion (Integer vIdObra, String vFechaEmision) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        if (vObra != null){
            
            if (!vObra.getvItems().isEmpty()){
                
                FojaMedicion vNuevaFoja = new FojaMedicion (vFojas.size()+1, vFechaEmision, vObra);
                
                FojaMedicion vUltimaFoja = this.BuscarUltimaFoja(vIdObra);
                
                //Agregar condicion para cuando la fecha emision de la nueva foja es menor que el de la ultima foja
                
                vNuevaFoja.CrearRenglones(vUltimaFoja);
                
                this.vFojas.add(vNuevaFoja);
                
            }else{
                throw new Exception ("La obra ingresada, no tiene items incluidos");
            }
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }
    
    public FojaMedicion BuscarFojaMedicion (Integer vIdObra, String vFechaEmision) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        if (vObra != null){
            
            for (FojaMedicion a: vFojas){
                if (a.getvObra() == vObra){
                    
                    if (a.getvFechaEmision().equals(vFechaEmision)){
                        return a;
                    }
                }
            }
            return null;

        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
    }
    
    public FojaMedicion BuscarUltimaFoja (Integer vIdObra) throws Exception{
        Obra vObra = BuscarObraId(vIdObra);
        if (vObra != null){
            
            if (!vObra.getvItems().isEmpty()){
                
                Integer[] vFechaMayor = new Integer[3];
                
                vFechaMayor[0] = 0;
                vFechaMayor[1] = 0;
                vFechaMayor[2] = 0;
                FojaMedicion vUltimaFoja = null;

                for (FojaMedicion a: this.vFojas){

                    if (a.getvObra() == vObra){
                        Integer[] vFecha = new Integer[3];
                        vFecha = vAux.TransformarFecha(a.getvFechaEmision());

                        vFechaMayor = vAux.DevolverFechaMayor(vFecha, vFechaMayor);

                        if (vFechaMayor == vFecha){
                            vUltimaFoja = a;
                        }
                    }
                }
                
                return vUltimaFoja;
                
            }else{
                throw new Exception ("La obra ingresada, no tiene items incluidos");
            }
        }else{
            throw new Exception ("La obra ingresada, no existe");
        }
        
    }
    
    public void ActualizarFojaMedicion (Integer vIdObra, String vFechaEmision, Integer vPorcentajes[]) throws Exception {
        
        FojaMedicion vFoja = this.BuscarFojaMedicion(vIdObra, vFechaEmision);
        if (vFoja != null){
            
            if (vPorcentajes.length == vFoja.getvRenglones().size()){
                
                if (vAux.BuscarValorArray(vPorcentajes, null) == false){
                    
                    Integer vPos = 0;
                    for (RenglonFoja a: vFoja.getvRenglones()){
                        a.DefinirPorcentajeActual(vPorcentajes[vPos]);
                        vPos = vPos + 1;
                    }
                    
                }else{
                    throw new Exception ("No se puede asignar orden null a un porcentaje de avance");
                }
            }else{
                throw new Exception ("La cantidad de valores ingresada, no es igual a la cantidad de items de la foja");
            }
        }else{
            throw new Exception ("No se pudo encontrar a la foja buscada");
        }
    }
    
    //--------------------------------------------------------------------------
    
    public void CrearCertificadoPago (Integer vIdObra, String vFechaEmisionFoja, String vFechaEmisionCertificado) throws Exception{
        FojaMedicion vFoja = this.BuscarFojaMedicion(vIdObra, vFechaEmisionFoja);
        if (vFoja != null){
            
            CertificadoPago vNuevoCertificado = new CertificadoPago (this.vCertificados.size()+1, vFechaEmisionCertificado, vFoja.getvObra(), vFoja);
            
            vNuevoCertificado.CrearRenglones();
            vCertificados.add(vNuevoCertificado);
            
        }else{
            throw new Exception ("La foja ingresada, no existe");
        }
    }
    
    public CertificadoPago BuscarCertificadoId (Integer vIdCertificado){
        for (CertificadoPago a: vCertificados){
            if (Objects.equals(a.getvIdCertificado(), vIdCertificado)){
                return a;
            }
        }
        return null;
    }
    
    public Double DevolverCostoTotalCertificado (Integer vIdCertificado) throws Exception{
        CertificadoPago vCertificado = this.BuscarCertificadoId(vIdCertificado);
        if (vCertificado != null){
        
            return vCertificado.getvCostoTotal();
            
        }else{
            throw new Exception ("El certificado ingresado, no existe");
        }
    }

    //--------------------------------------------------------------------------
    //--VISTAS------------------------------------------------------------------
    
    private void CerrarVistas(){
        
        if (vVista1 != null){
            if (vVista1.isShowing()){
                vVista1.setVisible(false);
            }
        }
        
        if (vVista2 != null){
            if (vVista2.isShowing()){
                vVista2.setVisible(false);
            }
        }
        
        if (vVista3 != null){
            if (vVista3.isShowing()){
                vVista3.setVisible(false);
                
            }
        }
        
        if (vVista3A != null){
            if (vVista3A.isShowing()){
                vVista3A.setVisible(false);
            }
        }
        
    }
    
    public void AbrirVistaMenuPrincipal(){
        
        CerrarVistas();
        
        if (vVistaA == null){
            vVistaA = new VistaMenuPrincipal(this);
        }
                
        vVistaA.setVisible(true);
        
    }
    
    public void AbrirVistaEmpresas(){
        
        if (vVista1 == null){
            vVista1 = new VistaEmpresas(this);
        }else{
            vVista1.ActualizarTabla();
        }
        vVistaA.setVisible(false);
        vVista1.setVisible(true);
        
    }
    
    public void AbrirVistaFinanciaciones(){
        
        if (vVista2 == null){
            vVista2 = new VistaFinanciaciones(this);
        }else{
            vVista2.ActualizarTabla();
        }
        vVistaA.setVisible(false);
        vVista2.setVisible(true);
        
    }
    
    public void AbrirVistaObras1(){
        
        if (vVista3 == null){
            vVista3 = new VistaObras1(this);
        }else{
            vVista3.Reset();
        }
        
        vVistaA.setVisible(false);
        vVista3.setVisible(true);
        
    }
    
    public void AbrirVistaObras2(){
    
        vVista3.setVisible(false);
        
        if (vVista3A == null){
            vVista3A = new VistaObras2(this);
        }else{
            vVista3A.Reset();
        }
        
        vVista3A.setVisible(true);
    
    }
    
    //--------------------------------------------------------------------------

    public ArrayList<Financiacion> getvFinanciaciones() {
        return vFinanciaciones;
    }

    public ArrayList<Empresa> getvEmpresas() {
        return vEmpresas;
    }

    public ArrayList<Obra> getvObras() {
        return vObras;
    }

    public ArrayList<FojaMedicion> getvFojas() {
        return vFojas;
    }

    public ArrayList<CertificadoPago> getvCertificados() {
        return vCertificados;
    }
    
    

}

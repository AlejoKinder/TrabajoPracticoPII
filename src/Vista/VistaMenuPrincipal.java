/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.*;
import metodosIlegales.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;


/**
 *
 * @author Mauricio
 */
public class VistaMenuPrincipal extends JFrame {
    
    private JPanel vPCentro;
    
        private JButton vBotonEmpresas;
        private JButton vBotonFinanciaciones;
        
        private JPanel vPCentro3;
        
        private JButton vBotonObras1;
        private JButton vBotonObras2;
        
        private JPanel vPCentro4;
        
        private JButton vBotonFojas1;
        private JButton vBotonFojas2;
        private JButton vBotonFojas3;
        
        private JPanel vPCentro5;
        
        private JButton vBotonCP1;
        private JButton vBotonCP2;
    
    private Sistema vSis;
    
    //--------------------------------------------------------------------------
    
    public VistaMenuPrincipal (Sistema vSis){
        this.vSis = vSis;
        this.IniciarVista();
    }
    
    public void IniciarVista(){
        
        vPCentro = new JPanel();
        vPCentro.setLayout(new GridLayout(5, 1, 5, 5));
        
        
            vBotonEmpresas = new JButton("Ver empresas");
            vBotonFinanciaciones = new JButton("Ver financiaciones");

            vPCentro.add(vBotonEmpresas);
            vPCentro.add(vBotonFinanciaciones);
        
            vPCentro3 = new JPanel();
            vPCentro3.setLayout(new GridLayout(1, 2, 5, 5));
            
            vBotonObras1 = new JButton("Ver obras");
            vBotonObras2 = new JButton("Crear nueva obra");
            
            vPCentro3.add(vBotonObras1);
            vPCentro3.add(vBotonObras2);
            
            vPCentro.add(vPCentro3);
            
            vPCentro4 = new JPanel();
            vPCentro4.setLayout(new GridLayout(1, 3, 5, 5));
            
            vBotonFojas1 = new JButton("Ver fojas de medicion");
            vBotonFojas2 = new JButton("Crear nueva foja de medicion");
            vBotonFojas3 = new JButton("Actualizar foja de medicion");
            
            vPCentro4.add(vBotonFojas1);
            vPCentro4.add(vBotonFojas2);
            vPCentro4.add(vBotonFojas3);
            
            vPCentro.add(vPCentro4);
            
            vPCentro5 = new JPanel();
            vPCentro5.setLayout(new GridLayout(1, 2, 5, 5));
            
            vBotonCP1 = new JButton("Ver certificados de pago");
            vBotonCP2 = new JButton("Crear nuevo certificado de pago");
            
            vPCentro5.add(vBotonCP1);
            vPCentro5.add(vBotonCP2);
            
            vPCentro.add(vPCentro5);
            
        this.add(vPCentro, BorderLayout.CENTER);        
        
        //----------------------------------------------------------------------
        
        
        //----------------------------------------------------------------------
        
        setTitle("Menu principal");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //----------------------------------------------------------------------
        
        this.vBotonEmpresas.addActionListener((ActionEvent evt) -> {
            vSis.AbrirVistaEmpresas();
        });
        
        this.vBotonFinanciaciones.addActionListener((ActionEvent evt) -> {
            vSis.AbrirVistaFinanciaciones();
        });
        
        this.vBotonObras1.addActionListener((ActionEvent evt) -> {
            vSis.AbrirVistaObras1();
        });
        
    }
    
}

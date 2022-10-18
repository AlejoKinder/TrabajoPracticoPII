/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.*;
import modelo.*;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Mauricio
 */
public final class VistaEmpresas extends JFrame {
    
    private JPanel vGrilla;
    private JLabel vTxtA;
    private JLabel vTxtB;
    private JLabel vTxtC;
    private JLabel vTxtD;
    private JLabel vTxtE;
    
    private JTextField vA1;
    private JTextField vB1;
    private JTextField vC1;
    private JTextField vD1;
    private JTextField vE1;
    
    private JTextField vA2;
    private JTextField vB2;
    private JTextField vC2;
    private JTextField vD2;
    private JTextField vE2;
    
    private JTextField vA3;
    private JTextField vB3;
    private JTextField vC3;
    private JTextField vD3;
    private JTextField vE3;
    
    private JTextField vA4;
    private JTextField vB4;
    private JTextField vC4;
    private JTextField vD4;
    private JTextField vE4;
    
    private JTextField vA5;
    private JTextField vB5;
    private JTextField vC5;
    private JTextField vD5;
    private JTextField vE5;
    
    
    private Sistema vSis;
    
    //--------------------------------------------------------------------------
    
    public VistaEmpresas (Sistema vSis){
        this.vSis = vSis;
        this.IniciarVista();
    }
    
    public void IniciarVista(){
        
        vTxtA = new JLabel("CUIT");
        vTxtB = new JLabel("NOMBRE");
        vTxtC = new JLabel("DIRECCION");
        vTxtD = new JLabel("REP. LEGAL");
        vTxtE = new JLabel("REP. TECNICO");
        
        vA1 = new JTextField(10);
        vB1 = new JTextField(10);
        vC1 = new JTextField(10);
        vD1 = new JTextField(10);
        vE1 = new JTextField(10);
        
        vA2 = new JTextField(10);
        vB2 = new JTextField(10);
        vC2 = new JTextField(10);
        vD2 = new JTextField(10);
        vE2 = new JTextField(10);
        
        vA3 = new JTextField(10);
        vB3 = new JTextField(10);
        vC3 = new JTextField(10);
        vD3 = new JTextField(10);
        vE3 = new JTextField(10);
        
        vA4 = new JTextField(10);
        vB4 = new JTextField(10);
        vC4 = new JTextField(10);
        vD4 = new JTextField(10);
        vE4 = new JTextField(10);
        
        vA5 = new JTextField(10);
        vB5 = new JTextField(10);
        vC5 = new JTextField(10);
        vD5 = new JTextField(10);
        vE5 = new JTextField(10);
        
        //----------------------------------------------------------------------
        
        vGrilla = new JPanel();
        vGrilla.setLayout(new GridLayout(6,5));
        
        vGrilla.add(this.vTxtA);
        vGrilla.add(this.vTxtB);
        vGrilla.add(this.vTxtC);
        vGrilla.add(this.vTxtD);
        vGrilla.add(this.vTxtE);
        
        vGrilla.add(this.vA1);
        vGrilla.add(this.vB1);
        vGrilla.add(this.vC1);
        vGrilla.add(this.vD1);
        vGrilla.add(this.vE1);
        
        vGrilla.add(this.vA2);
        vGrilla.add(this.vB2);
        vGrilla.add(this.vC2);
        vGrilla.add(this.vD2);
        vGrilla.add(this.vE2);
        
        vGrilla.add(this.vA3);
        vGrilla.add(this.vB3);
        vGrilla.add(this.vC3);
        vGrilla.add(this.vD3);
        vGrilla.add(this.vE3);
        
        vGrilla.add(this.vA4);
        vGrilla.add(this.vB4);
        vGrilla.add(this.vC4);
        vGrilla.add(this.vD4);
        vGrilla.add(this.vE4);
        
        vGrilla.add(this.vA5);
        vGrilla.add(this.vB5);
        vGrilla.add(this.vC5);
        vGrilla.add(this.vD5);
        vGrilla.add(this.vE5);
        
        
        setContentPane(vGrilla);
        
        //----------------------------------------------------------------------
        
        setTitle("Empresas");
        setSize(600,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

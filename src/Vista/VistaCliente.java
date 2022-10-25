/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.*;
import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public final class VistaCliente extends JFrame implements WindowListener,ActionListener{

    // Atributos de los componentes de la ventana
    private JPanel panel;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JTextField txtNuevoNombre;
    private JButton btnActualizaNombre;

    public Sistema getMiControl() {
        return miControl;
    }

    public void setMiControl(Sistema miControl) {
        this.miControl = miControl;
    }

    // Relaciona a la ventana con el controlador correspondiente
    private Sistema miControl;


    // Método que actualiza la vista con el cliente recibido
    // por el controlador
    public void actualizarVista(Obra vObra){
        this.txtId.setText(vObra.getvIdObra().toString());
        this.txtNombre.setText(vObra.getvDenominacion());
        this.txtApellido.setText(vObra.getvDenominacion());
    }

    // Constructor
    public VistaCliente(){
        inicializaComponentes();
    }

    // Inicializa todos los componentes de la ventana
    public void inicializaComponentes(){
        // Instancia los componentes que se cargarán al JFrame
        panel = new JPanel();
        txtId = new JTextField(5);
        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        lblId = new JLabel("ID");
        lblNombre = new JLabel("NOMBRE");
        lblApellido = new JLabel("APELLIDO");
        txtNuevoNombre = new JTextField(20);
        btnActualizaNombre = new JButton("Actualiza Nombre");

        btnActualizaNombre.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaNombreActionPerformed(evt);
            }
        });

        // Setea como no editable las cajas de texto
        txtId.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);

        // Setea el layout del jpanel
        panel.setLayout(new GridLayout(4,2,5,5));

        // Carga los componentes al jpanel
        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(txtNuevoNombre);
        panel.add(btnActualizaNombre);



        // Carga el jpanel a la ventana (jframe)
        setContentPane(panel);

        // Setea el nombre de la ventana
        setTitle("Cliente");

        // Setea un tamaño por default
        setSize(300,200);

        // Setea el tipo de cierre que va a tener la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void btnActualizaNombreActionPerformed(ActionEvent evt){
        // recupera el texto de la caja de texto y actualiza el nombre del Cliente
        System.out.println("Nose");
        //miControl.setNombre(txtNuevoNombre.getText());
        //miControl.actualizarVentanaCliente();
        
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

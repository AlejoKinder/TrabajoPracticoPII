/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpi;
import Controlador.*;

/**
 *
 * @author alejo
 */
public class tpi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema controlador = new Sistema();
        
        controlador.crearEmpresa(23, "Pinturas Misioneras", "Uruaguay 4421", "Manuela alcachofa", "Celeste echeberria");
        controlador.crearEmpresa(24, "Iproda", "Junin 276", "Gustavo lopez", "Alejo Quinder");
        controlador.crearEmpresa(25, "ugd", "Juretch", "pereyra alegandro", "miuricio velasques");
        
        controlador.getEmpresas();
        
        
    }
    
}

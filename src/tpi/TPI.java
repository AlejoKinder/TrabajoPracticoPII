/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpi;
import Controlador.*;

/**
 * Prueba de la prueba
 * @author alejo
 */
public class TPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema controlador = new Sistema();
        
        controlador.crearEmpresa(23, "Pinturas Misioneras", "Uruaguay 4421", "Manuela alcachofa", "Celeste echeberria");
        controlador.crearEmpresa(24, "Iproda", "Junin 276", "Gustavo lopez", "Alejo Quinder");
        controlador.crearEmpresa(25, "ugd", "Juretch", "pereyra alegandro", "miuricio velasques");
        
        //controlador.getEmpresas();
        
        controlador.crearFinanciacion("Unicef");
        controlador.crearFinanciacion("NOse");
        controlador.crearFinanciacion("Aguante quique");
        controlador.crearFinanciacion("PAII");
        controlador.crearFinanciacion("Youtube");
        
        //controlador.getFinanciaciones();
        
        controlador.crearObra("101 viviendas", 10, 11, 3, 21, 25, "Aguante quique", 23);
        controlador.crearItemObra("pared", 2, 1, 500, "25/11/2000");
        controlador.crearItemObra("techo", 1, 1, 500, "25/11/2000");
        controlador.crearItemObra("vidrio", 2, 1, 500, "25/11/2000");
        controlador.crearItemObra("puerta", 2, 1, 500, "25/11/2000");
        
        controlador.crearObra("200 viviendas", 10, 13, 3, 21, 25, "PAII", 25);
        controlador.crearItemObra("pared", 2, 2, 500, "25/11/2000");
        controlador.crearItemObra("pared", 2, 2, 500, "25/11/2000");
        
        //controlador.getObrasEItems();
        
        controlador.crearCostoItem(2300.6, "13/10/2022", 2, 1);
        controlador.crearCostoItem(4000, "13/10/2022", 2, 1);
        controlador.crearCostoItem(4351.3, "13/10/2022", 2, 1);
        
        controlador.crearCostoItem(1000, "13/10/2022", 1, 4);
        controlador.crearCostoItem(1200, "13/10/2022", 1, 4);
        
        //controlador.getObrasEItems();
        
        controlador.crearFoja(1, "12/03/22", "110viviendas");
        controlador.crearCertificado("12/03/22", 1, 1);
    }
    
}


package tpi.paii;

import controlador.*;
import java.util.*;
import java.lang.*;
import vista.*;

/**
 *
 * @author dany_
 */
public class TPIPAII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Sistema vSis = new Sistema();
        
        try{
            vSis.CrearEmpresa(251100, "Thai Cuisine", "Newbery 3480", "Velazquez Mauricio", "Kinder Alejo");
            
            vSis.CrearFinanciacion("Ni idea");
            
            vSis.CrearObra("Itambe Guazu", "Posadas", 10, "13/10/2022", 12, 251100, 1);
            vSis.CrearObra("Itambe Mini", "Posadas", 20, "14/10/2022", 12, 251100, 1);
            
            vSis.CrearItem(1, "Piso", (float)2.5, (float)3.5, (float)4.5, (double)5000, "13/10/2022");
            vSis.CrearItem(1, "Paredes", (float)2.5, (float)3.5, (float)4.5, (double)7000, "13/10/2022");
            vSis.CrearItem(1, "Techo", (float)2.5, (float)3.5, (float)4.5, (double)8000, "13/10/2022");
            
            vSis.CrearCosto(1, 1, (double)7500, "14/10/2022");
            
            Integer[] vIncidencia = new Integer[3];
                    
            vIncidencia[0] = 10;
            vIncidencia[1] = 50;
            vIncidencia[2] = 40;
            
            Integer[] vOrden = new Integer[3];
            
            vOrden[0] = 3;
            vOrden[1] = 2;
            vOrden[2] = 1;
            
            vSis.RedefinirOrdenItems(1, vOrden);
            vSis.RedefinirIncidenciaItems(1, vIncidencia);
            
            vSis.DevolverCostosItems(1);
            
            vSis.CrearFojaMedicion(1, "15/10/2022");
            
            Integer[] vPorcentajes = new Integer[3];
            
            vPorcentajes[0] = 25;
            vPorcentajes[1] = 15;
            vPorcentajes[2] = 10;
            
            vSis.ActualizarFojaMedicion(1, "15/10/2022", vPorcentajes);
            
            System.out.println("El avance de la obra 1 es: " + vSis.DevolverAvanceObra(1) + "%");
            
            vSis.CrearCertificadoPago(1, "15/10/2022", "17/10/2022");
            
            System.out.println("El costo total de el certificado es: " + vSis.DevolverCostoTotalCertificado(1));
            
            //------------------------------------------------------------------
            
            vSis.AbrirVistaEmpresas();
            

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}

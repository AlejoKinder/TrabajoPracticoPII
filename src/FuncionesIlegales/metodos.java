/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesIlegales;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Mauricio
 */
public class metodos {
    
    public Integer[] TransformarFecha(String vFecha){
        
        String vFechaSeparada [] = vFecha.split("/+");
        
        Integer vFechaTransformada[] = new Integer[3];
        
        vFechaTransformada[0] = Integer.parseInt(vFechaSeparada[0]);
        vFechaTransformada[1] = Integer.parseInt(vFechaSeparada[1]);
        vFechaTransformada[2] = Integer.parseInt(vFechaSeparada[2]);
    
        return vFechaTransformada;
    }
    
    public Integer[] DevolverFechaMayor(String vFecha1, String vFecha2){
        
        Integer vFechaTransformada1[] = this.TransformarFecha(vFecha1);
        Integer vFechaTransformada2[] = this.TransformarFecha(vFecha2);

        //Comparacion de años
        if (vFechaTransformada1[2] > vFechaTransformada2[2]) {      
            return vFechaTransformada1;
        } else if (vFechaTransformada1[2] < vFechaTransformada2[2]) {
            return vFechaTransformada2;
        } else {
            
            //Comparacion de meses
            if (vFechaTransformada1[1] > vFechaTransformada2[1]) {
                return vFechaTransformada1;
            } else if (vFechaTransformada1[1] < vFechaTransformada2[1]) {
                return vFechaTransformada2;
            } else {
                
                //Comparacion de dias
                if (vFechaTransformada1[0] > vFechaTransformada2[0]) {
                    return vFechaTransformada1;
                } else if (vFechaTransformada1[0] < vFechaTransformada2[0]) {
                    return vFechaTransformada2;
                } else {
                    return vFechaTransformada2;
                }
            }
        }
    }
}
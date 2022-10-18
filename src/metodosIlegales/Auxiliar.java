/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosIlegales;
import java.util.Objects;

/**
 *
 * @author dany_
 */
public class Auxiliar {
    
     public Integer SumarArray(Integer vArray[]) {
        Integer vSumaTotal = 0;
        for (Integer a = 0; a < vArray.length; a++) {
            vSumaTotal = vSumaTotal +  vArray[a];
        }
        return vSumaTotal;
    }
    
    public boolean ValoresRepetidosArray(Integer vArray[]) {
        for (Integer a = 0; a < vArray.length; a++) {
            for (Integer b = (a+1); b < vArray.length; b++) {
                if (Objects.equals(vArray[a], vArray[b])){
                    return true; 
                }
            }
        }
        return false;
    }
    
    public boolean BuscarValorArray(Integer vArray[], Integer vBuscado){
        for (Integer a = 0; a < vArray.length; a++) {
            if (Objects.equals(vBuscado, vArray[a])){
                    return true; 
            }
        }
        return false;
    }
    
    public Integer[] TransformarFecha(String vFecha){
        
        String vFechaSeparada [] = vFecha.split("/+");
        
        Integer vFechaTransformada[] = new Integer[3];
        
        vFechaTransformada[0] = Integer.valueOf(vFechaSeparada[0]);
        vFechaTransformada[1] = Integer.valueOf(vFechaSeparada[1]);
        vFechaTransformada[2] = Integer.valueOf(vFechaSeparada[2]);
    
        return vFechaTransformada;
    }
    
    public Integer[] DevolverFechaMayor(Integer[] vFechaTransformada1, Integer[] vFechaTransformada2){
       

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

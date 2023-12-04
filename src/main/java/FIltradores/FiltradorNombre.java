/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FIltradores;

import Comparadores.ComparadorNombreContacto;
import Comparadores.ComparadorText;
import Estructuras.LinkedCircularDE;
import Estructuras.List;
import Modelo.Contacto;
import java.util.PriorityQueue;

/**
 *
 * @author danlevil
 */
public class FiltradorNombre {
    
    public List<Contacto> filtrarTexto(List<Contacto> lista, String param){
        List<Contacto> filtrada= new LinkedCircularDE();
        ComparadorNombreContacto cmp= new ComparadorNombreContacto();
        ComparadorText cmpText= new ComparadorText();
        PriorityQueue<Contacto> cola= new PriorityQueue(cmp);
        int bandera=lista.size();
        int contador=0;
        for(Contacto c: lista){
            if(cmpText.compare(c.getNombre(), param)==0){
                cola.offer(c);
            }
            
            if(contador==bandera){
                break;
            }
            contador++;
        } 
        while(!cola.isEmpty()){
            filtrada.add(cola.poll());
        }
        return filtrada;   
    }
    
}

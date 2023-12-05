/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FIltradores;

import Comparadores.ComparadorNombreContacto;
import Estructuras.LinkedCircularDE;
import Estructuras.List;
import Modelo.Contacto;
import java.util.PriorityQueue;

/**
 *
 * @author danlevil
 */
public class FiltradorPersonas {
    public List<Contacto> filtrarSoloPersonas(List<Contacto> lista){
        List<Contacto> filtrada= new LinkedCircularDE();
        ComparadorNombreContacto cmp= new ComparadorNombreContacto();
        PriorityQueue<Contacto> cola= new PriorityQueue(cmp);
        FiltroPersonas f1= new FiltroPersonas();
        int bandera=lista.size();
        int contador=0;
        for(Contacto c:lista){
            if(f1.compare(c, c)==0){
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

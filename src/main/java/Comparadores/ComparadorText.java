/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparadores;

import java.util.Comparator;

/**
 *
 * @author danlevil
 */
public class ComparadorText implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        int bandera=-1;
        if(o1.contains(o2)){
            bandera=0;
        }
        return bandera;
    }
    
}

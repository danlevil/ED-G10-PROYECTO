/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Scanner;

/**
 *
 * @author danlevil
 */
public class IngresoDatos {
    static Scanner sc;
    private IngresoDatos(){}
    
    public synchronized static Scanner getScan(){
        if(sc==null){
            sc= new Scanner(System.in);
        }
        
        return sc;
    }
    
}

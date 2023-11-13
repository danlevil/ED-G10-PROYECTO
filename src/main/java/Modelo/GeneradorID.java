/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author danlevil
 */
public class GeneradorID {
    private static final long serialVersionUID=1L;

    public int generar(){
        
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1024); 
        
        return numeroAleatorio;
    }
    
}

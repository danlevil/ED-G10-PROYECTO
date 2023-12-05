/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparadores;

import Modelo.Contacto;
import java.util.Comparator;

/**
 *
 * @author danlevil
 */
public class ComparadorPersona implements Comparator<Contacto> {

    @Override
    public int compare(Contacto o1, Contacto o2) {
        return Boolean.compare(!o2.isEmpresa(), !o1.isEmpresa());
    }
    
}

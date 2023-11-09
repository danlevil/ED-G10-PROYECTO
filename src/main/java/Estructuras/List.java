/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Estructuras;

/**
 *
 * @author danlevil
 */
public interface List<E> {
    
    public boolean add(E e);
    public boolean addFirst(E e);
    public E remove(int index);
    public E removeLast();
    
}

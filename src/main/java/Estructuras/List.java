/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Estructuras;

import Modelo.Contacto;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;

/**
 *
 * @author danlevil
 * @param <E>
 */
public abstract class List<E> implements Serializable, Collection<E>, Iterable<E>{
    private static final long serialVersionUID=1L;

    public abstract E getStart(); 
    public abstract boolean add(E e);
    public abstract boolean addFirst(E e);
    public abstract void add(int index, E e);
    public abstract E remove(int index);
    public abstract E remove(E e, Comparator cmp);
    public abstract E removeLast();
    public abstract int size();
    public abstract void clear();
    public abstract void moverFavorito();
    public abstract void recorrer();
    public abstract int encontrarElemento();
    public abstract E get(int i);
    public abstract boolean isEmpty();
    //agregado
    public abstract boolean addLast(E e); // inserta el elemento element al final

    

    
    
    
}

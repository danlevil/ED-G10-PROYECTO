/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author danlevil
 * @param <E> 
 */
public class ArrayList<E> extends List<E> {
    private static final long serialVersionUID=1L;

    private int capacidad=10;
    private int capacidadEfectiva=0;
    private E[] elementos;
    
    public ArrayList(){
       elementos= (E[])(new Object[capacidad]);
    }
    @Override
    public boolean add(E e) {
        if(capacidadEfectiva==capacidad){
            aumentarMemoria();
        
        }
        elementos[capacidadEfectiva]=e;
        capacidadEfectiva++;
        return true;
               
    }
   private void aumentarMemoria(){
        capacidad=capacidad+(capacidad/2);
        E[]nuevo= (E[])new Object[capacidad];
        for(int i=0;i<capacidadEfectiva;i++){
            nuevo[i]=elementos[i];
        }
        elementos=nuevo;
    }
 
    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        if(index<0 || index>capacidadEfectiva){
            throw new IndexOutOfBoundsException("Indice fuera del rango valido"); 
        }
        if (capacidadEfectiva==0){
            System.out.println("\nEl arrayList esta vacio\n");
        }
        
        int mover = capacidadEfectiva- (index+1);
        int nuevoInicio=index+1;
        E eliminado=elementos[index];
        for (int i=index;mover>0;i++){
            elementos[i]=elementos[nuevoInicio];
            mover--;
            nuevoInicio++;
        }
        capacidadEfectiva--;
        return eliminado;
        
    }


    @Override
    public int size() {
        return capacidadEfectiva;
    }


    @Override
    public void add(int index, E element) {
        if (capacidadEfectiva==0){
            System.out.println("El array esta vacio, agregando al inicio");
            elementos[0]= element;
            capacidadEfectiva++;
        }
        if(index>capacidadEfectiva){throw new IllegalArgumentException(""
                + "Espacios vacios dentro del arreglo");
        }
        if(capacidadEfectiva==capacidad){aumentarMemoria();}
        
        int mover = capacidadEfectiva-index; 
        int nuevoFinal;  
        int puntoPartida=capacidadEfectiva-1;
        
        for(nuevoFinal=capacidadEfectiva;mover>=0;nuevoFinal--){
            if(mover==capacidadEfectiva){mover-=1;}
            elementos[nuevoFinal]=elementos[puntoPartida];
            mover--;   
            puntoPartida--;
        }
        elementos[index]= element;
        capacidadEfectiva++;        
        
    }
    
   
    @Override
    public E getStart() {
        return elementos[0];
    }

    @Override
    public E remove(E e, Comparator cmp) {
        
        for(int i=0;i<capacidadEfectiva;i++){
            if(cmp.compare(get(i), e)==0){
                               
                return remove(i);
            }
        }
        return null;
        
    }
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public E get(int i) {
       return elementos[i];
    }

    @Override
    public boolean isEmpty() {
        if(capacidadEfectiva==0){return true;}
        return false;
    }
    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moverFavorito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void recorrer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int encontrarElemento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

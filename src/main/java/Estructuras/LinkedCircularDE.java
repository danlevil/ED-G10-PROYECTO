/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Modelo.Contacto;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author danlevil
 */
public class LinkedCircularDE<E> extends List<E> implements Iterable<E>{
    private static final long serialVersionUID=1L;

    private Nodo<E> start;
    private Nodo<E> viajero;
    private int tamaño=0;
    public LinkedCircularDE(){
        start=null;
    }

    @Override
    public void avanzar() {
        if(start!=null){
            viajero=start.getSiguiente();
        }
    }

    @Override
    public void retroceder() {
        if(start!=null){
            viajero=start.getPrevio();
        }
    }

    @Override
    public E obtenerActual() {
        return viajero!=null? viajero.getContenido(): null;
    }

    @Override
    public List<E> ordenar(Comparator cmp) {
        List<E> ordenada= new LinkedCircularDE();
        PriorityQueue<E> cola= new PriorityQueue(cmp);
        Nodo<E> n=this.start;
        while(this.size()!=cola.size()){
            E contenido=n.getContenido();
            cola.offer(contenido);
            n= n.getSiguiente();
        }
        while(!cola.isEmpty()){
            ordenada.add(cola.poll());
        }
        return ordenada;
    }
    
    public class Nodo<E> implements Serializable{
        E contenido;
        Nodo<E> siguiente;
        Nodo<E> previo;
        
        Nodo(){}
        Nodo(E cont){
            contenido= cont;
            siguiente=null;
            previo=null;
            
        }

        public Nodo<E> getPrevio() {
            return previo;
        }

        public void setPrevio(Nodo<E> previo) {
            this.previo = previo;
        }
        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
        public Nodo<E> getSiguiente() {
            return siguiente;
        }
        public E getContenido() {
            return contenido;
        }
    }

    
    
    
    @Override
    public E remove(E e, Comparator cmp) {
        Nodo<E>n;
        Nodo<E>eliminado;
        for(n=this.start;n!=null;n=n.getSiguiente()){
            if(cmp.compare(n, e)==0){
                eliminado=n;
                
                Nodo<E>previo=n.getPrevio();
                Nodo<E>sig= n.getSiguiente();
                
                previo.setSiguiente(sig);
                sig.setPrevio(previo);
                if(n==start){this.start=sig;}
                n.setPrevio(null);
                n.setSiguiente(null);
                tamaño--;
                return eliminado.getContenido();
            }
        }
        return null;
    }



    private LinkedCircularDE<E> copiarList(){
        LinkedCircularDE<E> copia= new LinkedCircularDE<E>();
        copia.add(this.start.contenido);
        Nodo<E> n;
        for(n=this.start.getSiguiente(); n!=null; n= n.getSiguiente()){
            if(n==this.start){break;}
            copia.add(n.getContenido());
        }
        return copia;
    }



    @Override
    public boolean isEmpty() {
        if(tamaño==0){return true;}
        if (this.start==null){return true;}
        return false;
    }



    @Override
    public Iterator<E> iterator() {
       return new Iterator<E>(){
            Nodo<E> actual = start;
            Nodo<E> sig = start;

            @Override
            public boolean hasNext() {
               return sig != null;
            }

            @Override
            public E next() {
              E elemento = sig.contenido; 
              sig = sig.siguiente;
              if(sig == actual){
                  sig = null;
              }
              return elemento;
            }          
        };    
    }

    
    
    @Override
    public boolean add(E e) {
        if(start==null){
            start= new Nodo(e);
            start.setSiguiente(this.start);
            start.setPrevio(this.start);
            tamaño++;
            return true;
        }
        Nodo<E> nuevoNodo= new Nodo(e);
        Nodo<E> inicio= this.start;
        Nodo<E> prevInicio=inicio.getPrevio();
        nuevoNodo.setPrevio(prevInicio);
        nuevoNodo.setSiguiente(inicio);
        inicio.setPrevio(nuevoNodo);
        prevInicio.setSiguiente(nuevoNodo);
 
        tamaño++;
        return true;

    }
    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        if(index<0 || index>=tamaño){
            throw new IndexOutOfBoundsException(
            "Indice fuera de los limites del LinkedLIst");
        }
        if (index==0){
            Nodo<E> eliminado= start;
            Nodo<E> sprevio= start.getPrevio();
            Nodo<E> snext=start.getSiguiente();
            snext.setPrevio(sprevio);
            sprevio.setSiguiente(snext);
            start=snext;
            eliminado.setPrevio(null);
            eliminado.setSiguiente(null);
            tamaño--;
            return eliminado.getContenido();
        }
        Nodo<E> encontrado=null;
        if(index<tamaño/2){
            encontrado=findNode(index);
        }
        else if(index>=tamaño/2){
            encontrado=findNodeInverso(index);
        }
        Nodo<E> anterior=encontrado.getPrevio();
        Nodo<E> next= encontrado.getSiguiente();
        anterior.setSiguiente(next);
        next.setPrevio(anterior);
        encontrado.setPrevio(null);
        encontrado.setSiguiente(null);
        tamaño--;
        
        
        return encontrado.getContenido();
    }
    private Nodo<E> findNode(int index){
        int count=0;
        Nodo <E> n;
        for(n=this.start;n!=null; n=n.getSiguiente()){
            if(count==index){
                return n;
            }
            count++;
        }
        return null;
    }
    private Nodo<E> findNodeInverso(int index){
        int count=tamaño-1;
        Nodo <E> n;
        for(n=this.start.getPrevio();n!=null; n=n.getPrevio()){
            if(count==index){
                return n;
            }
            count--;
        }
        return null;
    }
    @Override
    public E getStart() {
        if(start == null){
            return null;
        }
        return start.getContenido();
    }
    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int getTamaño() {
        return tamaño;
    }
    @Override
    public int size() {
        return getTamaño();
    }


    @Override
    public void add(int index, E element) {
        boolean pass=true;
        if(index<0 || index>tamaño){
            throw new IndexOutOfBoundsException(
            "Indice fuera de los límites del LinkedLIst");
        }
        else if (index==tamaño){
            add(element);
            pass=false;
        }
        Nodo<E> encontrado=null;
        if(index<tamaño/2){
            encontrado=findNode(index);
        }
        else if(index>=tamaño/2){
            encontrado=findNodeInverso(index);
        }
        Nodo <E> nuevoNodo= new Nodo(element);
        Nodo<E> anterior=encontrado.getPrevio();
        anterior.setSiguiente(nuevoNodo);
        nuevoNodo.setPrevio(anterior);
        encontrado.setPrevio(nuevoNodo);
        nuevoNodo.setSiguiente(encontrado);
        if(index==0){this.start=nuevoNodo;}
        tamaño++;
    }
    @Override
    public E get(int index) {
        if(index==0){return this.start.contenido;}
        else if (index<0){
            throw new IndexOutOfBoundsException(
                    "Indice fuera de los límites del LinkedLIst");
        }
        Nodo <E> encontrado=findNode(index);
        return (encontrado!=null)?encontrado.getContenido():null;
    }

    @Override
    public boolean remove(Object o) {
        Nodo <E> n;
        for(n=start;n!=null;n=n.getSiguiente()){
            if(n.getContenido().equals(o)){
                Nodo<E>previo=n.getPrevio();
                Nodo<E>sig= n.getSiguiente();
                previo.setSiguiente(sig);
                sig.setPrevio(previo);
                if(n==start){
                    start=sig;
                }
                n.setPrevio(null);
                n.setSiguiente(null);
                tamaño--;
                return true;
            }
        }
        return false;
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
        tamaño=0;
        start.previo=null;
        start.siguiente=null;
        start=null;
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
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

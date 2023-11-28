/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Modelo;


import Estructuras.LinkedCircularDE;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;



/**
 *
 * @author FreddyT
 */


public class Usuario implements Serializable {
        private String nombre; 
        //private String nombreArchivo;
        private String correo;
        private String contrasena;
        private static LinkedCircularDE<Usuario> usuarios;
    
    public Usuario(String nombre, String correo, String contrasena){
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }    
        
    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }   
    
    public static LinkedCircularDE<Usuario> cargarUsuarios(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/Usuarios/Usuarios.ser"))){
            usuarios = (LinkedCircularDE<Usuario>) in.readObject();
            }catch(FileNotFoundException e1){
                System.out.println(e1);
            }catch(IOException e2){
                System.out.println(e2);
            }catch(Exception e3){
                System.out.println(e3);
            }
        return usuarios; 
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return Objects.equals(this.contrasena, other.contrasena);
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }
    
    
}

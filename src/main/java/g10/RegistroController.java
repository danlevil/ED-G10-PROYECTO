/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Estructuras.LinkedCircularDE;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import Modelo.Alerta;
import Modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author FreddyT
 */
public class RegistroController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfContrasena;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrar(ActionEvent event) throws IOException {
        LinkedCircularDE<Usuario> usuarios = Usuario.cargarUsuarios();
        String nombre = tfNombre.getText();
        String usuario = tfUsuario.getText();
        String contrasena = tfContrasena.getText();
        Usuario u = new Usuario(nombre,usuario,contrasena);
 
        if(tfNombre.getText().equals("") || tfUsuario.getText().equals("") || tfContrasena.getText().equals("")){
            Alerta.mostrarAlerta(Alert.AlertType.ERROR,"Rellene todos los campos");
        }else if(tfContrasena.getText().length() < 6){
            Alerta.mostrarAlerta(Alert.AlertType.ERROR,"La contraseña debe tener más de 6 dígitos");        
        }else if(!usuarios.contains(u)){
            usuarios.addLast(u);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("files/Usuarios/usuarios.ser"))){
                out.writeObject(usuarios);
                out.flush();
            }catch(FileNotFoundException e1){
                System.out.println(e1);
            }catch(IOException e2){
                System.out.println(e2);
            }catch(Exception e3){
                System.out.println(e3);
            }         
            Alerta.mostrarAlerta(Alert.AlertType.INFORMATION,"Registrado correctamente");
            App.setRoot("inicio");
        }else{
            Alerta.mostrarAlerta(Alert.AlertType.ERROR,"Usuario ya registrado");
        } 
        
       
    }

    @FXML
    private void regresarInicio(ActionEvent event) throws IOException {
        App.setRoot("inicio");
    }
    
}

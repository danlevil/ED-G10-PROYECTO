/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;


import Estructuras.LinkedCircularDE;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Modelo.Alerta;
import Modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author FreddyT
 */
public class InicioSController implements Initializable {
    private ImageView ivlogo;
    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField tfContrasena;
    @FXML
    private ImageView ivLogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            FileInputStream in = new FileInputStream("src/main/resources/imagenes/logo.png");
            
            Image im = new Image(in);
            ivLogo.setImage(im);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra la imagen del Logo");
        }
        
        
    }
    @FXML
    private void Ingresar(ActionEvent event) throws IOException {
        LinkedCircularDE<Usuario> usuarios = Usuario.cargarUsuarios();
        String usuario = tfUsuario.getText();
        String contrasena = tfContrasena.getText();
        
        Usuario validacion = new Usuario("",usuario,contrasena);

        if(tfUsuario.getText().equals("") || tfContrasena.getText().equals("")){
            Alerta.mostrarAlerta(Alert.AlertType.ERROR,"Rellene todos los campos");
        }else if(usuarios.contains(validacion)){
            Alerta.mostrarAlerta(Alert.AlertType.INFORMATION,"Ingreso correcto");
            App.setRoot("aplicacion");
        }else{
            Alerta.mostrarAlerta(Alert.AlertType.ERROR,"Usuario no registrado");
        }
    }
    @FXML
    private void registrarUsuario(ActionEvent event) throws IOException {
        App.setRoot("Registro");
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class FiltroContactoController implements Initializable {
    private static final long serialVersionUID=1L;


    @FXML
    private Button btFiltroNombre;
    @FXML
    private Button btFiltroNacionalidad;
    @FXML
    private Button btFiltroFavoritos;
    @FXML
    private ImageView imgRegresar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void filtrarEmpresas(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaFiltroContactoEmpresa.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            
            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
            stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void filtrarFavoritos(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaFiltroContactoFavorito.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            
            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
            stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
    @FXML
    private void irVentanaContactos(MouseEvent event) throws IOException {
        App.setRoot("ListaContactos");
    }

    @FXML
    private void filtrarPorPersonas(ActionEvent event) {
        
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaFiltroContactos.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            
            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
            stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

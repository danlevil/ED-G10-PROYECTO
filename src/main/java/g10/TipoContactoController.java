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
public class TipoContactoController implements Initializable {

    private static Scene escenaTipoContacto;
    @FXML
    private Button btContactPersona;
    @FXML
    private Button btContactEmpresa;
    @FXML
    private ImageView imgVolver;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void irVentanPersonas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarContactoPersona.fxml"));
        Parent root = loader.load();

        // Configurar el controlador 
        AgregarContactoPersonaController agp = loader.getController();
        // pasando datos al controlador de la nueva ventana aquí, si es necesario

        // Crear una nueva escena
        Scene scene = new Scene(root, 900, 700);

        // Configurar el tamaño fijo de la ventana
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Nueva Ventana");
        nuevaVentana.setScene(scene);
        nuevaVentana.setResizable(false);

        // Mostrar la nueva ventana
        nuevaVentana.show();
    }

    @FXML
    private void irVentanEmpresas(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarContactoEmpresa.fxml"));
        Parent root = loader.load();

        // Configurar el controlador 
        AgregarContactoEmpresaController age = loader.getController();
        // pasando datos al controlador de la nueva ventana aquí, si es necesario

        // Crear una nueva escena
        Scene scene = new Scene(root, 900, 700);

        // Configurar el tamaño fijo de la ventana
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Nueva Ventana");
        nuevaVentana.setScene(scene);
        nuevaVentana.setResizable(false);

        // Mostrar la nueva ventana
        nuevaVentana.show();
       // stage.close();
    }

    @FXML
    private void irVentanaContactos(MouseEvent event) throws IOException {
        App.setRoot("ListaContactos");
    }

}

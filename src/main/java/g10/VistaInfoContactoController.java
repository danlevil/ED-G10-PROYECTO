/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Contacto;
import Modelo.ContactoPersona;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class VistaInfoContactoController implements Initializable {
    private static final long serialVersionUID=1L;


    @FXML
    private Label labelRegistarContacto;
    @FXML
    private ImageView imgFotoContacto;
    @FXML
    private Label lbnombreCP;
    @FXML
    private Label lbcorreoCP;
    @FXML
    private Label lbcelulerPCP;
    @FXML
    private Label lbDireccionCP;
    @FXML
    private Label lbDireccionTCP;
    @FXML
    private Label lbFechaCP;
    @FXML
    private Label lbcelularTCP;
    @FXML
    private ImageView imgGM;
    @FXML
    private Label lbEtiquetasCP;
    @FXML
    private Button btContactAsoci;
    @FXML
    private Label LblDescrFecha;
    @FXML
    private ImageView editarFotosCP;
    @FXML
    private ImageView editarNombreCP;
    @FXML
    private ImageView editarCorreoCP;
    @FXML
    private ImageView nuevoCorreoCP;
    @FXML
    private ImageView verTodoslosCorreosCP;
    @FXML
    private ImageView editarCelularPCP;
    @FXML
    private ImageView nuevoCelularPCP;
    @FXML
    private ImageView verTodoslosCelularesPCP;
    @FXML
    private ImageView editarDireccionCCP;
    @FXML
    private ImageView nuevoDireccionCCP;
    @FXML
    private ImageView verTodaslasDireecionesCCP;
    @FXML
    private ImageView editarDireccionTCP;
    @FXML
    private ImageView nuevoDireccionTCP;
    @FXML
    private ImageView verTodasLasDireccionesTCP;
    @FXML
    private ImageView editarFechaICP;
    @FXML
    private ImageView nuevaFechaICP;
    @FXML
    private ImageView verTodaslasFechasICP;
    @FXML
    private ImageView editarCelularTCP;
    @FXML
    private ImageView nuevoCelularTCP;
    @FXML
    private ImageView verTodoslosCelularesTCP;
    @FXML
    private ImageView editarLinkCP;
    @FXML
    private ImageView editarEtiquetasCP;
    @FXML
    private ImageView nuevaEtiquetaCP;
    @FXML
    private ImageView verTodaslasEtiquetasCP;
    @FXML
    private ImageView eliminarCP;
    @FXML
    private Label contactoId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void configurar(ContactoPersona contacto) {
        lbnombreCP.setText(contacto.getName());
        lbcorreoCP.setText(contacto.getCorreo().getDireccionCorreo());
        lbcelulerPCP.setText(contacto.getTelefonoPersonal().getNumero());
        lbDireccionCP.setText (contacto.getDireccionPersonal().getUbicacion());
        lbDireccionTCP.setText (contacto.getDireccion().getUbicacion());
        lbFechaCP.setText(contacto.getFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getFechaImportante().getFechaDescripcion());
        lbcelularTCP.setText(contacto.getTelefono().getNumero());
        //falta poner etiquetas y link para google maps   
      
     }
    
    private void editarContacto(MouseEvent event) {
        System.out.println("Contacto Editado");
    }


    @FXML
    private void mostrarVentanAsociados(ActionEvent event) {
    }

    private void regresarAListaContactos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
        stage.close();
        
        Platform.runLater(() -> {
        try {
            // Crear una nueva instancia de la aplicación
            App nuevaInstancia = new App();

            // Llamar al método start para iniciar la nueva instancia
            nuevaInstancia.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         });
    }

    @FXML
    private void editarFotoDeContacto(MouseEvent event) {
    }

    @FXML
    private void editarNombre(MouseEvent event) {
    }

    @FXML
    private void editarCorreo(MouseEvent event) {
    }

    @FXML
    private void agregarNuevoCorreo(MouseEvent event) {
    }

    @FXML
    private void verCorreos(MouseEvent event) {
    }

    @FXML
    private void editarCelularPersonal(MouseEvent event) {
    }

    @FXML
    private void agregarCelularPersonal(MouseEvent event) {
    }

    @FXML
    private void mostrarCelularesPersonales(MouseEvent event) {
    }

    @FXML
    private void editarDireccionCasa(MouseEvent event) {
    }

    @FXML
    private void agregarDireccionCasa(MouseEvent event) {
    }

    @FXML
    private void verDireccionCasa(MouseEvent event) {
    }

    @FXML
    private void editarDireccionTrabajo(MouseEvent event) {
    }

    @FXML
    private void agregarDireccionTrabajo(MouseEvent event) {
    }

    @FXML
    private void verDireccionTrabajo(MouseEvent event) {
    }

    @FXML
    private void editarFechaImportante(MouseEvent event) {
    }

    @FXML
    private void agregarFechaImportante(MouseEvent event) {
    }

    @FXML
    private void VerFechasImportantes(MouseEvent event) {
    }

    @FXML
    private void editarCelularTrabajo(MouseEvent event) {
    }

    @FXML
    private void agregarCelularTrabajo(MouseEvent event) {
    }

    @FXML
    private void verCelularesTrabajo(MouseEvent event) {
    }

    @FXML
    private void editarLinkDeGMaps(MouseEvent event) {
    }

    @FXML
    private void editarEtiqueta(MouseEvent event) {
    }

    @FXML
    private void agregarEtiqueta(MouseEvent event) {
    }

    @FXML
    private void verEtiquetas(MouseEvent event) {
    }

    @FXML
    private void eliminarContacto(MouseEvent event) {
    }

}

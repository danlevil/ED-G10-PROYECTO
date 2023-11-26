/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.ContactoEmpresa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class VistaContactoEmpresaController implements Initializable {
    private static final long serialVersionUID=1L;

    @FXML
    private Label labelRegistarContacto;
    @FXML
    private ImageView imgFotoContactoE;
    @FXML
    private Label lbnombreCE;
    @FXML
    private Label lbcorreoCE;
    @FXML
    private Label lbcelulerCE;
    @FXML
    private Label lbFechaCE;
    @FXML
    private Label lblCargo;
    @FXML
    private ImageView imgGM;
    @FXML
    private Label lbEtiquetasCP;
    @FXML
    private Button btContactAsoci;
    @FXML
    private Label lbcelularTCE;
    @FXML
    private Label lbDireccionTCE;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label LblDescrFecha;
    @FXML
    private ImageView editarFotosCE;
    @FXML
    private ImageView editarNombreCE;
    @FXML
    private ImageView editarCorreoCE;
    @FXML
    private ImageView nuevoCorreoCE;
    @FXML
    private ImageView verTodoslosCorreosCE;
    @FXML
    private ImageView editarCelularPCE;
    @FXML
    private ImageView nuevoCelularPCE;
    @FXML
    private ImageView verTodoslosCelularesPCE;
    @FXML
    private ImageView editarCargoCE;
    @FXML
    private ImageView editarLinkCE;
    @FXML
    private ImageView editarEtiquetasCE;
    @FXML
    private ImageView nuevaEtiquetaCE;
    @FXML
    private ImageView verTodaslasEtiquetasCE;
    @FXML
    private ImageView editarCelularTCE;
    @FXML
    private ImageView nuevoCelularTCE;
    @FXML
    private ImageView verTodoslosCelularesTCE;
    @FXML
    private ImageView editarDireccionTCE;
    @FXML
    private ImageView nuevoDireccionTCE;
    @FXML
    private ImageView verTodasLasDireccionesTCE;
    @FXML
    private ImageView editarTituloCE;
    @FXML
    private ImageView editarFechaICE;
    @FXML
    private ImageView nuevaFechaICE;
    @FXML
    private ImageView verTodaslasFechasICE;
    @FXML
    private ImageView eliminarCE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void configurar(ContactoEmpresa contacto) {
        lbnombreCE.setText(contacto.getNombre());
        lbcorreoCE.setText(contacto.getCorreoPrincipal().toString());
        lbcelulerCE.setText(contacto.getTelefonoPersonal().getNumero());
        lbDireccionTCE.setText (contacto.getDireccionPrincipal().toString());
        lbFechaCE.setText(contacto.getPrimeraFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getPrimeraFechaImportante().getFechaDescripcion());
        lbcelularTCE.setText(contacto.getTelefonoPrincipal().getNumero());
        lblCargo.setText(contacto.getPuestoTrabajo());
        lblTitulo.setText(contacto.getTitulo());
        //falta poner etiquetas y link para google maps   
      
     }
    
    


    @FXML
    private void mostrarVentanAsociados(ActionEvent event) {
    }

    @FXML
    private void editarFotoDeContacto(MouseEvent event) {
    }

    @FXML
    private void editarNombreCE(MouseEvent event) {
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
    private void editarCargoCEmpresa(MouseEvent event) {
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
    private void editarCelularTrabajo(MouseEvent event) {
    }

    @FXML
    private void agregarCelularTrabajo(MouseEvent event) {
    }

    @FXML
    private void verCelularesTrabajo(MouseEvent event) {
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
    private void editarTituloCE(MouseEvent event) {
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
    private void eliminarContacto(MouseEvent event) {
    }
    
}

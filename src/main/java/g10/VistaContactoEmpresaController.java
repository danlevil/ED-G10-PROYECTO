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
    private Button btVermasinfo;
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
    
    

    /*private void editarContacto(MouseEvent event) {
        System.out.println("Contacto Editado");
    }*/

    @FXML
    private void mostrarInfoExtra(ActionEvent event) {
    }

    @FXML
    private void mostrarVentanAsociados(ActionEvent event) {
    }
    
}

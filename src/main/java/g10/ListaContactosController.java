/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class ListaContactosController implements Initializable {


    @FXML
    private ImageView imgFiltro;
    @FXML
    private ImageView imgBotonAgregar;
    @FXML
    private Label txtFiltro;
    @FXML
    private ImageView imgcontacto1;
    @FXML
    private Label lbcontactonombre1;
    @FXML
    private Label lbcontactocorreo1;
    @FXML
    private ImageView imgcontacto2;
    @FXML
    private Label lbcontactonombre2;
    @FXML
    private Label lbcontactocorreo2;
    @FXML
    private ImageView imgcontacto3;
    @FXML
    private Label lbcontactonombre3;
    @FXML
    private Label lbcontactocorreo3;
    @FXML
    private ImageView imgcontacto4;
    @FXML
    private Label lbcontactonombre4;
    @FXML
    private Label lbcontactocorreo4;
    @FXML
    private ImageView imgcontacto5;
    @FXML
    private Label lbcontactonombre5;
    @FXML
    private Label lbcontactocorreo5;
    @FXML
    private ImageView imgcontacto6;
    @FXML
    private Label lbcontactonombre6;
    @FXML
    private Label lbcontactocorreo6;
    @FXML
    private ImageView imgBotonant;
    @FXML
    private Label lbnumpag;
    @FXML
    private ImageView imgBotonsig;
    /**
     * Initializes the controller class.
     */
    
    private static Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void filtrar(MouseEvent event) {
    }

    @FXML
    private void añadirContacto(MouseEvent event) throws IOException {
       App.setRoot("TipoContactos");
    }

    @FXML
    private void avanzarIzquierda(MouseEvent event) {
    }

    @FXML
    private void avanzarDerecha(MouseEvent event) {
    }

}

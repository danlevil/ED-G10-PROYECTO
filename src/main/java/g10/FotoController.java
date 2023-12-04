/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Estructuras.LinkedCircularDE;
import Estructuras.List;
import Fields.Foto;
import Modelo.Contacto;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class FotoController implements Initializable {
    private static final long serialVersionUID=1L;
    @FXML
    public ImageView imagen;
    
    public Contacto contactoSeleccionado;
    
    private int id;
    @FXML
    private Label imgID;
    @FXML
    private HBox HboxImg;
    public Image fotoSeleccionada;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    public void configurar(Foto foto){
        if(foto!=null){
            String rutaFoto= foto.getArchivo();
            Image image=new Image("file:"+rutaFoto);
            imagen.setImage(image);
            fotoSeleccionada=image;
            System.out.println(imgID.getText());
        }else {
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Sin Fotos");
            alerta.setHeaderText(null);
            alerta.setContentText("El usuario no tiene fotos para mostrar. Empiece agregando una.");
            alerta.showAndWait();
        }
    }
    
}

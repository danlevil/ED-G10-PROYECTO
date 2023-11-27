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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class FotoController implements Initializable {

    @FXML
    private ImageView imagen;
    
    public Contacto contactoSeleccionado;
    
    private int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void configurar(Foto foto) {
        //this.contactoSeleccionado = contacto;
         // Obtener la lista de fotos del contacto
        //List<Foto> fotos = contacto.getFotos();

        // Verificar si hay al menos una foto en la lista
        if (foto!=null) {
            // Obtener la primera foto de la lista
            //Foto primeraFoto = fotos.get(0);

            // Obtener la ruta de la foto desde la primera foto
            String rutaFoto = foto.getArchivo();

            // Crear un objeto Image desde la ruta del archivo
            Image image = new Image("file:" + rutaFoto);

            // Establecer la imagen en el ImageView
            imagen.setImage(image);
        } else {
            // Manejar el caso en el que no hay fotos disponibles
            System.out.println("El contacto no tiene fotos.");
        }
        
    }
    
}

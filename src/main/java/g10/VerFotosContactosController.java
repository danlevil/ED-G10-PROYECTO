/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class VerFotosContactosController implements Initializable {
    private static final long serialVersionUID=1L;
    @FXML
    private ImageView regresar;
    @FXML
    private ImageView izquierda;
    @FXML
    private ImageView derecha;
    @FXML
    private Label idContacto;
    @FXML
    private VBox vboxFotos;
    
    private static final int ELEMENTOS_POR_PAGINA=1;
    
    private static int paginaActual=1;
    @FXML
    private Label lbnumpag;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void configurarFotosContactos(Contacto contacto){
        
        
    }    

    
    
    
    void mostrarImg(Contacto c) {
            
        idContacto.setText(String.valueOf(c.getId()));
        vboxFotos.getChildren().clear();  
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Foto.fxml"));
            Node  imageView = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            FotoController controllerFoto = loader.getController();
            
            controllerFoto.configurar(c.getFotos().get(paginaActual));

            // Agregar el HBox al VBox
            
            int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
            int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, c.getFotos().size());
     
             for (int i = inicio; i < fin; i++) {
              vboxFotos.getChildren().add(imageView);
            }
   
            lbnumpag.setText( String.valueOf(paginaActual));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
     
     
    @FXML
    private void regresarPantalla(MouseEvent event) {
    }

    @FXML
    private void anterior(MouseEvent event) {
        
        int id = Integer.parseInt(idContacto.getText());
        
          Contacto contactoSeleccionado = buscarContactoPorId(id);    

        int totalPaginas = (int) Math.ceil((double) contactoSeleccionado.getFotos().size() / ELEMENTOS_POR_PAGINA);

        if (paginaActual > 1) {
            paginaActual--;
        } else {
            // Si estamos en la primera página, vamos al final
            paginaActual = totalPaginas;
        }

        mostrarImg(contactoSeleccionado);
            
        
    }

    @FXML
    private void siguiente(MouseEvent event) {
        
        int id = Integer.parseInt(idContacto.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);    

        int totalPaginas = (int) Math.ceil((double) contactoSeleccionado.getFotos().size() / ELEMENTOS_POR_PAGINA);

        if (paginaActual < totalPaginas) {
            paginaActual++;
        } else {
            // Si estamos en la primera página, vamos al final
            paginaActual = 1;
        }

        mostrarImg(contactoSeleccionado);
        
    }
    
    private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }
    
    
}

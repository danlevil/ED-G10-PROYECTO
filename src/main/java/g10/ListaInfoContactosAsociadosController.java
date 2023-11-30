/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import Modelo.ContactoPersona;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class ListaInfoContactosAsociadosController implements Initializable {

    @FXML
    private Label lblNombreContacto;
    @FXML
    private ImageView imgFiltro;
    @FXML
    private ImageView imgBotonAgregar;
    @FXML
    private Label txtFiltro;
    @FXML
    private VBox VboxContactos;
    @FXML
    private ImageView imgBotonant;
    @FXML
    private Label lbnumpag;
    @FXML
    private ImageView imgBotonsig;
    @FXML
    private Label IdContacto;
    
    private static final int ELEMENTOS_POR_PAGINA=6;
    private static int paginaActual=1;
    @FXML
    private ImageView ImgvolverAcontacto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void configurarContactosAsociados(Contacto contacto){
        IdContacto.setText(String.valueOf(contacto.getId()));
        lblNombreContacto.setText(contacto.getNombre());
        mostrarElementosContactosAsociados(contacto);
    }
    
    
    private void mostrarElementosContactosAsociados(Contacto contacto){
         
         VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, contacto.getContactosRelacionados().size());

        for (int i = inicio; i < fin; i++) {
            agregarHBoxContactos(contacto);
        }

        lbnumpag.setText( String.valueOf(paginaActual));
     }
    
     private void agregarHBoxContactos(Contacto contacto){
    
           try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ContactoAsociado.fxml"));
            Parent contactoNode = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            ContactoAsociadoController controller = loader.getController();
            int contactoAsociadoIndex = VboxContactos.getChildren().size();
            controller.configurar(contacto,  contacto.getContactosRelacionados().get(contactoAsociadoIndex),contactoAsociadoIndex);

            // Agregar el HBox al VBox
            VboxContactos.getChildren().add(contactoNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         
     }
    
    
    @FXML
    private void filtrar(MouseEvent event) {
    }

    @FXML
    private void añadirContacto(MouseEvent event) throws IOException {
        
        int id = Integer.parseInt(IdContacto.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        int numeroDeContactoNuevo = contactoSeleccionado.getContactosRelacionados().size();
        System.out.println(numeroDeContactoNuevo);
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TipoContactoAsociado.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            TipoContactoAsociadoController controller = loader.getController();
            controller.configurarTipoContactoAs(contactoSeleccionado, numeroDeContactoNuevo); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de celulares de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    @FXML
    private void volverAcontactoPadre(MouseEvent event) {
        int id = Integer.parseInt(IdContacto.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
         if (contactoSeleccionado.isEmpresa()) {
                // Abrir la vista de contacto para empresas y pasar los datos
                System.out.println("soy de empresa "+contactoSeleccionado.getId());
                abrirVistaContactoEmpresa(contactoSeleccionado);
            } else {
                // Abrir la vista de contacto para personas y pasar los datos
                abrirVistaContactoPersona(contactoSeleccionado);
            }
            
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage.close();
        
    }
    
     private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }
     
     
     private void abrirVistaContactoEmpresa(Contacto contacto) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaContactoEmpresa.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaContactoEmpresaController controller = loader.getController();
            controller.configurar((ContactoEmpresa) contacto); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de Contacto para Empresas");
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void abrirVistaContactoPersona(Contacto contacto) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInfoContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaInfoContactoController controller = loader.getController();
            controller.configurar((ContactoPersona) contacto); // Método para pasar los datos del contacto
            
            
            
            Scene scene = new Scene(root, 900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista de Contacto para Personas");
            
            stage.setResizable(false);
          
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void avanzarIzquierda(MouseEvent event) {
    }

    @FXML
    private void avanzarDerecha(MouseEvent event) {
    }

    
    
}

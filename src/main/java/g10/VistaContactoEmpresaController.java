/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import Modelo.ContactoPersona;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @FXML
    private ImageView volverContactos;
    @FXML
    private Label contactoId;

    private Contacto seleccionado;
    Stage momentaneoStage= new Stage();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void configurar(ContactoEmpresa contacto) {
        this.seleccionado=contacto;
        lbnombreCE.setText(contacto.getNombre());
        lbcorreoCE.setText(contacto.getCorreoPrincipal().toString());
        lbcelulerCE.setText(String.valueOf(contacto.getTelefonos().get(1)));
        lbDireccionTCE.setText (contacto.getDireccionPrincipal().toString());
        lbFechaCE.setText(contacto.getPrimeraFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getPrimeraFechaImportante().getFechaDescripcion());
        lblCargo.setText(contacto.getPuestoTrabajo());
        lblTitulo.setText(contacto.getTitulo());
        contactoId.setText(String.valueOf(contacto.getId()));

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
        int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmar Eliminación");
        alert.setHeaderText("¿Está seguro que desea eliminar este contacto?");
        alert.setContentText("Esta acción no se puede deshacer.");
        ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
        ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
        
        Optional<ButtonType> resultado = alert.showAndWait();
        
        if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {
           Agenda.contactosEmpresas.remove(contactoSeleccionado);
           Agenda.contactosMaster.remove(contactoSeleccionado);
        
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information Dialog");
            alert1.setHeaderText("Resultado de la operación");
            alert1.setContentText("Contacto eliminado exitosamente");
            alert1.showAndWait();
        
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage.close();
        
            Platform.runLater(() -> {
            try {

            App nuevaInstancia = new App();
            nuevaInstancia.start(new Stage());
            } catch (Exception e) {
            e.printStackTrace();
            }
             });
        } else {
                // El usuario ha hecho clic en "Cancelar" o ha cerrado el Alert
                // No realizar ninguna acción
          }
    }

    @FXML
    private void volverListContacts(MouseEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage.close();
        
         Platform.runLater(() -> {
        try {

            App nuevaInstancia = new App();
            nuevaInstancia.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         });
        
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

            Scene scene = new Scene(root,780,700);
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
            
            
            
            Scene scene = new Scene(root, 780,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista de Contacto para Personas");
            
            stage.setResizable(false);
          
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

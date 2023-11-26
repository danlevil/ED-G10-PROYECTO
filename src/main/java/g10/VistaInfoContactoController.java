/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Contacto;
import Modelo.ContactoPersona;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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
    
    private Contacto contacto;
    Stage momentarioStage= new Stage();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void configurar(ContactoPersona contacto) {
        this.contacto=contacto;
        lbnombreCP.setText(contacto.getNombre());
        lbcorreoCP.setText(contacto.getCorreoPrincipal().getDireccionCorreo());
        lbcelulerPCP.setText(contacto.getTelefonoPrincipal().getNumero());
        lbDireccionCP.setText (contacto.getDireccionPrincipal().getUbicacion());
        lbDireccionTCP.setText (contacto.getDirecciones().get(1).getUbicacion());
        lbFechaCP.setText(contacto.getPrimeraFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getPrimeraFechaImportante().getFechaDescripcion());
        lbcelularTCP.setText(contacto.getTelefonoPrincipal().getNumero());
        //falta poner etiquetas y link para google maps   
      
     }
    private void avisarActualizacion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Contacto actualizado exitosamente");
        alert.showAndWait();
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
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo  nombre");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.setNombre(nuevoValor);
            avisarActualizacion();
        });
        
        
                
    }

    @FXML
    private void editarCorreo(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo  nombre");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getCorreoPrincipal().setDireccionCorreo(nuevoValor);
            avisarActualizacion();
        });
    }
    @FXML
    private void editarCelularPersonal(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo  celular Personal");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getTelefonoPrincipal().setNumero(nuevoValor);
            avisarActualizacion();
        });
        
    }
    @FXML
    private void editarDireccionCasa(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nueva Direccion domicilio");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getDireccionPrincipal().setUbicacion(nuevoValor);
            avisarActualizacion();
        });
        
    }
    @FXML
    private void editarDireccionTrabajo(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nueva Direccion de trabajo");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getDirecciones().get(1).setUbicacion(nuevoValor);
            avisarActualizacion();
        });
        
    }
       @FXML
    private void editarFechaImportante(MouseEvent event) {
        
        DatePicker datePicker = new DatePicker();
        TextField textField = new TextField();
        
        // Configurar el botón
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            contacto.getPrimeraFechaImportante().setFecha(datePicker.getValue());
            contacto.getPrimeraFechaImportante().setDescripcion(textField.getText());
            momentarioStage.close();
            avisarActualizacion();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Seleccione la fecha:"), 0, 0);
        gridPane.add(datePicker, 1, 0);
        gridPane.add(new Label("Ingrese un valor:"), 0, 1);
        gridPane.add(textField, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 300, 200);

        // Configurar y mostrar la ventana principal
        momentarioStage.setScene(scene);
        momentarioStage.show();
    }
    @FXML
    private void editarCelularTrabajo(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nueva celular de trabajo");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getTelefonos().get(1).setNumero(nuevoValor);
            avisarActualizacion();
        });
    }
 
    @FXML
    private void editarEtiqueta(MouseEvent event) {
    }

    
    @FXML
    private void agregarNuevoCorreo(MouseEvent event) {
    }

    @FXML
    private void verCorreos(MouseEvent event) {
    }

   

    @FXML
    private void agregarCelularPersonal(MouseEvent event) {
    }

    @FXML
    private void mostrarCelularesPersonales(MouseEvent event) {
    }

    
    @FXML
    private void agregarDireccionCasa(MouseEvent event) {
    }

    @FXML
    private void verDireccionCasa(MouseEvent event) {
    }

    

    @FXML
    private void agregarDireccionTrabajo(MouseEvent event) {
    }

    @FXML
    private void verDireccionTrabajo(MouseEvent event) {
    }

 

    @FXML
    private void agregarFechaImportante(MouseEvent event) {
    }

    @FXML
    private void VerFechasImportantes(MouseEvent event) {
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
    private void agregarEtiqueta(MouseEvent event) {
    }

    @FXML
    private void verEtiquetas(MouseEvent event) {
    }

    @FXML
    private void eliminarContacto(MouseEvent event) {
    }

}

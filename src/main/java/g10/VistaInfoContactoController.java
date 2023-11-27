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
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
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
    @FXML
    private ImageView volverContactos;

    Stage momentaneoStage= new Stage();

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
        contactoId.setText(String.valueOf(contacto.getId()));
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
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FotosContactos.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            FotosContactosController controller = loader.getController();
           // controller.configurar((ContactoEmpresa) contacto); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,600,400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de fotos de Contactos");
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
        stage.close();
        
          
        int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
            if (contactoSeleccionado.isEmpresa()) {
                // Abrir la vista de contacto para empresas y pasar los datos
                abrirVistaContactoEmpresa(contactoSeleccionado);
            } else {
                // Abrir la vista de contacto para personas y pasar los datos
                abrirVistaContactoPersona(contactoSeleccionado);
            }
        
            
          
                
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
            momentaneoStage.close();
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
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
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
    private void editarLinkDeGMaps(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nueva direccion");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getDireccionPrincipal().setUbicacion(nuevoValor);
            avisarActualizacion();
        });
    }
    @FXML
    private void editarEtiqueta(MouseEvent event) {
    }

    
    @FXML
    private void agregarNuevoCorreo(MouseEvent event) {
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nuevo Correo");

        // Crear los TextFields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.setPromptText("Ingrese descripcion del correo");
        textField1.setPromptText("Ingrese el correo");

        // Configurar los botones
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            // Obtener los valores de los TextFields
            String valor1 = textField1.getText();
            String valor2 = textField2.getText();

            // Hacer algo con los valores (puedes imprimirlos, almacenarlos, etc.)
            contacto.agregarEmail(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Ingrese el valor 1:"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("Ingrese el valor 2:"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
    }

    

   

    @FXML
    private void agregarCelularPersonal(MouseEvent event) {
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nuevo Correo");

        // Crear los TextFields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.setPromptText("Ingrese descripcion del celular");
        textField1.setPromptText("Ingrese el celular");

        // Configurar los botones
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            // Obtener los valores de los TextFields
            String valor1 = textField1.getText();
            String valor2 = textField2.getText();

            // Hacer algo con los valores (puedes imprimirlos, almacenarlos, etc.)
            contacto.agregarTelefono(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Ingrese el valor 1:"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("Ingrese el valor 2:"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
    }
    
    @FXML
    private void agregarFechaImportante(MouseEvent event) {
    }
    
    @FXML
    private void agregarDireccionCasa(MouseEvent event) {
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nuevo Correo");

        // Crear los TextFields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.setPromptText("Ingrese descripcion de la direccion");
        textField1.setPromptText("Ingrese la direccion");

        // Configurar los botones
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            // Obtener los valores de los TextFields
            String valor1 = textField1.getText();
            String valor2 = textField2.getText();

            // Hacer algo con los valores (puedes imprimirlos, almacenarlos, etc.)
            contacto.agregarDireccion(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Ingrese el valor 1:"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("Ingrese el valor 2:"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
    }
    @FXML
    private void agregarDireccionTrabajo(MouseEvent event) {
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nuevo Correo");

        // Crear los TextFields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.setPromptText("Ingrese descripcion del trabajo");
        textField1.setPromptText("Ingrese la direccion");

        // Configurar los botones
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            // Obtener los valores de los TextFields
            String valor1 = textField1.getText();
            String valor2 = textField2.getText();

            // Hacer algo con los valores (puedes imprimirlos, almacenarlos, etc.)
            contacto.agregarDireccion(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Ingrese el valor 1:"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("Ingrese el valor 2:"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
    }
    

    @FXML
    private void agregarCelularTrabajo(MouseEvent event) {
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nuevo Correo");

        // Crear los TextFields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.setPromptText("Ingrese descripcion del celular de trabajo");
        textField1.setPromptText("Ingrese el celular");

        // Configurar los botones
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            // Obtener los valores de los TextFields
            String valor1 = textField1.getText();
            String valor2 = textField2.getText();

            // Hacer algo con los valores (puedes imprimirlos, almacenarlos, etc.)
            contacto.agregarTelefono(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Ingrese el valor 1:"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("Ingrese el valor 2:"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
    }
    @FXML
    private void agregarEtiqueta(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("ADD");
        dialog.setHeaderText("Ingrese un nueva etiqueta");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getEtiquetas().add(nuevoValor);
            avisarActualizacion();
        });
    }
    @FXML
    private void verCelularesTrabajo(MouseEvent event) {
    }

    

@FXML
    private void mostrarCelularesPersonales(MouseEvent event) {
    }

    @FXML
    private void verDireccionCasa(MouseEvent event) {
    }

    

    

    @FXML
    private void verDireccionTrabajo(MouseEvent event) {
    }

 

    

    @FXML
    private void VerFechasImportantes(MouseEvent event) {
    }





    @FXML
    private void verEtiquetas(MouseEvent event) {
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
           Agenda.contactosPersonas.remove(contactoSeleccionado);
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
    private void verCorreos(MouseEvent event) {
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
    
    @FXML
    private void mostrarFotosContacto(MouseEvent event) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("verFotosContactos.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VerFotosContactosController controller = loader.getController();
           // controller.configurar((ContactoEmpresa) contacto); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,600,400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista fotos de Contactos");
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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

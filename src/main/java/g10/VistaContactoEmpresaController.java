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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
    @FXML
    private Label idContactoPadre;
    @FXML
    private Label IdContactoAenLaListaDeCP;
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
    
    
    public Contacto getSeleccionado(){
         return seleccionado;
     }
    private void avisarActualizacion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Contacto actualizado exitosamente");
        alert.showAndWait();
    }
    
    private void reload(MouseEvent event){
        String idHijo =IdContactoAenLaListaDeCP.getText();
        String idPadre = idContactoPadre.getText();
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
                 abrirVistaContactoPersona(contactoSeleccionado,idPadre, idHijo);
            }
    }
    
    


    @FXML
    private void mostrarVentanAsociados(ActionEvent event) {
    }

    
    
    
    
    
    @FXML
    private void editarFotoDeContacto(MouseEvent event) {
        
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FotosContactos.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            FotosContactosController controller = loader.getController(); 
            controller.mostrarImg((Contacto) seleccionado); // Método para pasar los datos del contacto
           
            Scene scene = new Scene(root,600,400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de fotos de Contacto");
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     @FXML
    private void verFotosContactoEm(MouseEvent event) {
        
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("verFotosContactos.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VerFotosContactosController controller = loader.getController(); 
            controller.mostrarImg((Contacto) seleccionado); // Método para pasar los datos del contacto
           
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
    private void editarNombreCE(MouseEvent event) {
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo  nombre");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            seleccionado.setNombre(nuevoValor);
            avisarActualizacion();
        });
        
        reload(event);  
    }

 
    
    
    @FXML
    private void editarCorreo(MouseEvent event) {
      TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Cambie la direccion de correo");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            seleccionado.getCorreoPrincipal().setDireccionCorreo(nuevoValor);
            avisarActualizacion();
        });
        reload(event);  
        
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
            seleccionado.agregarEmail(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
            avisarActualizacion();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Ingrese descripcion del correo"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("Ingrese el correo:"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
        
    }

    @FXML
    private void verCorreos(MouseEvent event) {
        /*@FXML
    private Label idContactoPadre;
    @FXML
    private Label IdContactoAenLaListaDeCP;*/
        
        String idPadre = idContactoPadre.getText();
        String indiceEnListaPadre = IdContactoAenLaListaDeCP.getText();
        int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarCorreo(contactoSeleccionado,idPadre, indiceEnListaPadre); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de correos de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
           Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
           stage1.close();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }

    
    
    
    
    
    @FXML
    private void editarCelularPersonal(MouseEvent event) {
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo  celular Personal");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            seleccionado.getTelefonoPrincipal().setNumero(nuevoValor);
            avisarActualizacion();
        });
        reload(event);
        
    }

    @FXML
    private void agregarCelularPersonal(MouseEvent event) {
        
         momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nuevo Celular personal");

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
            seleccionado.agregarTelefono(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
            avisarActualizacion();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Descripcion del celular"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("numero celular"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
        
    }

    @FXML
    private void mostrarCelularesPersonales(MouseEvent event) {
        String idPadre = idContactoPadre.getText();
        String indiceEnListaPadre = IdContactoAenLaListaDeCP.getText();
        int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarCelularPersonal(contactoSeleccionado, idPadre, indiceEnListaPadre); // Método para pasar los datos del contacto

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
    private void editarCargoCEmpresa(MouseEvent event) {
        
        int id = Integer.parseInt(contactoId.getText());
        
        ContactoEmpresa contactoSeleccionado = (ContactoEmpresa) buscarContactoPorId(id);
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo cargo");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contactoSeleccionado.setPuestoTrabajo(nuevoValor);
            avisarActualizacion();
        });
        reload(event);
        
    }

    
    
    
    
    @FXML
    private void editarLinkDeGMaps(MouseEvent event) {
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nueva direccion");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            seleccionado.getDireccionPrincipal().setUbicacion(nuevoValor);
            avisarActualizacion();
        });
        reload(event); 
        
    }

    
    
    
    
    @FXML
    private void editarEtiqueta(MouseEvent event) {
    }
    
    

    @FXML
    private void agregarEtiqueta(MouseEvent event) {
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("ADD");
        dialog.setHeaderText("Ingrese un nueva etiqueta");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            seleccionado.getEtiquetas().add(nuevoValor);
            avisarActualizacion();
        });
        
        
    }

    @FXML
    private void verEtiquetas(MouseEvent event) {
    }


    
    
    
    @FXML
    private void editarDireccionTrabajo(MouseEvent event) {
        
       TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Cambie a un nueva Direccion");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            seleccionado.getDirecciones().get(1).setUbicacion(nuevoValor);
            avisarActualizacion();
        });
        reload(event);  
        
    }
    
    
    
    @FXML
    private void agregarDireccionTrabajo(MouseEvent event) {
        
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nueva direccion");

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
            seleccionado.agregarDireccion(valor1, valor2);

            // Cerrar la ventana momentánea
            momentaneoStage.close();
            avisarActualizacion();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Descripcion de la direccion"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("direccion"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 500, 300);

        // Configurar y mostrar la ventana momentánea
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
        
        
    }

    @FXML
    private void verDireccionTrabajo(MouseEvent event) {
        
        String idPadre = idContactoPadre.getText();
        String indiceEnListaPadre = IdContactoAenLaListaDeCP.getText();
        
        int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarDireccionesP(contactoSeleccionado, idPadre, indiceEnListaPadre); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de dirección de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

  
    
    @FXML
    private void editarTituloCE(MouseEvent event) {
        
        int id = Integer.parseInt(contactoId.getText());
        
        ContactoEmpresa contactoSeleccionado = (ContactoEmpresa) buscarContactoPorId(id);
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo Titulo");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contactoSeleccionado.setTitulo(nuevoValor);
            avisarActualizacion();
        });
        reload(event);
        
        
    }

    
    @FXML
    private void editarFechaImportante(MouseEvent event) {
        
         DatePicker datePicker = new DatePicker();
        TextField textField = new TextField();
        
        // Configurar el botón
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            seleccionado.getPrimeraFechaImportante().setFecha(datePicker.getValue());
            seleccionado.getPrimeraFechaImportante().setDescripcion(textField.getText());
            momentaneoStage.close();
            avisarActualizacion();
            reload(event);
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Seleccione la fecha:"), 0, 0);
        gridPane.add(datePicker, 1, 0);
        gridPane.add(new Label("Nueva descripcion de la fecha:"), 0, 1);
        gridPane.add(textField, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 300, 200);

        // Configurar y mostrar la ventana principal
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
        
    }

    @FXML
    private void agregarFechaImportante(MouseEvent event) {
        DatePicker datePicker = new DatePicker();
        TextField textField = new TextField();
        
        // Configurar el botón
        Button guardarButton = new Button("Agregar");
        guardarButton.setOnAction(e -> {
            
            // Obtener los valores de los TextFields
            LocalDate valor1 = datePicker.getValue();
            String valor2 = textField.getText();

            // Hacer algo con los valores (puedes imprimirlos, almacenarlos, etc.)
            seleccionado.agregarFechaImportante(valor2,valor1 );

            // Cerrar la ventana momentánea
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
        gridPane.add(new Label("Nueva descripcion de la fecha:"), 0, 1);
        gridPane.add(textField, 1, 1);
        gridPane.add(guardarButton, 0, 2, 2, 1);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 300, 200);

        // Configurar y mostrar la ventana principal
        momentaneoStage.setScene(scene);
        momentaneoStage.show();
        
    }

    @FXML
    private void VerFechasImportantes(MouseEvent event) {
        String idPadre = idContactoPadre.getText();
        String indiceEnListaPadre = IdContactoAenLaListaDeCP.getText();
        
         int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarFechasI(contactoSeleccionado, idPadre,indiceEnListaPadre ); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de fechas importantes de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
          
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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

    private void abrirVistaContactoPersona(Contacto contacto, String idPadre, String indiceListaDePadre) {
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

   
}

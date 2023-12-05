/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Fields.Foto;
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
import javafx.scene.image.Image;
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
    private Label lbDireccionTCP;
    @FXML
    private Label lbFechaCP;
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
    private ImageView editarFechaICP;
    @FXML
    private ImageView nuevaFechaICP;
    @FXML
    private ImageView verTodaslasFechasICP;
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
    

    @FXML
    private ImageView volverContactos;

    Stage momentaneoStage= new Stage();
    @FXML
    private Label IdContactoAenLaListaDeCP;
    @FXML
    private Label idContactoPadre;
    @FXML
    private Label AyO;

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
        lbFechaCP.setText(contacto.getPrimeraFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getPrimeraFechaImportante().getFechaDescripcion());
        contactoId.setText(String.valueOf(contacto.getId()));

        AyO.setText("O");
        

        if (contacto.getFotos().size()!=0){
            imgFotoContacto.setImage(new Image("file:"+contacto.getFotos().getStart().getArchivo()));
        }

        //falta poner etiquetas y link para google maps   
      
     }
     
     //ver cómo ocupar este método para que salga la vista con los dos labeles llenos
     public void configurarCompleto(ContactoPersona contacto, String idPadre, String indiceListaDePadre) {
        this.contacto=contacto;
        lbnombreCP.setText(contacto.getNombre());
        lbcorreoCP.setText(contacto.getCorreoPrincipal().getDireccionCorreo());
        lbcelulerPCP.setText(contacto.getTelefonoPrincipal().getNumero());
        lbDireccionCP.setText (contacto.getDireccionPrincipal().getUbicacion());
        lbFechaCP.setText(contacto.getPrimeraFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getPrimeraFechaImportante().getFechaDescripcion());
        contactoId.setText(String.valueOf(contacto.getId()));
        idContactoPadre.setText(idPadre); 
        IdContactoAenLaListaDeCP.setText(indiceListaDePadre);
        
        //falta poner etiquetas y link para google maps   
      
     }
     
     
     public void configurarAsociado(ContactoPersona contacto, int idPadre, int indiceListaDePadre) {
         this.contacto=contacto;
        lbnombreCP.setText(contacto.getNombre());
        lbcorreoCP.setText(contacto.getCorreoPrincipal().getDireccionCorreo());
        lbcelulerPCP.setText(contacto.getTelefonoPrincipal().getNumero());
        lbDireccionCP.setText (contacto.getDireccionPrincipal().getUbicacion());
        lbFechaCP.setText(contacto.getPrimeraFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getPrimeraFechaImportante().getFechaDescripcion());
        contactoId.setText(String.valueOf(contacto.getId()));
        idContactoPadre.setText(String.valueOf(idPadre)); 
        IdContactoAenLaListaDeCP.setText(String.valueOf(indiceListaDePadre));
        AyO.setText("A");
     }
     
     public Contacto getSeleccionado(){
         return contacto;
     }
    private void avisarActualizacion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Contacto actualizado exitosamente");
        alert.showAndWait();
    }
    
    
    
    private Contacto encontrarContacto(){
       int id = Integer.parseInt(contactoId.getText());
        
       Contacto contactoSeleccionado = buscarContactoPorId(id);
       return contactoSeleccionado;
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
    
    
    
    private void reloadAsociado(MouseEvent event, Contacto contacto){
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    // Cerrar la ventana actual
                    stage.close();

                        if (contacto.isEmpresa()) {
                            // Abrir la vista de contacto para empresas y pasar los datos
                            abrirVistaContactoEmpresa(contacto);
                        } else {
                            // Abrir la vista de contacto para personas y pasar los datos
                            abrirVistaContactoPersonaAsociada(contacto,Integer.parseInt(contacto.getIdContactoPadre()), Integer.parseInt(contacto.getIdcontactoEnListaDePadre()));
                        }
        
    }
    
     private void reloadAsociadoOOriginal(MouseEvent event, Contacto contactoSeleccionado){
        if (!IdContactoAenLaListaDeCP.getText().equals("Label")){
                    
                 reloadAsociado(event, contactoSeleccionado);
            }else{
                 reload(event); 
                 
             }
    }
    
    
    private void editarContacto(MouseEvent event) {
        System.out.println("Contacto Editado");
    }


    @FXML
    private void mostrarVentanAsociados(ActionEvent event) {
        
        int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaInfoContactosAsociados.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            ListaInfoContactosAsociadosController controller = loader.getController();
            controller.configurarContactosAsociados(contactoSeleccionado); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de contactos asociados de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    

//    private void regresarAListaContactos(MouseEvent event) throws IOException {
//       regresarAListaContactosOriginal(event);
//    }
    
      @FXML
    private void volverListContacts(MouseEvent event) throws IOException {
        /*int idContacto = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(idContacto);
        
        if (AyO.getText().equals("A")){
          regresarAListaContactosAsociados(event, contactoSeleccionado);  
        }else if (AyO.getText().equals("O")){
            regresarAListaContactosOriginal(event);
            System.out.println(idContactoPadre.getText());
        }*/
        if ("Label".equals(idContactoPadre.getText()) == true){
            regresarAListaContactosOriginal(event);
            System.out.println(idContactoPadre.getText());
       }else{
            regresarAListaContactosAsociados(event);
        }
          
         
    }
    
  private void regresarAListaContactosOriginal(MouseEvent event) throws IOException {
      
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
 
  private void regresarAListaContactosAsociados(MouseEvent event) throws IOException {
      
       int id = Integer.parseInt(idContactoPadre.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaInfoContactosAsociados.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            ListaInfoContactosAsociadosController controller = loader.getController();
            controller.configurarContactosAsociados(contactoSeleccionado); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de contactos asociados de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
      
  }
  
  
  
    @FXML
    private void editarFotoDeContacto(MouseEvent event) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FotosContactos.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            FotosContactosController controller = loader.getController(); 
            controller.mostrarImg((Contacto) contacto); // Método para pasar los datos del contacto
            System.out.println("contacto id: "+contacto.getId());

            controller.getBtSeleccionar().setOnAction(e->{
                Image f= controller.fotoPerfil;
                imgFotoContacto.setImage(f);
                contacto.getFotos().moverPrincipio(controller.fotoPrimera);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
                stage.close();
                System.out.println("me estoy seleccionando");
            });
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
        
        Contacto contactoSeleccionado = encontrarContacto();
        
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo  nombre");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.setNombre(nuevoValor);
            avisarActualizacion();
        });
        
        reload(event);  
         
    }
    
   
    
    @FXML
    private void editarCorreo(MouseEvent event) {
           Contacto contactoSeleccionado = encontrarContacto();
            /*  private Label IdContactoAenLaListaDeCP;
    @FXML
    private Label idContactoPadre;*/
           
            
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Editor");
            dialog.setHeaderText("Cambie la direccion de correo");

            Optional<String> resultado = dialog.showAndWait();

            resultado.ifPresent(nuevoValor -> {
                contacto.getCorreoPrincipal().setDireccionCorreo(nuevoValor);
                avisarActualizacion();
            });
            
            reloadAsociadoOOriginal(event, contactoSeleccionado);
  
    }
    
    
    
    @FXML
    private void editarCelularPersonal(MouseEvent event) {
        Contacto contactoSeleccionado = encontrarContacto();
        
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nuevo  celular Personal");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getTelefonoPrincipal().setNumero(nuevoValor);
            avisarActualizacion();
        });
        
        reloadAsociadoOOriginal(event, contactoSeleccionado);
        
        
        
    }
    @FXML
    private void editarDireccionCasa(MouseEvent event) {
        
        Contacto contactoSeleccionado = encontrarContacto();
        
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nueva Direccion domicilio");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getDireccionPrincipal().setUbicacion(nuevoValor);
            avisarActualizacion();
        });
         reloadAsociadoOOriginal(event, contactoSeleccionado);
  
 
    }
    private void editarDireccionTrabajo(MouseEvent event) {
        Contacto contactoSeleccionado = encontrarContacto();
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Cambie a un nueva Direccion de trabajo");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getDirecciones().get(1).setUbicacion(nuevoValor);
            avisarActualizacion();
        });
        reloadAsociadoOOriginal(event, contactoSeleccionado);
        
        
        
        
    }
       @FXML
    private void editarFechaImportante(MouseEvent event) {
 
        Contacto contactoSeleccionado = encontrarContacto();
 
        DatePicker datePicker = new DatePicker();
        TextField textField = new TextField();
        
        // Configurar el botón
        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            contacto.getPrimeraFechaImportante().setFecha(datePicker.getValue());
            contacto.getPrimeraFechaImportante().setDescripcion(textField.getText());
            momentaneoStage.close();
            avisarActualizacion();
            reloadAsociadoOOriginal(event, contactoSeleccionado);
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
    
    
    private void editarCelularTrabajo(MouseEvent event) {
        
        Contacto contactoSeleccionado = encontrarContacto();
        
        
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Cambie el  celular de trabajo");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getTelefonos().get(1).setNumero(nuevoValor);
            avisarActualizacion();
        });
        
        reloadAsociadoOOriginal(event, contactoSeleccionado);
   
        
    }
    
    @FXML
    private void editarLinkDeGMaps(MouseEvent event) {
        
        
        Contacto contactoSeleccionado = encontrarContacto();
        
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editor");
        dialog.setHeaderText("Ingrese un nueva direccion");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(nuevoValor -> {
            contacto.getDireccionPrincipal().setUbicacion(nuevoValor);
            avisarActualizacion();
        });
        reloadAsociadoOOriginal(event, contactoSeleccionado); 
         
         
         
         
         
         
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
            contacto.agregarTelefono(valor1, valor2);

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
            contacto.agregarFechaImportante(valor2,valor1 );

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
    private void agregarDireccionCasa(MouseEvent event) {
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
            contacto.agregarDireccion(valor1, valor2);

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
    private void agregarDireccionTrabajo(MouseEvent event) {
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nueva Direccion de trabajo");

        // Crear los TextFields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.setPromptText("Descripcion direccion trabajo");
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
            avisarActualizacion();
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Descripcion direccion trabajo"), 0, 0);
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
    

    private void agregarCelularTrabajo(MouseEvent event) {
        momentaneoStage = new Stage();
        momentaneoStage.setTitle("Nuevo Celular de trabajo");

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
            avisarActualizacion();  
            
        });

        // Crear la disposición del diseño
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Descripcion celular"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("celular trabajo"), 0, 1);
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
    
    
//    private void verCelularesTrabajo(MouseEvent event) {
//        
//         int id = Integer.parseInt(contactoId.getText());
//        
//        Contacto contactoSeleccionado = buscarContactoPorId(id);
//         try {
//            // Cargar el archivo FXML de la vista de contacto para personas
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
//            Parent root = loader.load();
//
//            // Configurar el controlador de la vista de contacto para personas
//            InfoDeDatosContactoController controller = loader.getController();
//            controller.configurarCelularPersonal(contactoSeleccionado); // Método para pasar los datos del contacto
//
//            Scene scene = new Scene(root,900,700);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setResizable(false);
//            stage.setTitle("Vista de celulares de contacto: "+contactoSeleccionado.getNombre());
//            stage.show();
//            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//          // Cerrar la ventana actual
//          stage1.close();
//            
//           
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//         
//    }

    

    @FXML
    private void mostrarCelularesPersonales(MouseEvent event) {
        
        
         int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarCelularPersonal(contactoSeleccionado); // Método para pasar los datos del contacto

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
    private void verDireccionCasa(MouseEvent event) {
        int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarDireccionesP(contactoSeleccionado); // Método para pasar los datos del contacto

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

    

    

//    private void verDireccionTrabajo(MouseEvent event) {
//        
//        int id = Integer.parseInt(contactoId.getText());
//        
//        Contacto contactoSeleccionado = buscarContactoPorId(id);
//         try {
//            // Cargar el archivo FXML de la vista de contacto para personas
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
//            Parent root = loader.load();
//
//            // Configurar el controlador de la vista de contacto para personas
//            InfoDeDatosContactoController controller = loader.getController();
//            controller.configurarDireccionesP(contactoSeleccionado); // Método para pasar los datos del contacto
//
//            Scene scene = new Scene(root,900,700);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setResizable(false);
//            stage.setTitle("Vista de correos de contacto: "+contactoSeleccionado.getNombre());
//            stage.show();
//            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//          // Cerrar la ventana actual
//          stage1.close();
//           
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//    }

 

    

    @FXML
    private void VerFechasImportantes(MouseEvent event) {
        
         int id = Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarFechasI(contactoSeleccionado); // Método para pasar los datos del contacto

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
    private void verEtiquetas(MouseEvent event) {
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void eliminarContacto(MouseEvent event) {
        
//        if (IdContactoAenLaListaDeCP.getText().equals("Label") == true){
//            eliminarContactoOriginal(event);
//       }
          eliminarContactosPrincipalyAsociados(event);
        

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    private void eliminarContactoOriginalPrincipal(MouseEvent event){
//        int idDeContactoAEliminar =Integer.parseInt(contactoId.getText());
//        
//        Contacto contactoSeleccionado = buscarContactoPorId(idDeContactoAEliminar);
//        
//        String idDeContactoPadre = contactoSeleccionado.getIdContactoPadre();
//        String IndiceEnListaDeContactoPadre = contactoSeleccionado.getIdcontactoEnListaDePadre();
//        int idContactoPadre;
//        int indiceEnListaDeCP;
//        
//        if (idDeContactoPadre.equals("Label") == false && IndiceEnListaDeContactoPadre.equals("Label") == false ){
//            
//            idContactoPadre = Integer.parseInt(idDeContactoPadre);
//            Contacto ContactoPadre = buscarContactoPorId(idContactoPadre);
//            indiceEnListaDeCP = Integer.parseInt(IndiceEnListaDeContactoPadre);
//            
//            
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Confirmar Eliminación");
//            alert.setHeaderText("¿Está seguro que desea eliminar este contacto?");
//            alert.setContentText("Esta acción no se puede deshacer.");
//            ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
//            ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
//            alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
//            Optional<ButtonType> resultado = alert.showAndWait();
//        
//            if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {
//                
//                if(contactoSeleccionado.getContactosRelacionados().size()>=1){
//                    int id = 0;
//                         //for (Contacto contacto : contactoSeleccionado.getContactosRelacionados()){
//                            while (id < contactoSeleccionado.getContactosRelacionados().size()) {
//                               Contacto contactoEncontrado = buscarContactoPorId(id);
//                               contactoSeleccionado.getContactosRelacionados().remove(contactoEncontrado);
//                               Agenda.eliminarPersona((ContactoPersona)contactoEncontrado);
//                                Agenda.contactosMaster.remove(contactoEncontrado); 
//                                id++;
//                              }
//                             //contactoSeleccionado.getContactosRelacionados().remove(contacto);
//                            // Agenda.eliminarPersona((ContactoPersona)contacto);
//                            // Agenda.contactosMaster.remove(contacto);                      
//                         //}
//                         
//                }else{
//                
//                        Agenda.eliminarPersona((ContactoPersona)contactoSeleccionado);
//                        Agenda.contactosMaster.remove(contactoSeleccionado);
//                        ContactoPadre.getContactosRelacionados().remove(indiceEnListaDeCP);
//
//                         Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//                         alert1.setTitle("Information Dialog");
//                         alert1.setHeaderText("Resultado de la operación");
//                         alert1.setContentText("Contacto eliminado exitosamente");
//                         alert1.showAndWait();
//
//                         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//                         // Cerrar la ventana actual
//                         stage.close();
//
//                         Platform.runLater(() -> {
//                         try {
//
//                         App nuevaInstancia = new App();
//                         nuevaInstancia.start(new Stage());
//                         } catch (Exception e) {
//                         e.printStackTrace();
//                         }
//                          });
//                      }
//                    
//                }
//           
//                
//
//            }else if(idDeContactoPadre.equals("Label") == true && IndiceEnListaDeContactoPadre.equals("Label") == true) {
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                 alert.setTitle("Confirmar Eliminación");
//                 alert.setHeaderText("¿Está seguro que desea eliminar este contacto?");
//                 alert.setContentText("Esta acción no se puede deshacer.");
//                 ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
//                 ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
//                 alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
//
//                 Optional<ButtonType> resultado = alert.showAndWait();
//
//                 if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {
//                     
//                     if(contactoSeleccionado.getContactosRelacionados().size()>=1){
//                         
//                          int id = 0;
//                         //for (Contacto contacto : contactoSeleccionado.getContactosRelacionados()){
//                            while (id < contactoSeleccionado.getContactosRelacionados().size()) {
//                               Contacto contactoEncontrado = buscarContactoPorId(id);
//                               contactoSeleccionado.getContactosRelacionados().remove(contactoEncontrado);
//                               Agenda.eliminarPersona((ContactoPersona)contactoEncontrado);
//                                Agenda.contactosMaster.remove(contactoEncontrado); 
//                                id++;
//                              }
//
////                         for (Contacto contacto : contactoSeleccionado.getContactosRelacionados()){
////                             contactoSeleccionado.getContactosRelacionados().remove(contacto);
////                             Agenda.eliminarPersona((ContactoPersona)contacto);
////                             Agenda.contactosMaster.remove(contacto);
////
////                         }
////                         Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
////                         alert1.setTitle("Information Dialog");
////                         alert1.setHeaderText("Resultado de la operación");
////                         alert1.setContentText("Contacto eliminado exitosamente");
////                         alert1.showAndWait();
////
////                         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////
////                         // Cerrar la ventana actual
////                         stage.close();
////
////                         Platform.runLater(() -> {
////                         try {
////
////                         App nuevaInstancia = new App();
////                         nuevaInstancia.start(new Stage());
////                         } catch (Exception e) {
////                         e.printStackTrace();
////                         }
////                          });
//                     }
//
//                    Agenda.eliminarPersona((ContactoPersona)contactoSeleccionado);
//                    Agenda.contactosMaster.remove(contactoSeleccionado);
//
//                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//                     alert1.setTitle("Information Dialog");
//                     alert1.setHeaderText("Resultado de la operación");
//                     alert1.setContentText("Contacto eliminado exitosamente");
//                     alert1.showAndWait();
//
//                     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//                     // Cerrar la ventana actual
//                     stage.close();
//
//                     Platform.runLater(() -> {
//                     try {
//
//                     App nuevaInstancia = new App();
//                     nuevaInstancia.start(new Stage());
//                     } catch (Exception e) {
//                     e.printStackTrace();
//                     }
//                      });
//                 } else {
//                         // El usuario ha hecho clic en "Cancelar" o ha cerrado el Alert
//                         // No realizar ninguna acción
//                   }
//            
//            }else{
//
//           }
//        
//    }
   
    
    
  private void eliminarContactosPrincipalyAsociados(MouseEvent event){
       int idDeContactoAEliminar =Integer.parseInt(contactoId.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(idDeContactoAEliminar);
    
        if(contactoSeleccionado.getIdContactoPadre().equals("Label") && contactoSeleccionado.getIdcontactoEnListaDePadre().equals("Label")){
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmar Eliminación");
            alert.setHeaderText("¿Está seguro que desea eliminar este contacto?");
            alert.setContentText("Esta acción no se puede deshacer.");
            ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
            Optional<ButtonType> resultado = alert.showAndWait();
                if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {
                        if(contactoSeleccionado.getContactosRelacionados().size()>=1){
                            
                             Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                      alert1.setTitle("Contacto con contactos Asociados");
                                      alert1.setHeaderText("Este contacto tiene " +contactoSeleccionado.getContactosRelacionados().size()+" contactos asociados" );
                                      alert1.setContentText("Elimine los contactos asociados para eliminar este" );
                                      alert1.showAndWait();
                            
//                               int id = 0;
//                                    //for (Contacto contacto : contactoSeleccionado.getContactosRelacionados()){
//                                       while (id < contactoSeleccionado.getContactosRelacionados().size()) {
//                                          Contacto contactoEncontrado = buscarContactoPorId(id);
//                                          contactoSeleccionado.getContactosRelacionados().remove(contactoEncontrado);
//                                           Agenda.eliminarPersona((ContactoPersona)contactoEncontrado);
//                                           Agenda.contactosMaster.remove(contactoEncontrado); 
//                                           id++;
//                                         }
                                        //contactoSeleccionado.getContactosRelacionados().remove(contacto);
                                       // Agenda.eliminarPersona((ContactoPersona)contacto);
                                       // Agenda.contactosMaster.remove(contacto);                      
                                    //}

                           }else {
                                    
                                     Agenda.eliminarPersona((ContactoPersona)contactoSeleccionado);
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
                            

                             }
                        
                }else{
                    
                    
                }
                       

        }else if(!contactoSeleccionado.getIdContactoPadre().equals("Label") && !contactoSeleccionado.getIdcontactoEnListaDePadre().equals("Label")&& !idContactoPadre.getText().equals("Label")&& !IdContactoAenLaListaDeCP.getText().equals("Label")){
               
                    int idContactoPadre = Integer.parseInt(contactoSeleccionado.getIdContactoPadre());
                    int indiceEnLaListaPadre = Integer.parseInt(contactoSeleccionado.getIdcontactoEnListaDePadre());

                    Contacto contactoPadre = buscarContactoPorId(idContactoPadre);
                     Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Confirmar Eliminación");
                    alert.setHeaderText("¿Está seguro que desea eliminar este contacto?");
                    alert.setContentText("Esta acción no se puede deshacer.");
                    ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
                    ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
                    Optional<ButtonType> resultado = alert.showAndWait();
                        if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {

                              if(contactoSeleccionado.getContactosRelacionados().size()>=1){
                                  
                                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                      alert1.setTitle("Contacto con contactos Asociados");
                                      alert1.setHeaderText("Este contacto tiene " +contactoSeleccionado.getContactosRelacionados().size()+" contactos asociados" );
                                      alert1.setContentText("Elimine los contactos asociados para eliminar este" );
                                      alert1.showAndWait();
//                                       int id = 0;
//                                            //for (Contacto contacto : contactoSeleccionado.getContactosRelacionados()){
//                                               while (id < contactoSeleccionado.getContactosRelacionados().size()) {
//                                                  Contacto contactoEncontrado = buscarContactoPorId(id);
//                                                  contactoSeleccionado.getContactosRelacionados().remove(contactoEncontrado);
//                                                  Agenda.eliminarPersona((ContactoPersona)contactoEncontrado);
//                                                   Agenda.contactosMaster.remove(contactoEncontrado); 
//                                                   id++;
//                                                 }
                                                //contactoSeleccionado.getContactosRelacionados().remove(contacto);
                                               // Agenda.eliminarPersona((ContactoPersona)contacto);
                                               // Agenda.contactosMaster.remove(contacto);                      
                                            //}

                                   }else{    
                                             
                                             contactoSeleccionado.setIdContactoPadre("Label");
                                             contactoSeleccionado.setIdcontactoEnListaDePadre("Label");
                                             contactoPadre.getContactosRelacionados().remove(contactoSeleccionado);
                                             
                                             
                                             //eliminarContactosPrincipalyAsociados(event);
        //                                     Agenda.eliminarPersona((ContactoPersona)contactoSeleccionado);
        //                                     Agenda.contactosMaster.remove(contactoSeleccionado);

                                              Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                              alert1.setTitle("Information Dialog");
                                              alert1.setHeaderText("Resultado de la operación");
                                              alert1.setContentText("Contacto eliminado exitosamente");
                                              alert1.showAndWait();
                                              
                                              
                                                    int idP = idContactoPadre;
        
                                                    Contacto cp = buscarContactoPorId(idP);
                                                     try {
                                                        // Cargar el archivo FXML de la vista de contacto para personas
                                                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaInfoContactosAsociados.fxml"));
                                                        Parent root = loader.load();

                                                        // Configurar el controlador de la vista de contacto para personas
                                                        ListaInfoContactosAsociadosController controller = loader.getController();
                                                        controller.configurarContactosAsociados(cp); // Método para pasar los datos del contacto

                                                        Scene scene = new Scene(root,900,700);
                                                        Stage stage = new Stage();
                                                        stage.setScene(scene);
                                                        stage.setResizable(false);
                                                        stage.setTitle("Vista de contactos asociados de contacto: "+cp.getNombre());
                                                        stage.show();
                                                        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                                      // Cerrar la ventana actual
                                                      stage1.close();

                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                              
                                              

                                             /* Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                              // Cerrar la ventana actual
                                              stage.close();

                                              Platform.runLater(() -> {
                                              try {

                                              App nuevaInstancia = new App();
                                              nuevaInstancia.start(new Stage());
                                              } catch (Exception e) {
                                              e.printStackTrace();
                                              }
                                               });*/


                                   }




                        }else{


                          }






        }else if(!contactoSeleccionado.getIdContactoPadre().equals("Label") && !contactoSeleccionado.getIdcontactoEnListaDePadre().equals("Label")&& idContactoPadre.getText().equals("Label")&& IdContactoAenLaListaDeCP.getText().equals("Label")){
                    int idContactoPadre = Integer.parseInt(contactoSeleccionado.getIdContactoPadre());
                    int indiceEnLaListaPadre = Integer.parseInt(contactoSeleccionado.getIdcontactoEnListaDePadre());

                    Contacto contactoPadre = buscarContactoPorId(idContactoPadre);
                     Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Confirmar Eliminación");
                    alert.setHeaderText("¿Está seguro que desea eliminar este contacto?");
                    alert.setContentText("Esta acción no se puede deshacer.");
                    ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
                    ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
                    Optional<ButtonType> resultado = alert.showAndWait();
                        if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {

                              if(contactoSeleccionado.getContactosRelacionados().size()>=1){
                                  
                                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                      alert1.setTitle("Contacto con contactos Asociados");
                                      alert1.setHeaderText("Este contacto tiene " +contactoSeleccionado.getContactosRelacionados().size()+" contactos asociados" );
                                      alert1.setContentText("Elimine los contactos asociados para eliminar este" );
                                      alert1.showAndWait();
//                                       int id = 0;
//                                            //for (Contacto contacto : contactoSeleccionado.getContactosRelacionados()){
//                                               while (id < contactoSeleccionado.getContactosRelacionados().size()) {
//                                                  Contacto contactoEncontrado = buscarContactoPorId(id);
//                                                  contactoSeleccionado.getContactosRelacionados().remove(contactoEncontrado);
//                                                  Agenda.eliminarPersona((ContactoPersona)contactoEncontrado);
//                                                   Agenda.contactosMaster.remove(contactoEncontrado); 
//                                                   id++;
//                                                 }
                                                //contactoSeleccionado.getContactosRelacionados().remove(contacto);
                                               // Agenda.eliminarPersona((ContactoPersona)contacto);
                                               // Agenda.contactosMaster.remove(contacto);                      
                                            //}

                                   }else{    
                                            
                                            contactoPadre.getContactosRelacionados().remove(contactoSeleccionado);
                                             
                                             
                                             //eliminarContactosPrincipalyAsociados(event);
                                            Agenda.eliminarPersona((ContactoPersona)contactoSeleccionado);
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


                                   }




                        }else{


                          }
        
        
        
        
        }else{
        
        }
        
      
    }
    
//    private void eliminarDesdeListaPrincipalUnContactoAsociado(MouseEvent event){
//           int idDeContactoAEliminar =Integer.parseInt(contactoId.getText());
//        
//        Contacto contactoSeleccionado = buscarContactoPorId(idDeContactoAEliminar);
//    
//        if(contactoSeleccionado.getIdContactoPadre().equals("Label") && contactoSeleccionado.getIdcontactoEnListaDePadre().equals("Label")){
//                        if(contactoSeleccionado.getContactosRelacionados().size()>=1){
//                            
//                             Alert alert1 = new Alert(Alert.AlertType.ERROR);
//                                      alert1.setTitle("Contacto con contactos Asociados");
//                                      alert1.setHeaderText("Este contacto tiene " +contactoSeleccionado.getContactosRelacionados().size()+" contactos asociados" );
//                                      alert1.setContentText("Elimine los contactos asociados para eliminar este" );
//                                      alert1.showAndWait();
//                            
//                               int id = 0;
//                                    //for (Contacto contacto : contactoSeleccionado.getContactosRelacionados()){
//                                       while (id < contactoSeleccionado.getContactosRelacionados().size()) {
//                                          Contacto contactoEncontrado = buscarContactoPorId(id);
//                                          contactoSeleccionado.getContactosRelacionados().remove(contactoEncontrado);
//                                           Agenda.eliminarPersona((ContactoPersona)contactoEncontrado);
//                                           Agenda.contactosMaster.remove(contactoEncontrado); 
//                                           id++;
//                                         }
//                                        //contactoSeleccionado.getContactosRelacionados().remove(contacto);
//                                       // Agenda.eliminarPersona((ContactoPersona)contacto);
//                                       // Agenda.contactosMaster.remove(contacto);                      
//                                    //}
//
//                           }else {
//                                    
//                                     Agenda.eliminarPersona((ContactoPersona)contactoSeleccionado);
//                                     Agenda.contactosMaster.remove(contactoSeleccionado);
//
//                                      Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//                                      alert1.setTitle("Information Dialog");
//                                      alert1.setHeaderText("Resultado de la operación");
//                                      alert1.setContentText("Contacto eliminado exitosamente");
//                                      alert1.showAndWait();
//
//                                      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//                                      // Cerrar la ventana actual
//                                      stage.close();
//
//                                      Platform.runLater(() -> {
//                                      try {
//
//                                      App nuevaInstancia = new App();
//                                      nuevaInstancia.start(new Stage());
//                                      } catch (Exception e) {
//                                      e.printStackTrace();
//                                      }
//                                       });
//                            
//
//                             }
//                        
//                
//        }
//          
//    
//    
//    }
//    
    
    
    
    @FXML
    private void verCorreos(MouseEvent event) {
        
        
        /*  private Label IdContactoAenLaListaDeCP;
            @FXML
            private Label idContactoPadre;*/
        
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
    private void mostrarFotosContacto(MouseEvent event) {
        
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("verFotosContactos.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VerFotosContactosController controller = loader.getController(); 
            controller.mostrarImg((Contacto) contacto); // Método para pasar los datos del contacto
             System.out.println("contacto id: "+contacto.getId());
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
    
    
      
    private void abrirVistaContactoPersonaAsociada(Contacto contacto, int idPadre, int indiceListaDePadre) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInfoContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaInfoContactoController controller = loader.getController();
            controller.configurarAsociado((ContactoPersona) contacto, idPadre, indiceListaDePadre); // Método para pasar los datos del contacto
            
            
            
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

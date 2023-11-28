/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Estructuras.List;
import Fields.Foto;
import Modelo.Agenda;
import Modelo.Contacto;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class FotosContactosController implements Initializable {
    private static final long serialVersionUID=1L;
    @FXML
    private ImageView regresar;
    @FXML
    private ImageView izquierda;
    @FXML
    private Button btSeleccionar;
    @FXML
    private ImageView derecha;
    @FXML
    private ImageView agregarFoto;
    @FXML
    private Label contacoId;
    private Contacto seleccionado;
    private List<Foto>galeria;
    private ImageView imagenesContacto;
    @FXML
    private VBox VboxFotos;
    
    private static final int ELEMENTOS_POR_PAGINA=1;
    private  int paginaActual=1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         //mostrarImg(galeria.getStart());

    } 
    
    /*private void mostrarImg(Contacto c) {
        VboxFotos.getChildren().clear();
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Foto.fxml"));
            Node  imageView = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            FotoController controllerFoto = loader.getController();
            controllerFoto.configurar(c);

            // Agregar el HBox al VBox
            VboxFotos.getChildren().add(imageView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    /*private void mostrarImg(Foto foto) {
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Foto.fxml"));
            Node  imageView = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            FotoController controllerFoto = loader.getController();
            controllerFoto.configurar(foto);

            // Agregar el HBox al VBox
            VboxFotos.getChildren().add(controllerFoto.imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public void configurar(Contacto contacto){
        contacoId.setText(String.valueOf(contacto.getId()));
        seleccionado=contacto;
        galeria=seleccionado.getFotos();
        System.out.println(galeria.getStart().getArchivo());
        System.out.println(seleccionado.getId());
        imagenesContacto.setImage(new Image(galeria.getStart().getArchivo()));
        VboxFotos.getChildren().add(imagenesContacto);
        //mostrarImg(galeria.getStart());
    }
    

    @FXML
    private void regresarPantalla(MouseEvent event) {
    }

    

    @FXML
    private void seleccionarFoto(ActionEvent event) {
    }

   

    @FXML
    private void agregarNuevaFoto(MouseEvent event) {
        //cargarContacto();
        try {
            // Obtener el ID del contacto
            String idUsuario = contacoId.getText();

            // Crear la ruta de la carpeta para el usuario
            String carpetaUsuario = "files/images/" + idUsuario;
            Path rutaCarpetaUsuario = Path.of(carpetaUsuario);

            // Crear la carpeta si no existe
            if (Files.notExists(rutaCarpetaUsuario)) {
                Files.createDirectories(rutaCarpetaUsuario);
            }

            // Mostrar el FileChooser para seleccionar la foto
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar foto");
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("Archivos de imagen (*.jpg, *.png, *.avif) ", "*.jpg", "*.png","*avif");
            fileChooser.getExtensionFilters().add(extFilter);

            File archivoSeleccionado = fileChooser.showOpenDialog(new Stage());

            // Verificar si se seleccionó un archivo
            if (archivoSeleccionado != null) {
                // Obtener el nombre del archivo y la extensión
                String nombreArchivo = archivoSeleccionado.getName();
                String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();

                // Verificar la extensión
                if (extension.equals("jpg") || extension.equals("png") || extension.equals("avif")) {
                    // Crear la ruta de destino para la foto
                    String nombreFoto = "foto_" + System.currentTimeMillis() + "." + extension;
                    Path rutaDestino = Path.of(carpetaUsuario, nombreFoto);

                    // Copiar la foto al destino
                    Files.copy(archivoSeleccionado.toPath(), rutaDestino, StandardCopyOption.REPLACE_EXISTING);

                    // Obtener la ruta relativa de la foto
                    String rutaRelativa = carpetaUsuario + "/" + nombreFoto;

                    // Crear un objeto Foto y añadirlo a la lista de fotos del contacto
                    Foto foto = new Foto( rutaRelativa);
                    seleccionado.añadirFoto(foto);
                    for(Foto f: seleccionado.getFotos()){
                        System.out.println(f);
                    }

                    // Actualizar la interfaz de usuario, si es necesario
                    // ...

                    System.out.println("Foto añadida con éxito. Ruta: " + rutaRelativa);
                } else {
                    System.out.println("Error: Selecciona un archivo de tipo .jpg o .png");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
      
    }
    
    
    
    private void mostrarElementos() {
        
        //VboxFotos.getChildren().add(imageView);

//        int id = Integer.parseInt(contacoId.getText());
//        
//        Contacto contactoSeleccionado = buscarContactoPorId(id);
//        
//        VboxFotos.getChildren().clear();
//        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
//        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, contactoSeleccionado.getFotos().size());
//
//        for (int i = inicio; i < fin; i++) {
//            mostrarImg( contactoSeleccionado);
//        }

        //lbnumpag.setText( String.valueOf(paginaActual));
    }  
    
    private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }
    
    
     @FXML
  private void siguiente(MouseEvent event) {
//          if(paginaActual<galeria.size()){
//            VboxFotos.getChildren().clear();
//            mostrarImg(galeria.get(paginaActual));
//            paginaActual++;
//            
//          }
//          if(paginaActual==galeria.size()){
//            VboxFotos.getChildren().clear();  
//            mostrarImg(galeria.getStart());
//            paginaActual=1;
//          }
      
//        int id = Integer.parseInt(contacoId.getText());
//        
//        Contacto contactoSeleccionado = buscarContactoPorId(id);
//        
//        int totalPaginas = (int) Math.ceil((double) contactoSeleccionado.getFotos().size() / ELEMENTOS_POR_PAGINA);
//
//        if (paginaActual < totalPaginas) {
//            paginaActual++;
//        } else {
//            // Si llegamos al final, regresamos a la primera página
//            paginaActual = 1;
//        }
//
//        mostrarElementos();
       
    }
    
    
   @FXML
    private void anterior(MouseEvent event) {
        //int retroceso=  galeria.size()-1;
//        if(paginaActual==1){
//            VboxFotos.getChildren().clear();
//            paginaActual=galeria.size()-1;
//            mostrarImg(galeria.get(paginaActual));
//        }
//        if(paginaActual<=galeria.size()-1){
//            VboxFotos.getChildren().clear();
//            paginaActual--;
//            mostrarImg(galeria.get(paginaActual));
            
        //}
            
    }
        
//        int id = Integer.parseInt(contacoId.getText());
//        
//        Contacto contactoSeleccionado = buscarContactoPorId(id);
//        
//         int totalPaginas = (int) Math.ceil((double) contactoSeleccionado.getFotos().size() / ELEMENTOS_POR_PAGINA);
//
//        if (paginaActual > 1) {
//            paginaActual--;
//        } else {
//            // Si estamos en la primera página, vamos al final
//            paginaActual = totalPaginas;
//        }
//
//        mostrarElementos();
    
    
    

        
    
}

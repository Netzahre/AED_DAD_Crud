package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class controladorMenuSuperior {
    private static Stage stage;

    public static void setStage(Stage Newstage) {
        stage = Newstage;
    }

    @FXML
    private void verAulas() {
        cargarVista("VerAulas.fxml");
    }

    @FXML
    private void crearNuevaAula() {
        abrirModal("CrearNuevaAula.fxml");
    }

    @FXML
    private void modificarAula() {
        abrirModal("ModificarAula.fxml");
    }

    // Método para navegar a la vista de "Productos"
    @FXML
    private void verProductos() {
        cargarVista("VerProductos.fxml");
    }

    @FXML
    private void crearNuevoProducto() {
        cargarVista("CrearNuevoProducto.fxml");
    }

    @FXML
    private void verMarcajes() {
        cargarVista("VerMarcajes.fxml");
    }

    @FXML
    private void crearNuevoMarcaje() {
        cargarVista("crearMarcaje.fxml");
    }

    @FXML
    private void verCategoria() {
        cargarVista("VerCategoria.fxml");
    }

    @FXML
    private void crearNuevaCategoria() {
        cargarVista("CrearNuevaCategoria.fxml");
    }

    private void cargarVista(String archivoFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/vistas/" + archivoFXML));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/org/example/css/diurno.css").toExternalForm());
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirModal(String archivoFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/vistas/" + archivoFXML));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org/example/css/diurno.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ponerModoClaro() {
        Scene scene = stage.getScene();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/org/example/css/diurno.css").toExternalForm());
    }

    @FXML
    private void ponerModoOscuro() {
        Scene scene = stage.getScene();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/org/example/css/nocturno.css").toExternalForm());
    }
}
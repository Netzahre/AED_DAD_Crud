package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class controladorMenuSuperior {
    private AnchorPane contentArea;

    public void setContentArea(AnchorPane contentArea) {
        this.contentArea = contentArea;
    }
    // Método para navegar a la vista de "Aulas"
    @FXML
    private void verAulas() {
        cargarVista("VerAulas.fxml");
    }

    @FXML
    private void crearNuevaAula() {
        cargarVista("CrearNuevaAula.fxml");
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

    // Método para navegar a la vista de "Marcajes"
    @FXML
    private void verMarcajes() {
        cargarVista("VerMarcajes.fxml");
    }

    @FXML
    private void crearNuevoMarcaje() {
        cargarVista("CrearNuevoMarcaje.fxml");
    }

    // Método para navegar a la vista de "Categoría"
    @FXML
    private void verCategoria() {
        cargarVista("VerCategoria.fxml");
    }

    @FXML
    private void crearNuevaCategoria() {
        cargarVista("CrearNuevaCategoria.fxml");
    }

    // Método para cargar una vista FXML en el contenedor
    private void cargarVista(String archivoFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/vistas/" + archivoFXML));
            AnchorPane nuevaVista = loader.load();
            contentArea.getChildren().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.Aula;

public class controladorCrearMarcaje {
    private static Stage stage;
    private static Aula aula;

    @FXML
    private ComboBox<String> cbAula;
    @FXML
    private ComboBox<String> cbProducto;

    public static void setStage(Stage Newstage) {
        stage = Newstage;
    }

    //Initialize con combobox
    @FXML
    private void initialize() {
        //Llenar combobox de aulas
        cbAula.getItems().add("Aula 1");
        cbAula.getItems().add("Aula 2");
        cbAula.getItems().add("Aula 3");
        cbAula.getItems().add("Aula 4");
        cbAula.getItems().add("Aula 5");
        //Llenar combobox de productos
        cbProducto.getItems().add("Producto 1");
        cbProducto.getItems().add("Producto 2");
        cbProducto.getItems().add("Producto 3");
        cbProducto.getItems().add("Producto 4");
        cbProducto.getItems().add("Producto 5");
        //Seleccionar el primer elemento
        cbAula.getSelectionModel().selectFirst();
        cbProducto.getSelectionModel().selectFirst();
    }

}

package controlador;

import javafx.stage.Stage;
import modelo.Aula;

public class controladorFormularioAula {
    private static Stage stage;
    private Aula aula;

    public static void setStage(Stage Newstage) {
        stage = Newstage;
    }

    public void recibirAula(Aula aula) {
        this.aula = aula;
    }

    private void esCrearAula() {
        if (aula == null) {
            stage.setTitle("Crear Aula");
        } else {
            stage.setTitle("Editar Aula");
        }
    }

    private void cargarDatos() {
        if (aula != null) {
            // Cargar los datos del aula en los campos correspondientes
        }
    }

    private void guardarDatos() {
        if (aula == null) {
            // Crear un nuevo aula con los datos de los campos
        } else {
            // Actualizar el aula con los datos de los campos
        }
    }

}

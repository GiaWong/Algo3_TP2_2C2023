package edu.fiuba.algo3;
import edu.fiuba.algo3.Vista.PantallaDeInicio;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Gladiadores en fuga");
        PantallaDeInicio pantallaDeInicio = new PantallaDeInicio(stage);


    }



    public static void main(String[] args) {
        launch();
    }

}
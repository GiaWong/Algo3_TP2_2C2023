package edu.fiuba.algo3.Vista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class VentanaMensajeParaGanador {

    private Stage ventana;
    private Label label;

    public VentanaMensajeParaGanador(String mensaje, Stage stageAnterior,Stage stageMapa) {
        ventana = new Stage();
        StackPane panel = new StackPane();

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Felicitaciones!!");
        ventana.setMinWidth(500);
        ventana.setMinHeight(500);

        label = new Label(mensaje);
        label.setFont(new Font(14));
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setTextFill(Color.BLACK);
        label.setPadding(new Insets(5));

        VBox layout = new VBox();
        layout.getChildren().add(label);
        layout.setAlignment(Pos.CENTER);

        panel.getChildren().add(layout);
        panel.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene escena = new Scene(panel);
        escena.setFill(Color.TRANSPARENT);
        ventana.setScene(escena);
        // Agregar el controlador de eventos para el cierre de la ventana
        ventana.setOnHiding(event -> {
            stageMapa.close();
            new PantallaDeInicio(stageAnterior);
        });

    }

    public void mostrar() {
        ventana.showAndWait();
    }
}


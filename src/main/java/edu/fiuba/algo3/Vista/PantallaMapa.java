package edu.fiuba.algo3.Vista;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoReal;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.util.ArrayList;


public class PantallaMapa extends BorderPane {
    private  Stage stage;
    private ArrayList<Gladiador> gladiadores;
    Canvas canvas;
    static Label labelPosicion;
    static Label labelPremio;
    static Label labelObstaculo;
    private Label labelEspacio;
    private Tablero tablero;


    public PantallaMapa(Stage stage, ArrayList<Gladiador> gladiadores) {
        this.stage = stage;
        this.gladiadores = gladiadores;
        labelPosicion = new Label("");
        labelPremio = new Label("");
        labelObstaculo = new Label("Bienvenidos a 'Gladiadores en fuga'.");
        labelEspacio = new Label("");
    }

    public void mostrarMapa() {

        labelObstaculo.setStyle("-fx-text-fill: black;-fx-background-color: white; -fx-font-size: 20;-fx-font-weight: bold;");
        canvas = new Canvas(100, 100);
        this.tablero = this.crearTablero(gladiadores);

        Stage stageMapa = new Stage();
        stageMapa.setTitle("Gladiadores en fuga");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        StackPane stackPane = new StackPane();
        Image imagenDeFondo = new Image("file:src/main/java/edu/fiuba/algo3/Vista/imagenes/Gladiadores_fondo.jpg");
        ImageView imageView = new ImageView(imagenDeFondo);
        imageView.setFitWidth(bounds.getWidth());
        imageView.setFitHeight(bounds.getHeight());

        GridPane gridMapa = new GridPane();
        gridMapa.setPadding(new Insets(10));
        gridMapa.setHgap(5);
        gridMapa.setVgap(5);
        int ancho = 10;
        int largo = 18;
        int tamanoCasilla = 50;

        VBox vboxEnergia = new VBox();
        this.mostrarEnergia(vboxEnergia);

        VBox vBoxEspacio = new VBox();
        Label labelEspacioH = new Label("       ");
        vBoxEspacio.getChildren().addAll(labelEspacioH);
        HBox hboxPrincipal = new HBox(gridMapa, vBoxEspacio, vboxEnergia);
        hboxPrincipal.setAlignment(Pos.CENTER);

        for (int i = ancho; i >= 1; i--) {
            for (int j = 1; j <= largo; j++) {
                Label label = new Label();
                label.setMinSize(tamanoCasilla, tamanoCasilla);
                label.setStyle("-fx-border-color: black;");
                if (j == 1 && i == 4 || j == 2 && i == 4 || j == 2 && i == 5 || j == 2 && i == 6 || j == 2 && i == 7 || j == 2 && i == 8 || j == 2 && i == 9 || j == 2 && i == 10 || j == 3 && i == 10 || j == 4 && i == 10 || j == 5 && i == 10 || j == 6 && i == 10 || j == 7 && i == 10 || j == 8 && i == 10 || j == 9 && i == 10 || j == 10 && i == 10 || j == 11 && i == 10 || j == 12 && i == 10 || j == 12 && i == 9 || j == 12 && i == 8 || j == 12 && i == 7 || j == 12 && i == 6 || j == 12 && i == 5 || j == 12 && i == 4 || j == 12 && i == 3 || j == 12 && i == 2 || j == 13 && i == 2 || j == 14 && i == 2 || j == 15 && i == 2 || j == 16 && i == 2 || j == 17 && i == 2 || j == 17 && i == 3 || j == 17 && i == 4 || j == 17 && i == 5 || j == 17 && i == 6 || j == 17 && i == 7 || j == 17 && i == 8 || j == 17 && i == 9 || j == 17 && i == 10) {
                    colorear(label, Color.LIGHTGRAY);
                } else {
                    colorear(label, Color.LIGHTGREEN);
                }
                gridMapa.add(label, j - 1, ancho - i);
            }
        }

        Jugadores jugadores = new Jugadores(gladiadores, gridMapa);
        jugadores.actualizar();

        Button btnAvanzar = new Button("Tirar dado");
        btnAvanzar.setOnAction(e -> {

            this.eliminarContenidoLabels();
            tablero.avanzar();
            jugadores.actualizar();
            Casilla casilla = tablero.obtenerCasillaALaQueSeDesplazo();
            this.actualizarLabels(casilla);
            this.mostrarEnergia(vboxEnergia);

            if(tablero.gladiadorGanaPartida()){
                stageMapa.close();
                VentanaMensajeParaGanador ventanaGanador = new VentanaMensajeParaGanador(tablero.obtenerGladiadorQueJugo().obtenerNombre()+" ganó la partida.", stage, stageMapa);
                ventanaGanador.mostrar();
            }
        });

        vbox.getChildren().addAll(labelPosicion, labelObstaculo, labelPremio,labelEspacio, hboxPrincipal, btnAvanzar );
        vbox.setAlignment(Pos.CENTER);

        gridMapa.add(btnAvanzar, 0, ancho + 1, largo, 1);
        gridMapa.setAlignment(Pos.CENTER);

        double ventanaAncho = largo * tamanoCasilla + 15;
        double ventanaAlto = ancho * tamanoCasilla + 15;

        stackPane.getChildren().add(imageView);
        stackPane.getChildren().add(vbox);

        Scene sceneMapa = new Scene(stackPane, ventanaAncho, ventanaAlto);

        stageMapa.setScene(sceneMapa);
        stageMapa.setMaximized(true);

        stageMapa.show();
        stage.close();
    }



    public Tablero crearTablero(ArrayList<Gladiador> gladiadores){
        Mapa mapa = new Mapa();
        mapa.mapaReal();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Dado dado = new DadoReal();
        Tablero tablero = new Tablero(gladiadores.size(),new Turno(30),unMapa,mapa.obtenereCamino(),dado);
        for (Gladiador gladiador : gladiadores) {
            tablero.agregarJugador(gladiador);
        }
        return tablero;
    }

    private void colorear(Region region, Color color) {
        region.setBackground(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundFill(color, null, null)));
    }

    public void mostrarEnergia(VBox vBox){
        vBox.getChildren().clear();
        Label labelEnergia = new Label("ENERGÍA");
        labelEnergia.setStyle("-fx-text-fill: black;-fx-background-color: white; -fx-font-size: 20;-fx-font-weight: bold;-fx-pref-width: 110");
        vBox.getChildren().add(labelEnergia);
        for (Gladiador g : gladiadores){
            Label label = new Label(g.obtenerNombre()+": "+ g.obtenerEnergia());
            label.setStyle("-fx-text-fill: black; -fx-background-color: white; -fx-font-size: 10; -fx-font-weight: bold; -fx-pref-width: 110;");
            vBox.getChildren().add(label);
        }
    }

    public void actualizarLabels(Casilla casilla) {
        Gladiador ungladiador = tablero.obtenerGladiadorQueJugo();
        if (tablero.habilitadoAJugar()) {
            labelPosicion.setText("Salio " + tablero.obtenerCantidadAMoverse() + ", el jugador " + ungladiador.obtenerNombre() + " avanza a la casilla: (" + ungladiador.obtenerPosicionEnX() + "," + casilla.obtenerposicionEny() + ").");
            labelPosicion.setStyle("-fx-text-fill: black;-fx-background-color: white; -fx-font-size: 15;-fx-font-weight: bold;");
            labelPremio.setText("Premio: " + casilla.obtenerSegundaOcupacion(ungladiador));
            labelPremio.setStyle("-fx-text-fill: green;-fx-background-color: white; -fx-font-size: 15;-fx-font-weight: bold;");
            labelObstaculo.setText("Obstaculo: " + casilla.obtenerPrimeraOcupacion());
            labelObstaculo.setStyle("-fx-text-fill: red;-fx-background-color: white; -fx-font-size: 15;-fx-font-weight: bold;");
        }
        else{
            labelObstaculo.setText("El jugador "+ungladiador.obtenerNombre()+ " perdió su turno.");
            labelObstaculo.setStyle("-fx-text-fill: red;-fx-background-color: white; -fx-font-size: 15;-fx-font-weight: bold;");
            labelPremio.setText("");
            labelPosicion.setText("");
        }
    }

    public void eliminarContenidoLabels(){
        labelPosicion.setText("");
        labelPremio.setText("");
        labelObstaculo.setText("");
        labelEspacio.setText("");
    }

}

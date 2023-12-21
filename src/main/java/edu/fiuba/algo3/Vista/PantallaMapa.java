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
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;


public class PantallaMapa extends BorderPane implements Observable {

    private  Stage stage;
    private ArrayList<Gladiador> gladiadores;
    Canvas canvas;
    static Label labelPosicion;
    static Label labelPremio;
    static Label labelObstaculo;



    public PantallaMapa(Stage stage, ArrayList<Gladiador> gladiadores) {
        this.stage = stage;
        this.gladiadores = gladiadores;
        labelPosicion = new Label("Bienvenidos a 'Gladiadores en fuga'.");
        labelPremio = new Label("");
        labelObstaculo = new Label("");
    }

    public void mostrarMapa() {

        canvas = new Canvas(100, 100);
        Tablero tablero = this.crearTablero(gladiadores);
        Stage stageMapa = new Stage();
        stageMapa.setTitle("Gladiadores en fuga");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        GridPane gridMapa = new GridPane();
        gridMapa.setPadding(new Insets(10));
        gridMapa.setHgap(5);
        gridMapa.setVgap(5);
        int ancho = 10;
        int largo = 18;
        double tamanoCasilla = 40.0;


        VBox vboxEnergia = new VBox();
        Label labelEnergia = new Label("Energia de los gladiadores:");
        vboxEnergia.getChildren().add(labelEnergia);
        for (Gladiador g : gladiadores) {
            Label label = new Label(g.obtenerNombre() + ":" + g.obtenerEnergia());
            vboxEnergia.getChildren().add(label);
        }
        VBox vBoxEspacio = new VBox();
        Label labelEspacio = new Label("       ");
        vBoxEspacio.getChildren().addAll(labelEspacio);
        HBox hboxPrincipal = new HBox(gridMapa, vBoxEspacio, vboxEnergia);
        hboxPrincipal.setAlignment(Pos.CENTER);


        for (int i = ancho; i >= 1; i--) {
            for (int j = 1; j <= largo; j++) {
                Label label = new Label();
                label.setMinSize(tamanoCasilla, tamanoCasilla);
                label.setStyle("-fx-border-color: black;");
                if (j == 1 && i == 4 || j == 2 && i == 4 || j == 2 && i == 5 || j == 2 && i == 6 || j == 2 && i == 7 || j == 2 && i == 8 || j == 2 && i == 9 || j == 2 && i == 10 || j == 3 && i == 10 || j == 4 && i == 10 || j == 5 && i == 10 || j == 6 && i == 10 || j == 7 && i == 10 || j == 8 && i == 10 || j == 9 && i == 10 || j == 10 && i == 10 || j == 11 && i == 10 || j == 12 && i == 10 || j == 12 && i == 9 || j == 12 && i == 8 || j == 12 && i == 7 || j == 12 && i == 6 || j == 12 && i == 5 || j == 12 && i == 4 || j == 12 && i == 3 || j == 12 && i == 2 || j == 13 && i == 2 || j == 14 && i == 2 || j == 15 && i == 2 || j == 16 && i == 2 || j == 17 && i == 2 || j == 17 && i == 3 || j == 17 && i == 4 || j == 17 && i == 5 || j == 17 && i == 6 || j == 17 && i == 7 || j == 17 && i == 8 || j == 17 && i == 9 || j == 17 && i == 10) {
                    setColor(label, Color.LIGHTGRAY);
                } else {
                    setColor(label, Color.LIGHTGREEN);
                }
                gridMapa.add(label, j - 1, ancho - i);
            }
        }

        Jugadores jugadores = new Jugadores(gladiadores, gridMapa);
        jugadores.actualizar();


        Button btnAvanzar = new Button("Tirar dado");
        btnAvanzar.setOnAction(e -> {
            labelPosicion.setText("");
            labelObstaculo.setText("");
            labelPremio.setText("");
            tablero.avanzar();
            jugadores.actualizar();
            this.actualizarEnergia(vboxEnergia);

            if(tablero.gladiadorGanaPartida()){

                VentanaMensajeParaGanador ventanaGanador = new VentanaMensajeParaGanador("Ganaste el juego", stage, stageMapa);
                ventanaGanador.mostrar();

            }
        });

        Button btnJugadorAleatorio = new Button("Elegir Jugador Aleatorio");
        btnJugadorAleatorio.setOnAction(e -> {
            btnAvanzar.setVisible(true);
            btnJugadorAleatorio.setVisible(false);
        });

        btnAvanzar.setVisible(false);

        vbox.getChildren().addAll(labelPosicion, labelObstaculo, labelPremio, hboxPrincipal, btnAvanzar , btnJugadorAleatorio);
        vbox.setAlignment(Pos.CENTER);

        gridMapa.add(btnJugadorAleatorio, 0, ancho + 3, largo, 1);
        gridMapa.setAlignment(Pos.CENTER);

        gridMapa.add(btnAvanzar, 0, ancho + 1, largo, 1);
        gridMapa.setAlignment(Pos.CENTER);

        double ventanaAncho = largo * tamanoCasilla + 15;
        double ventanaAlto = ancho * tamanoCasilla + 15;

        Scene sceneMapa = new Scene(vbox, ventanaAncho, ventanaAlto);

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

    private void setColor(Region region, Color color) {
        region.setBackground(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundFill(color, null, null)));
    }

    public static Label obtenerLabelPosicion(){
        return labelPosicion;
    }
    public static Label obtenerLabelPremio(){
        return labelPremio;
    }
    public static Label obtenerLabelObstaculo(){
        return labelObstaculo;
    }

    public void actualizarEnergia(VBox vBox){
        vBox.getChildren().clear();
        Label labelEnergia = new Label("Energia de los gladiadores:");
        vBox.getChildren().add(labelEnergia);
        for (Gladiador g : gladiadores){
            Label label = new Label(g.obtenerNombre()+":"+ g.obtenerEnergia());
            vBox.getChildren().add(label);
        }
    }


    @Override
    public void agregarObservador(Observer o){    }
    @Override
    public void eliminarObservador(Observer o){}

}

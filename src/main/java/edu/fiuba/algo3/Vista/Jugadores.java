package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Modelo.Gladiador;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
import java.util.List;



public class Jugadores implements Observer{
    private ArrayList<Gladiador> gladiadores;
    private GridPane gridMapa;


    public Jugadores(ArrayList<Gladiador> gladiadores, GridPane gridMapa){
        this.gladiadores = gladiadores;
        this.gridMapa = gridMapa;
    }

    @Override
    public void actualizar(){

        this.clear(gridMapa);
        int contador = 1;

        for (Gladiador g : gladiadores){

            if (contador == 1) {

                String imagePath = "file:src/main/java/edu/fiuba/algo3/Vista/imagenes/Gladiador1.png";
                Image gladiadorImage = new Image(imagePath);
                ImageView imageView = new ImageView(gladiadorImage);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);
                GridPane.setRowIndex(imageView, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(imageView, g.obtenerPosicionEnX() - 1);
                imageView.setTranslateX(15);
                imageView.setTranslateY(-11);
                gridMapa.getChildren().add(imageView);
            }
            else if(contador == 2) {
                String imagePath = "file:src/main/java/edu/fiuba/algo3/Vista/imagenes/Gladiador2.png";
                Image gladiadorImage = new Image(imagePath);
                ImageView imageView = new ImageView(gladiadorImage);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);
                GridPane.setRowIndex(imageView, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(imageView, g.obtenerPosicionEnX() - 1);
                imageView.setTranslateX(10);
                imageView.setTranslateY(-11);
                gridMapa.getChildren().add(imageView);
            }
            else if(contador == 3) {
                String imagePath = "file:src/main/java/edu/fiuba/algo3/Vista/imagenes/Gladiador3.png";
                Image gladiadorImage = new Image(imagePath);
                ImageView imageView = new ImageView(gladiadorImage);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);
                GridPane.setRowIndex(imageView, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(imageView, g.obtenerPosicionEnX() - 1);
                imageView.setTranslateX(7);
                imageView.setTranslateY(0);
                gridMapa.getChildren().add(imageView);
            }
            else if(contador == 4) {
                String imagePath = "file:src/main/java/edu/fiuba/algo3/Vista/imagenes/Gladiador4.png";
                Image gladiadorImage = new Image(imagePath);
                ImageView imageView = new ImageView(gladiadorImage);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);
                GridPane.setRowIndex(imageView, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(imageView, g.obtenerPosicionEnX() - 1);
                imageView.setTranslateX(10);
                imageView.setTranslateY(0);
                gridMapa.getChildren().add(imageView);
            }
            else if(contador == 5) {
                String imagePath = "file:src/main/java/edu/fiuba/algo3/Vista/imagenes/Gladiador5.png";
                Image gladiadorImage = new Image(imagePath);
                ImageView imageView = new ImageView(gladiadorImage);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);
                GridPane.setRowIndex(imageView, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(imageView, g.obtenerPosicionEnX() - 1);
                imageView.setTranslateX(7);
                imageView.setTranslateY(5);
                gridMapa.getChildren().add(imageView);
            }
            else if(contador == 6) {
                String imagePath = "file:src/main/java/edu/fiuba/algo3/Vista/imagenes/Gladiador6.png";
                Image gladiadorImage = new Image(imagePath);
                ImageView imageView = new ImageView(gladiadorImage);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);
                GridPane.setRowIndex(imageView, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(imageView, g.obtenerPosicionEnX() - 1);
                imageView.setTranslateX(14);
                imageView.setTranslateY(8);
                gridMapa.getChildren().add(imageView);
            }
            contador++;

        }

    }

    private void clear(GridPane gridMapa) {
        List<Node> nodosAEliminar = new ArrayList<>();

        for (Node nodo : gridMapa.getChildren()) {
            if (nodo instanceof ImageView) {
                nodosAEliminar.add(nodo);
            }
        }
        gridMapa.getChildren().removeAll(nodosAEliminar);
        // Establecer el fondo negro
        gridMapa.setStyle("-fx-background-color: black;");
    }




}


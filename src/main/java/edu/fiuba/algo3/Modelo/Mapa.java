package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.ManejarJson.DeserializadorJSON;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private Casilla[][] mapa;

    public void mapaTest() {
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda();

        Casilla[][] matriz = new Casilla[18][10];

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 10; j++) {
                String tipo = "";
                Casilla casilla = new Casilla(new NadaOcupacion(), new NadaOcupacion(),i,j,tipo);
                matriz[i][j] = casilla;
            }
        }

        this.mapa = matriz;
    }

    //Este es el verdadero mapa de juego! el de arriba es solo para los test
    public void mapaReal(){
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda();
        List <Casilla>  listaDeCasillasJSON =  deserializadorJSON.obtenerListaCasillas();


        Casilla[][] matriz = new Casilla[18][10] ;

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 10; j++) {
                String tipo = "";
                Casilla casilla = new Casilla(new NadaOcupacion(), new NadaOcupacion(),i,j,tipo);
                matriz[i][j] = casilla;
            }
        }
        for (Casilla casilla : listaDeCasillasJSON) {
            matriz[casilla.obtenerposicionEnX()][casilla.obtenerposicionEny()] = casilla;
        }

        this.mapa   = matriz;
    }
    public Casilla[][] obtenerMapa(){
        return mapa;
    }

}

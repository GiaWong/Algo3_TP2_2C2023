package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.ManejarJson.DeserializadorJSON;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private Casilla[][] mapa;
    private List<Casilla> camino;

    public void mapaTest() {
        //Por ahora para los test creo un mapa normal
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";

        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda(rutaDelArchivo);

        Casilla[][] matriz = new Casilla[18][10];

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 10; j++) {
                Casilla casilla = new Casilla(new NadaOcupacion(), new NadaOcupacion(),i,j);
                matriz[i][j] = casilla;
            }
        }


        this.mapa = matriz;
    }

    //Este es el verdadero mapa de juego! el de arriba es solo para los test
    public void mapaReal(){
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";

        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda(rutaDelArchivo);
        List <Casilla>  listaDeCasillasJSON =  deserializadorJSON.obtenerListaCasillas();


        Casilla[][] matriz = new Casilla[18][10] ;

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 10; j++) {
                Casilla casilla = new Casilla(new NadaOcupacion(), new NadaOcupacion(),i,j);
                matriz[i][j] = casilla;
            }
        }
        for (Casilla casilla : listaDeCasillasJSON) {
            matriz[casilla.obtenerposicionEnX()][casilla.obtenerposicionEny()] = casilla;
        }

        this.mapa   = matriz;
        this.camino = listaDeCasillasJSON;
    }
    public Casilla[][] obtenerMapa(){
        return mapa;
    }
    public List<Casilla> obtenerCamino(){
        return camino;
    }
}

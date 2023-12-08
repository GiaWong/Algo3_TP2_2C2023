package edu.fiuba.algo3;
import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Controlador.ManejarJson.DeserializadorJSON;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CasosDeUsosEntregaDos {

    /**
     * Verifico que la deserializacion "ancho" y "largo" del mapa json
     * */
    @Test
    public void Test013SeVerificaElFormatoValidoDelJsonDelMapa() {

        // Ruta al archivo JSON
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();

        int valorEsperadoAncho = 10;
        int valorEsperadoLargo = 18;

        assertEquals(valorEsperadoAncho,deserializadorJSON.extraerValorAnchoDelMapa());
        assertEquals(valorEsperadoLargo,deserializadorJSON.extraerValorLargoDelMapa());

    }

    /**
     * Verifico la deserializacion "obstaculo" y "premio" de las celdas json
     *
     * Supuesto: si una celda tiene mal el contenido de la ocupacion entonces
     * no se guardará en la lista de casillas que tiene adentro la clase DeserializadorJson()
     * Recordar que ocupaciones puede ser  premio y/o obstaculos
     *
     * */
    @Test
    public void Test014SeVerificaElFormatoValidoDelJsonDeObstaculosYPremios() {
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda();
        int valorEsperado = 39;

        assertEquals(valorEsperado,deserializadorJSON.cantidadCeldasDeserealizadas());

    }



    @Test
    public void Test015SeVerificaLaLecturayConversionDeObstaculosDelJsonAlModelo() {
        /**
         *
         * Ya estan contempladas
         * */
    }
    @Test
    public void test016SeVerificaLaLecturayConversionDePremiosDelJsonAlModelo() {
        /**
         *
         *Ya estan contempladas
         * */
    }


    @Test
    public void Test017VerificarQueElJuegoSeCreaAcordeALJson() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda();

        List<Casilla> listaCasillas = deserializadorJSON.obtenerListaCasillas();

        Tablero tablero = new Tablero(1,new Turno(30),unMapa, dado);

        for (Casilla casillaActual : listaCasillas){

            tablero.agregarCasillaAlMapa(casillaActual);
        }


        /**
         *  otra forma para evitar usar for es que directamente el tabblero
         *  tenga un metodo para setear la lista de casillas ya cargadas por la clase Deserializadorjson()
         *  PENSARLOOO...
         *
         *
         * Para poder usar los contenidos del json con el modelo siempre se debe llamar a la linea 82,83,84.
         */


        //y empezar a codear


    }


}

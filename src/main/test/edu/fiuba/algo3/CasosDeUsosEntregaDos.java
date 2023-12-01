package edu.fiuba.algo3;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.ManejarJson.DeserializadorJSON;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
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
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();

        int valorEsperadoAncho = 10;
        int valorEsperadoLargo = 18;

        assertEquals(valorEsperadoAncho,deserializadorJSON.extraerValorAnchoDelMapa(rutaDelArchivo));
        assertEquals(valorEsperadoLargo,deserializadorJSON.extraerValorLargoDelMapa(rutaDelArchivo));

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

        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda(rutaDelArchivo);
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

        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda(rutaDelArchivo);

        List<Casilla> listaCasillas = deserializadorJSON.obtenerListaCasillas();

        Tablero tablero = new Tablero(1,new Turno(30));

        for (Casilla casillaActual : listaCasillas){

            tablero.agregarCasilla(casillaActual);
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

package edu.fiuba.algo3;
import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Controlador.ManejarJson.DeserializadorJSON;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;


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


    /**
     * Verifico que el gladiador recorra todo el camino del json
     * */
    @Test
    public void Test017VerificarQueElJuegoSeCreaAcordeALJson() {

        Mapa mapa = new Mapa();
        mapa.mapaReal();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,mapa.obtenereCamino() ,dado);
        Posicion posicion = new Posicion(1, 7);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarJugador(unGladiador);
        assertEquals(1, unGladiador.obtenerPosicionEnX());
        assertEquals(7,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(2, unGladiador.obtenerPosicionEnX());
        assertEquals(7,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(2, unGladiador.obtenerPosicionEnX());
        assertEquals(6,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(2, unGladiador.obtenerPosicionEnX());
        assertEquals(5,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        tablero.avanzar(); //por el tema del turno, lesion pierde un turno
        assertEquals(2, unGladiador.obtenerPosicionEnX());
        assertEquals(4,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(2, unGladiador.obtenerPosicionEnX());
        assertEquals(3,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(2, unGladiador.obtenerPosicionEnX());
        assertEquals(2,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        tablero.avanzar(); //por el tema del turno, lesion pierde un turno
        assertEquals(2, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(3, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(4, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(5, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(6, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        tablero.avanzar(); //por el tema del turno, lesion pierde un turno
        assertEquals(7, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(8, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(9, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(10, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(11, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        tablero.avanzar(); //por el tema del turno, lesion pierde un turno
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(2,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(3,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(4,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(5,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(6,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(7,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(8,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(12, unGladiador.obtenerPosicionEnX());
        assertEquals(9,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        tablero.avanzar(); //por el tema del turno, lesion pierde un turno
        assertEquals(13, unGladiador.obtenerPosicionEnX());
        assertEquals(9,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(14, unGladiador.obtenerPosicionEnX());
        assertEquals(9,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(15, unGladiador.obtenerPosicionEnX());
        assertEquals(9,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(16, unGladiador.obtenerPosicionEnX());
        assertEquals(9,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(9,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        tablero.avanzar(); //por el tema del turno, lesion pierde un turno
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(8,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(7,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(6,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(5,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(4,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(3,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(2,unGladiador.obtenerPosicionEnY());

        tablero.avanzar();
        assertEquals(17, unGladiador.obtenerPosicionEnX());
        assertEquals(1,unGladiador.obtenerPosicionEnY());



    }

}

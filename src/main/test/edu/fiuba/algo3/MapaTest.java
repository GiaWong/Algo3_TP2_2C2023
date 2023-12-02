package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {

    @Test
    public void test01UnGladiadorSeMueveDosCasillasDeCamino(){

        Mapa mapa = new Mapa();
        mapa.mapaReal();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List <Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        tablero.setearCamino(unCamino);

        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,7);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());

        int posicionEnxEsperada = 2;
        int posicionEnyEsperada =7 ;
        assertEquals(posicionEnxEsperada, unGladiador.obetenerPosicionEnX());
        assertEquals(posicionEnyEsperada,unGladiador.obetenerPosicionEnY());


    }
    /*
    @Test
    public void test02UnGladiadorAvanzaAUnaCasillaEnElNuevoMapa(){
        //Arrange
        Tablero tablero = new Tablero(1,new Turno(30));
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";
        tablero.AgregarMapa(rutaDelArchivo);
        Gladiador gladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(gladiador);


        tablero.avanzar(new DadoMock());
        //Act
        int posicionEsperada = 1;

        //Assert
        assertEquals(1,gladiador.obtenerPosicion());


    }

    @Test
    public void test03CreoElMapaVersionMatriz(){
        Tablero tablero =new Tablero(1,new Turno(30));
        tablero.AgregarMapaComoMatriz();

    }

     */
    /*
    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {

        Mapa mapa = new Mapa();
        mapa.mapaReal();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(5),unCamino);
        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int posicionEsperada = 5;
        assertEquals(posicionEsperada, unGladiador.obtenerPosicionEnCamino());

    }
    */
}

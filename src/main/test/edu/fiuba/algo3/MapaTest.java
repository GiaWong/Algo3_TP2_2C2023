package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {

    @Test
    public void test01UnGladidadorAvanzaAUnaCasillaConDosOcupaciones(){
        Tablero tablero = new Tablero(1,new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla (new FieraSalvaje(20),new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        //Act and Assert -> Primero recibe el equipamiento y luego se enfrenta con la fiera
        int energiaEsperada = 5;
        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());


    }

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

}

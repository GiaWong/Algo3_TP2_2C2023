package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsosEntregaUno {

    @Test
    public void Test01UnGladiadorSeInicializaConLaEnergiaYNoTieneEquipamiento() {

        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);
        int energiaEsperada = 20;
        int equipamientoEsperado = 0;

        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());
        assertEquals(equipamientoEsperado,unGladiador.obtenerCantidadDeEquipamiento());

    }

    @Test
    public void Test02VerificarQueUnGladiadorSalgaDeLaCasillaInicial() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla((new Casilla(new NadaOcupacion())));
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int energiaEsperada = 20;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }

    @Test
    public void Test03VerificarQuejugadorSinEnergiaNoPuedaJugarElTurno() {

        Tablero tablero = new Tablero(1, new Turno(30));//para turno asumimos que el gladiador 1 será el primer turno
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(0, new Novato(), 0);//asumimos que ya tiene energia cero, el como llega a ese eavlor se discute luego
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int posicionEsperada = 0;
        assertEquals(posicionEsperada, unGladiador.obtenerPosicion());//Como el gladiador no avanzo, su turno expiro

    }

   @Test
    public void Test04VerificarQueSiRecibeComidaIncrementaEnergiaEn15() {

        Tablero tablero = new Tablero(1,new Turno(30));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
       //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int energiaEsperada = 35;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }

    @Test
    public void Test05VerificarQueSiRecibeUnPremioPorPrimeraVezObtieneUnCasco() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }


    @Test
    public void Test06VerificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada(){

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2)));
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test07VerificarQueSiHayUnCombateConUnaFieraSalvajeYTieneCascoPierde5Puntos() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        // agrego mas casillas para que el gladiador no llegue a la meta
        // porque asumí que si ya no hay mas casillas entonces se llegó a la meta
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int energiaEsperada = 15;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());




    }

    @Test
    public void Test08VerificarQueSiPasan8TurnosElGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaEnElSiguienteTurno() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int energiaEsperada = 60;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test09UnGladiadorLLegaALaMetaSinLaLLaveYEsteRetrocedeHastaLaMitadDeLasCasillas() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int posicionEsperada = 1;
        assertEquals(posicionEsperada, unGladiador.obtenerPosicion());

    }

    //El enunciado del teest stá mal del pdf, si tiene todos los equipamientos solo le resta -2,
    // guiarse del cuadro obstaculo
    @Test
    public void Test10UnGladiadorConTodosSusEquipamientosEsAtacadoPorUnaFieraSalvajeLaEnergiaNoSeModifica() {

        Tablero tablero = new Tablero(1, new Turno(30));

        tablero.agregarCasilla(new Casilla(new NadaOcupacion())); //pos0
        tablero.agregarCasilla(new Casilla(new Casco(5))); //pos1 -5pu
        tablero.agregarCasilla(new Casilla(new Armadura(5))); // pos2 -10pu
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2))); //pos3 -2pu
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));           // pos4
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));//pos5
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());


        int energiaEsperada = 20;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }@Test
    public void Test11UnGladiadorTieneLaLLaveYRecibeOtroPremioNoCambiaNada() {

    }
    @Test
    public void Test12GladiadorNoLLegaALaMetaAlPasarTreintaTurnosElJuegoSeTermina() {

    }
}


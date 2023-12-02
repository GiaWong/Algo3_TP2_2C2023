package edu.fiuba.algo3.Modelo;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import java.util.ArrayList;

public class Tablero {
    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private ArrayList<Casilla> listaDeCasillas;
    private Turno turno;
    private Casilla[][] mapa;
    public Tablero(int cantidadJugadores, Turno turno, Casilla[][] unMapa) {
        this.cantidadDeJugadores = cantidadJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.listaDeCasillas = new ArrayList<>();
        this.turno = turno;
        this.mapa = unMapa;
    }

    public void agregarCasillaAlMapa(Casilla unaCasilla){
        this.mapa[unaCasilla.obtenerposicionEnX()][unaCasilla.obtenerposicionEny()] =unaCasilla;
    }

    public void agregarJugador(Gladiador gladiador) {
            listaDeGladiadores.add(gladiador);
    }

    public boolean validarTurno(Gladiador unGladiador){return (turno.jugar(unGladiador));}

    public void avanzar(Dado dado) {

        int cantidadAMoverse = dado.lanzarDado();
        Gladiador ungladiador = turno.siguienteTurno(listaDeGladiadores);

        if (this.validarTurno(ungladiador)) {

            Casilla casillaActual = mapa[ungladiador.obetenerPosicionEnX()][ungladiador.obetenerPosicionEnY()];
            ungladiador = casillaActual.interactuarConLaOcupacion(ungladiador, cantidadAMoverse);
        }
    }

    public boolean FinalizarJuego(){
        boolean validacion = turno.validarFinalizarJuego();
        if (validacion){
            reiniciarTodoLosValores();
        }
        return validacion;

    }

    public int LongitudDeTablero(){
        return this.listaDeCasillas.size();
    }

    public boolean validarGanador(Gladiador unGladiador) {

        boolean validarEquipamiento = unGladiador.cantidadEquipamientoPermitido();
        boolean validarPosicion = unGladiador.SeEncuentraEnUltimaPosicion(LongitudDeTablero());

        if (validarPosicion && validarEquipamiento){
            reiniciarTodoLosValores();
            System.out.println("\n----GANASTE, FELICIDADES!----\n");
            return true;
        }
        return false;

    }

    private void reiniciarTodoLosValores(){
        this.cantidadDeJugadores = 0;
        this.listaDeGladiadores.clear();
        this.listaDeCasillas.clear();
        this.turno = null;
    }

}
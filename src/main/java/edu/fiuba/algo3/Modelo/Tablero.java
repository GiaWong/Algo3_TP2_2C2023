package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private ArrayList<Casilla> listaDeCasillas;
    private Turno turno;

    public Tablero(int cantidadJugadores, Turno turno) {
        this.cantidadDeJugadores = cantidadJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.listaDeCasillas = new ArrayList<>();
        this.turno = turno;
    }

    public void agregarCasilla(Casilla unaCasilla) {
        listaDeCasillas.add(unaCasilla);
    }

    public void agregarJugador(Gladiador gladiador) {
            listaDeGladiadores.add(gladiador);
    }

    public boolean validarTurno(Gladiador unGladiador){return (turno.jugar(unGladiador));}

    private Casilla obtenerCasilla(int unaPosicion){return (listaDeCasillas.get(unaPosicion));}

    private int obtenerPosicionMitadCasilla() {

        int longitud = listaDeCasillas.size();
        if (longitud > 0) {
            int indiceMitad = longitud / 2;
            System.out.println("Cantidad casillas a retroceder: " + indiceMitad);
            return indiceMitad ;

        } else {
            System.out.println("La Lista de Casilla está vacía.");
            return 0;
        }
    }
    private boolean hayMasCasillas() {
        return (listaDeCasillas.size() > 1);
    }

    private boolean esLaUltimaPosicion(int posicion) {
        return  (posicion == listaDeCasillas.size() - 1);
    }



    public void avanzar(Dado dado) {

        int cantidadAMoverse = dado.tirar();


        Gladiador ungladiador = listaDeGladiadores.get(0);//refactorizar porque simpre estamos trabajando con primer gladiaor de la lista

        if (this.validarTurno(ungladiador)) { //(esto es un pecado) refactorizar con excepcion

            Casilla casillaActual = obtenerCasilla(ungladiador.obtenerPosicion());



            int energiaModificada = casillaActual.modificarEnergia(ungladiador.obtenerEnergia());
            ungladiador.setEnergia( energiaModificada);
            ungladiador.agregarEquipamiento( casillaActual.getEquipamiento() );

            if(hayMasCasillas()) {
                ungladiador.avanzar(cantidadAMoverse);
            }



            if(esLaUltimaPosicion(ungladiador.obtenerPosicion())){

                if (!ungladiador.tieneLLave()) { //si no tiene llave
                    System.out.println("\n----Se LLegó a la meta sin equipamiento completo----\n");
                    cantidadAMoverse = obtenerPosicionMitadCasilla();
                    ungladiador.retroceder(cantidadAMoverse);
                }


            }











        }


    }



}

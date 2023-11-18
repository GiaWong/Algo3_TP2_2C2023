package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Modelo.Equipamientos.LLave;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Seniority.Seniority;

import java.util.ArrayList;

public class Gladiador {
    private int posicionActual;
    private int energia;
    private Seniority unSeniority;

    private ArrayList<Ocupacion> listaDeEquipamiento;


    public Gladiador(int unaEnergia, Novato novato, int posicionActual) {
        this.energia = unaEnergia;
        this.posicionActual = posicionActual;
        this.unSeniority = novato;
        this.listaDeEquipamiento = new ArrayList<>();
    }

    public int obtenerEnergia() {
        return energia;
    }


    public void cambiarSeniority(Seniority seniority) {
        this.unSeniority = seniority;
    }

    public void avanzar(int cantidadAMoverse) {
        posicionActual = posicionActual + cantidadAMoverse;
        System.out.println("Gladiador avanza una casilla ---> está en la posicion:  " + posicionActual);

    }

    public int obtenerPosicion() {
        return posicionActual;
    }


    //Esto tiene que aplicar el seniority, cada vez que inicia el turno recibe esta energia
    //Cuando pasar x turnos, cambia al siguiente
    public void aumentarEnergiaAlIniciarElTurno(){energia = unSeniority.modificarEnergia(energia);}
    public void setEnergia(int unaEnergia ){energia = unaEnergia; }

    public int obtenerCantidadDeEquipamiento(){return listaDeEquipamiento.size();}
    public void agregarEquipamiento(Ocupacion ocupacion){

        if(!NadaOcupacion.class.equals(ocupacion.getClass()) && listaDeEquipamiento.size() < 4){
            listaDeEquipamiento.add(ocupacion);
        }

        else {
            System.out.println("No se agrega nada de Equipamiento");
        }

    }

    public void retroceder(int cantidadAMoverse) {
        posicionActual = posicionActual - cantidadAMoverse;
        System.out.println("Gladiador retrocede ----> está en la posicion: " + posicionActual);

    }

    public boolean tieneLLave() {
        // Utilicé Stream para buscar el elemento en la lista
        return ((listaDeEquipamiento.stream()
                .anyMatch(elemento -> elemento instanceof LLave)) && cantidadEquipamientoPermitido());

    }

    private boolean cantidadEquipamientoPermitido() {
        return (this.obtenerCantidadDeEquipamiento() == 3);
    }

    //Vamos a hacer que combatir se la parte donde el gladiador se proteje de la fiera -> osea usa la energia de su equipamiento
    public void combatir() {

        for (Ocupacion unEquipamiento: listaDeEquipamiento) {
            this.setEnergia(unEquipamiento.modificarEnergia(energia));

        }
        //Malisimo, estoy modificando la energia antes de la pelea
    }
}

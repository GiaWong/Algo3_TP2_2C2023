package edu.fiuba.algo3.Modelo;

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

    public void setEnergia(int unaEnergia ){
        energia = unSeniority.modificarEnergia(unaEnergia);
    }

    public int obtenerCantidadDeEquipamiento(){return listaDeEquipamiento.size();}
    public void agregarEquipamiento(Ocupacion ocupacion){
        if(NadaOcupacion.class.equals(ocupacion.getClass())){
            System.out.println("No se agrega nada de Equipamiento");
        }else {
            listaDeEquipamiento.add(ocupacion);
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

    //aca entra la logica de Ignacio
    public void combatir() {

        Ocupacion unEquipamiento = listaDeEquipamiento.get(listaDeEquipamiento.size() - 1);//me da el ultimo
        unEquipamiento.modificarEnergia(energia); //casco,armadura,escudoEspada

    }
}

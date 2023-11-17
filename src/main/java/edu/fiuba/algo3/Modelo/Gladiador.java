package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;

public class Gladiador {
    private int posicionActual;
    private int energia;
    private Seniority unSeniority;
    private ArrayList<Ocupacion> listaDeEquipamiento;


    public Gladiador(int unaEnergia, Novato novato, int posicion) {
        this.energia = unaEnergia;
        this.posicionActual = posicion;
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
}

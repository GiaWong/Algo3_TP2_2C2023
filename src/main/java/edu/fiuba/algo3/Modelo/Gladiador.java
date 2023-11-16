package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;

public class Gladiador {
    private int posicion;
    private int energia;
    private Seniority unSeniority;
    private ArrayList<Ocupacion> listaDeEquipamiento;


    public Gladiador(int unaEnergia, Novato novato, int posicion) {
        this.energia = unaEnergia;
        this.posicion = posicion;
        this.unSeniority = novato;
        this.listaDeEquipamiento = new ArrayList<>();
    }

    public int obtenerEnergia() {
        return energia;
    }


    public int  obtenerEquipamiento() {
        return 0;

    }

    public void cambiarSeniority(Seniority seniority) {
        this.unSeniority = seniority;
    }

    public void avanzar(int moverUnasCasillas) {
        posicion = posicion + moverUnasCasillas;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public void setEnergia(int unaEnergia ){
        energia = unSeniority.modificarEnergia(unaEnergia);
    }

    public int obtenerCantidadDeEquipamiento(){return listaDeEquipamiento.size();}
    public void agregarEquipamiento(Ocupacion ocupacion){
        listaDeEquipamiento.add(ocupacion);
    }
}

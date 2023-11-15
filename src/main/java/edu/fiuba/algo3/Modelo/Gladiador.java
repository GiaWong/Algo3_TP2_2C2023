package edu.fiuba.algo3.Modelo;

public class Gladiador {
    private int posicion;
    private int energia;
    private Novato unSeniority;


    public Gladiador(int unaEnergia, Novato novato, int posicion) {
        this.energia = unaEnergia;
        this.posicion = posicion;
        this.unSeniority = novato;
    }

    public int obtenerEnergia() {
        return energia;
    }


    public int  obtenerEquipamiento() {
        return 0;

    }

    public void avanzar(int moverUnasCasillas) {
        posicion = posicion + moverUnasCasillas;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public void setEnergia(int unaEnergia ){
        energia = unaEnergia;
    }
}

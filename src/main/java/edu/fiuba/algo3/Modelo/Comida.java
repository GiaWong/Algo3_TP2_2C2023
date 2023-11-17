package edu.fiuba.algo3.Modelo;

public class Comida implements Ocupacion  {

    private int energia;
    public Comida(int energiaPropia){this.energia = energiaPropia;}

    @Override
    public Gladiador modificarEnergia(Gladiador unGladiador) {//estosMetodos está de mas =(
        return null;
    }

    @Override
    public int modificarEnergia(int unaEnergia) {//estosMetodos está de mas =(
        return 0;
    }

    @Override
    public Gladiador combatir(Gladiador ungladiador) {//estosMetodos está de mas =(
        return null;
    }

    @Override
    public Gladiador recibirPremio(Gladiador ungladiador) {

        int energiaModificada = ungladiador.obtenerEnergia() + energia;
        ungladiador.setEnergia(energiaModificada);
        return ungladiador;
    }
}

package edu.fiuba.algo3.Modelo.Obstaculos;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;

public  class FieraSalvaje implements Ocupable, Obstaculizador {
    private int unaEnergia;

    public FieraSalvaje() {
        unaEnergia = 20;
    }

    @Override
    public int modificarEnergia(int energia) {
        return (energia - unaEnergia) ;
    }

    @Override
    public void combatir(Gladiador unGladiador) {
        unGladiador.combatir(this );
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        this.combatir(unGladiador);
        System.out.println("\nEntró a FieraSalvaje");
        //PantallaMapa.obtenerLabelObstaculo().setText("Obstaculo: se enfrenta a una fiera salvaje.");
        return  unGladiador;
    }
}

package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public class FieraSalvaje implements Ocupacion, Obstaculo {
    private int energia;

    public FieraSalvaje(int energia) {
        this.energia = energia;
    }

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador gladiador) {
        return visitor.visitar(this, gladiador);
    }

    // Método significativo que indica claramente la acción
    public int modificarEnergia(int energia) {
        return (energia - this.energia);
    }

    @Override
    public void combatir(Gladiador gladiador) {
        gladiador.combatir(this);
    }
}
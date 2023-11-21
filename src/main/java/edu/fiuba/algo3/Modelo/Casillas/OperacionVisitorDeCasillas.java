package edu.fiuba.algo3.Modelo.Casillas;


import edu.fiuba.algo3.Modelo.Equipamientos.Armadura;
import edu.fiuba.algo3.Modelo.Equipamientos.Casco;
import edu.fiuba.algo3.Modelo.Equipamientos.EscudoYEspada;
import edu.fiuba.algo3.Modelo.Equipamientos.LLave;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;

public  class OperacionVisitorDeCasillas implements VisitorDeCasillas {


    @Override
    public Gladiador visitar(Casco casco, Gladiador unGladiador) {
        unGladiador = casco.modificarEnergia(unGladiador);
        unGladiador.agregarEquipamiento(casco);
        return unGladiador;
    }

    @Override
    public Gladiador visitar(Armadura armadura, Gladiador unGladiador) {
        unGladiador = armadura.modificarEnergia(unGladiador);
        unGladiador.agregarEquipamiento(armadura);
        return  unGladiador;
    }

    @Override
    public Gladiador visitar(EscudoYEspada escudoYEspada, Gladiador unGladiador) {
        unGladiador = escudoYEspada.modificarEnergia(unGladiador);
        unGladiador.agregarEquipamiento(escudoYEspada);
        return unGladiador;
    }

    @Override
    public Gladiador visitar(LLave lLave, Gladiador unGladiador) {
        //ver que metodo hará la llave
        return  unGladiador;
    }

    @Override
    public Gladiador visitar(FieraSalvaje fieraSalvaje, Gladiador unGladiador) {
        fieraSalvaje.combatir(unGladiador);
        System.out.println("\nEntró a FieraSalvaje");
        return  unGladiador;
    }

    @Override
    public Gladiador visitar(NadaOcupacion nada, Gladiador unGladiador) {
        //ver que hará el Nada
        return unGladiador;
    }

    @Override
    public Gladiador visitar(Comida comida, Gladiador unGladiador) {
        comida.modificarEnergia(unGladiador);
        return unGladiador;
    }
}

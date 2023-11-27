package edu.fiuba.algo3.Modelo.Casillas;


import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;

public  class OperacionVisitorDeCasillas implements VisitorDeCasillas {

    @Override
    public Gladiador visitar(Casco casco, Gladiador unGladiador) {
        unGladiador.agregarEquipamiento(casco);
        System.out.println("\n===> Se agrega un Casco al Equipamiento");
        return unGladiador;
    }

    @Override
    public Gladiador visitar(Armadura armadura, Gladiador unGladiador) {
        unGladiador.agregarEquipamiento(armadura);
        System.out.println("\n===> Se agrega una Armadura al Equipamiento");
        return  unGladiador;
    }

    @Override
    public Gladiador visitar(EscudoYEspada escudoYEspada, Gladiador unGladiador) {
        unGladiador.agregarEquipamiento(escudoYEspada);
        System.out.println("\n===> Se agrega un EscudoEspada al Equipamiento");
        return unGladiador;
    }

    @Override
    public Gladiador visitar(LLave lLave, Gladiador unGladiador) {
        unGladiador.agregarEquipamiento(lLave);
        System.out.println("\n===> Se agrega una LLave al Equipamiento");
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

    @Override
    public Gladiador visitar(PremioEquipamiento unPremio, Gladiador unGladiador) {
        unGladiador.agregarEquipamientoSegunCantidadDePremios();
        return unGladiador;
    }
    @Override
    public Gladiador visitar(Bacanal bacanal, Gladiador unGladiador) {
        bacanal.combatir(unGladiador);
        System.out.println("\nEntró a Bacanal");
        return  unGladiador;
    }


}

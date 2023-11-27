package edu.fiuba.algo3.Modelo;

import java.util.Random;

public class DadoReal implements Dado{

    public int lanzarDado() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}

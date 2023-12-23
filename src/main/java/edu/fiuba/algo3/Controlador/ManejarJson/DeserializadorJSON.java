package edu.fiuba.algo3.Controlador.ManejarJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.Modelo.Casillas.*;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Obstaculos.Lesion;
import edu.fiuba.algo3.Modelo.Premios.Comida;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeserializadorJSON {
    List<Casilla> listaCasillas;
    public DeserializadorJSON() {
       listaCasillas = new ArrayList<>();
    }

    public int extraerValorAnchoDelMapa() {

        String rutaArchivoJson = "src/main/java/ArchivoJson/mapa.json";
        try {

            String json = new String(Files.readAllBytes(Paths.get(rutaArchivoJson)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode mapaNode = rootNode.get("mapa");
            return mapaNode.get("ancho").asInt();

        } catch (Exception e) {
            e.printStackTrace();
            return -1; //devuelvvo -1 porque el 0 se contempla en el tablero como una posicion mas
        }
    }

    public int extraerValorLargoDelMapa() {
        String rutaArchivoJson = "src/main/java/ArchivoJson/mapa.json";
        try {

            String json = new String(Files.readAllBytes(Paths.get(rutaArchivoJson)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode mapaNode = rootNode.get("mapa");
            return mapaNode.get("largo").asInt();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void extraerContenidoDeCadaCelda() {
        String rutaArchivoJson = "src/main/java/ArchivoJson/mapa.json";
        try {

            String json = new String(Files.readAllBytes(Paths.get(rutaArchivoJson)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode celdas = rootNode.get("camino").get("celdas");

            for (JsonNode celda : celdas) {

                int posX = celda.get("x").asInt();
                int posY = celda.get("y").asInt();
                String obstaculo = celda.get("obstaculo").asText().toUpperCase();
                String premio = celda.get("premio").asText().toUpperCase();
                String tipo = celda.get("tipo").asText().toUpperCase();
                Casilla casillaActual = new Casilla(transformarAObjeto(obstaculo), transformarAObjeto(premio),posX,posY,tipo);
                listaCasillas.add(casillaActual);

            }


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    private Ocupable transformarAObjeto(String nombreActual) {

        if (nombreActual.equalsIgnoreCase("Lesion")) {
            return new Lesion();

        } else if (nombreActual.equalsIgnoreCase("Fiera")) {
            return new FieraSalvaje();

        } else if (nombreActual.equalsIgnoreCase("Bacanal")) {
            return new Bacanal();

        } else if (nombreActual.equalsIgnoreCase("Equipamiento")) {
            return new PremioEquipamiento();

        } else if (nombreActual.equalsIgnoreCase("Comida")) {
            return new Comida(15);

        } else {
            return new NadaOcupacion();
        }


    }

    public int cantidadCeldasDeserealizadas() {
        return  listaCasillas.size();
    }

    public List<Casilla> obtenerListaCasillas() {
        return  listaCasillas;
    }
}

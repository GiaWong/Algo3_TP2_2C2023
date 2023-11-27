package edu.fiuba.algo3;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CasosDeUsosEntregaDos {

    @Test
    public void Test013SeVerificaJsonDeMapaEsValido() { //verifico la estructura del .json

        // Ruta al archivo JSON
        String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";
        try {
            // Creando un ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Leeyendo el archivo JSON y mapeando a un árbol de nodos
            JsonNode jsonNode = objectMapper.readTree(new File(rutaDelArchivo));

            // Verifico la existencia y el tipo de los campos
            assertTrue(jsonNode.has("mapa"));
            assertTrue(jsonNode.get("mapa").isObject());
            assertTrue(jsonNode.get("mapa").has("ancho"));
            assertTrue(jsonNode.get("mapa").has("largo"));
            assertTrue(jsonNode.get("mapa").get("ancho").isInt());
            assertTrue(jsonNode.get("mapa").get("largo").isInt());

            // Verifico la existencia y el tipo de los campos en las celdas/Casillas del camino
            assertTrue(jsonNode.has("camino"));
            assertTrue(jsonNode.get("camino").isObject());
            assertTrue(jsonNode.get("camino").has("celdas"));
            assertTrue(jsonNode.get("camino").get("celdas").isArray());

            // Itero sobre las celdas/Casillas del camino y verifico sus campos
            JsonNode celdas = jsonNode.get("camino").get("celdas");
            for (JsonNode celda : celdas) {
                assertTrue(celda.has("x"));//son las claves
                assertTrue(celda.has("y"));
                assertTrue(celda.has("tipo"));
                assertTrue(celda.has("obstaculo"));
                assertTrue(celda.has("premio"));
                assertTrue(celda.get("x").isInt());
                assertTrue(celda.get("y").isInt());
                assertTrue(celda.get("tipo").isTextual());
                assertTrue(celda.get("obstaculo").isTextual());
                assertTrue(celda.get("premio").isTextual());
            }

        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al leer el archivo JSON");
        }

    }

    @Test
    public void Test014SeVerificaJsonDeObstaculosYPremiosSonValidos() {//verifico el contenido de la ocupacion


        String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(rutaDelArchivo));
            JsonNode celdas = jsonNode.get("camino").get("celdas");

            // Para almacenar obstáculos y premios extraidos del json
            List<String> listaObstaculosJSON = new ArrayList<>();
            List<String> listaPremiosJSON = new ArrayList<>();

            // Itero sobre las celdass del camino
            for (JsonNode celda : celdas) {

                String obstaculo = celda.get("obstaculo").asText().toUpperCase();
                String premio = celda.get("premio").asText().toUpperCase();
                listaObstaculosJSON.add(obstaculo);
                listaPremiosJSON.add(premio);

            }

            assertTrue(existenObstaculosNoContemplados(listaObstaculosJSON), "Existen obstáculos invalidos");
            assertTrue(existenPremiosNoContemplados(listaPremiosJSON), "Existen premios invalidos");

        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al leer el archivo JSON");
        }

    }

    private boolean existenObstaculosNoContemplados(List<String> listaObstaculosJSON) {

        List<String> obstaculosPermitidos = new ArrayList<>();
        obstaculosPermitidos.add("".toUpperCase());
        obstaculosPermitidos.add("Lesion".toUpperCase());
        obstaculosPermitidos.add("Fiera".toUpperCase());
        obstaculosPermitidos.add("Bacanal".toUpperCase());

        return listaObstaculosJSON.stream()
                .allMatch(elementoActual -> obstaculosPermitidos.contains(elementoActual));

    }
    private boolean existenPremiosNoContemplados(List<String> listaPremiosJSON) {

        List<String> premiosPermitidos = new ArrayList<>();
        premiosPermitidos.add("".toUpperCase());
        premiosPermitidos.add("Equipamiento".toUpperCase());
        premiosPermitidos.add("Comida".toUpperCase());

        return listaPremiosJSON.stream()
                .allMatch(elementoActual -> premiosPermitidos.contains(elementoActual));

    }


    @Test
    public void Test015SeVerificaLaLecturayConversionDeEnemigosDeJsonEsValido() {
    }

    @Test
    public void Test016SeVerificaLaLecturayConversionDeEnemigosDeJsonEsValido() {
    }

    @Test
    public void Test017SeVerificaElsistemaLog() {
    }

    @Test
    public void Test018SeVerificaLaCreacionDeAmbosJson() {
    }

    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {
    }

    @Test
    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    }
}

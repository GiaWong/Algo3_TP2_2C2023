package edu.fiuba.algo3;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.ManejarJson.DeserializadorJSON;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Obstaculos.Lesion;
import edu.fiuba.algo3.Modelo.Premios.Comida;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class CasosDeUsosEntregaDos {
    List<String> obstaculosPermitidosSegunModelo;
    List<String> premiosPermitidosSegunModelo;
    public CasosDeUsosEntregaDos(){//constructor

        this.obstaculosPermitidosSegunModelo = new ArrayList<>();
        this.premiosPermitidosSegunModelo = new ArrayList<>();


        this.obstaculosPermitidosSegunModelo.add("".toUpperCase());
        this.obstaculosPermitidosSegunModelo.add("Lesion".toUpperCase());
        this.obstaculosPermitidosSegunModelo.add("Fiera".toUpperCase());
        this.obstaculosPermitidosSegunModelo.add("Bacanal".toUpperCase());

        this.premiosPermitidosSegunModelo.add("".toUpperCase());
        this.premiosPermitidosSegunModelo.add("Equipamiento".toUpperCase());
        this.premiosPermitidosSegunModelo.add("Comida".toUpperCase());
    }

    /**
     * Verifico que se haya deserializado "ancho" y "largo" del mapa json
     * */
    @Test
    public void Test013SeVerificaElFormatoValidoDelJsonDelMapa() {

        // Ruta al archivo JSON
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();

        int valorEsperadoAncho = 10;
        int valorEsperadoLargo = 18;

        assertEquals(valorEsperadoAncho,deserializadorJSON.extraerValorAnchoDelMapa(rutaDelArchivo));
        assertEquals(valorEsperadoLargo,deserializadorJSON.extraerValorLargoDelMapa(rutaDelArchivo));

    }

    @Test
    public void Test014SeVerificaJsonDeObstaculosYPremiosSonValidos() {//verifico el contenido de la ocupacion


        /*String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";

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
        }*/

    }

    private boolean existenObstaculosNoContemplados(List<String> listaObstaculosJSON) {
        return listaObstaculosJSON.stream()
                .allMatch(elementoActual -> this.obstaculosPermitidosSegunModelo.contains(elementoActual));

    }
    private boolean existenPremiosNoContemplados(List<String> listaPremiosJSON) {
        return listaPremiosJSON.stream()
                .allMatch(elementoActual -> this.premiosPermitidosSegunModelo.contains(elementoActual));

    }

    private boolean conversionObstaculosJsonAlModelo(List<String> listaObstaculosJSON) {
        List<Ocupable> listaDeObjetosObstaculos = new ArrayList<>();
        if(existenObstaculosNoContemplados(listaObstaculosJSON)) {

            for (String nombreActual : listaObstaculosJSON) {

                if (nombreActual.equalsIgnoreCase("Lesion")) {
                    System.out.println("\nConvirtiendo a clase Lesion()");
                    listaDeObjetosObstaculos.add(new Lesion());

                } else if (nombreActual.equalsIgnoreCase("Fiera")) {
                    System.out.println("\nConvirtiendo a clase FieraSalvaje()");
                    listaDeObjetosObstaculos.add( new FieraSalvaje(5));

                } else if (nombreActual.equalsIgnoreCase("Bacanal")) {
                    System.out.println("\nConvirtiendo a clase Bacanal()");
                    listaDeObjetosObstaculos.add( new Bacanal());
                } else
                {
                    System.out.println("\nConvirtiendo a clase NadaOcupacion()");
                    listaDeObjetosObstaculos.add( new NadaOcupacion());
                }
            }
            return true;
        }
        return false;

    }
    private boolean conversionDePremiosJsonAlModelo(List<String> listaPremiosJSON) {
        List<Ocupable> listaDeObjetosPremios = new ArrayList<>();
        if (existenPremiosNoContemplados(listaPremiosJSON)) {

            for (String nombreActual : listaPremiosJSON) {

                if (nombreActual.equalsIgnoreCase("Equipamiento")) {
                    System.out.println("\nConvirtiendo a clase Equipamiento");
                    listaDeObjetosPremios.add(new PremioEquipamiento());

                } else if (nombreActual.equalsIgnoreCase("Comida")) {
                    System.out.println("\nConvirtiendo a clase Comida");
                    listaDeObjetosPremios.add(new Comida(15));

                }
                else
                {
                    System.out.println("\nConvirtiendo a clase NadaOcupacion()");
                    listaDeObjetosPremios.add(new NadaOcupacion());
                }

            }
            return true;
        }

        return false;
    }

    @Test
    public void Test015SeVerificaLaLecturayConversionDeObstaculosDelJsonAlModelo() {//los contenidos de obstaculos vincularlos con los objetos del modelo

        /*String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(rutaDelArchivo));
            JsonNode celdas = jsonNode.get("camino").get("celdas");
            List<String> listaObstaculosJSON = new ArrayList<>();

            for (JsonNode celda : celdas) {
                String obstaculo = celda.get("obstaculo").asText().toUpperCase();
                listaObstaculosJSON.add(obstaculo);
            }

            assertTrue(conversionObstaculosJsonAlModelo(listaObstaculosJSON), "\nNo se pudo convertir a los objetos del Modelo");

        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al leer el archivo JSON");
        }*/

    }
    @Test
    public void test016SeVerificaLaLecturayConversionDePremiosDelJsonAlModelo() {

       /* String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(rutaDelArchivo));
            JsonNode celdas = jsonNode.get("camino").get("celdas");
            List<String> listaPremiosJSON = new ArrayList<>();

            for (JsonNode celda : celdas) {
                String premio = celda.get("premio").asText().toUpperCase();
                listaPremiosJSON.add(premio);
            }

            assertTrue(conversionDePremiosJsonAlModelo(listaPremiosJSON), "\nNo se pudo convertir a los objetos del Modelo");

        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al leer el archivo JSON");
        }*/

    }


    @Test
    public void Test017VerificarQueElJuegoSeCreaAcordeALosPuntoJson() {


    }

    /*
    @Test
    public void Test018SeVerificaLaCreacionDeAmbosJson() {
    }*/

    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {

        Tablero tablero = new Tablero(1, new Turno(5));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        boolean JugadorEsGanador= true;
        assertEquals(JugadorEsGanador, tablero.validarGanador(unGladiador));

    }

    /*@Test
    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    }*/
}

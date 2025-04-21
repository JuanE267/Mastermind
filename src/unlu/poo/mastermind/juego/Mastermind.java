package unlu.poo.mastermind.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mastermind {

    private List<Jugador> misJugadores;
    private Tablero miTablero;

    public static void main(String[] args) {
        Mastermind juego = new Mastermind();
        juego.comenzarJuego();
    }

    private void comenzarJuego() {
        int opcion = 1;
        while (opcion != 0) {
            opcion =  mostrarMenu();
            switch (opcion){
                case 1:
                    // Configurar intentos maximos
                    break;
                case 2:
                    // Agregar jugador
                    misJugadores.add(new Jugador(agregarJugador()));
                    break;
                case 3:
                    // Mostrar Lista de Jugadores
                    break;
                case 4:
                    // Comenzar juego
                    break;
            }
        }
    }

    private int mostrarMenu() {
        int opcion = -1;

        while (opcion < 0 || opcion > 3) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("--                        MASTER MIND                        --");
            System.out.println("--              el juego que esconde un secreto              --");
            System.out.println("");
            System.out.println("---------------------------------------------------------------");
            System.out.println("--                   Menu de Configuracion                   --");
            System.out.println("--                          Opciones                         --");
            System.out.println("---------------------------------------------------------------");
            System.out.println("--  1 - Establecer cantidad de intentos de claves            --");
            System.out.println("--  2 - Agregar Jugador                                      --");
            System.out.println("--  3 - Mostrar Lista de jugadores                           --");
            System.out.println("--  4 - Comenzar Partida                                     --");
            System.out.println("---------------------------------------------------------------");
            System.out.println("--  0 - Salir del Juego                                      --");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Ingrese la opcion: ");

            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
        }
        return opcion;
    }

    private String agregarJugador(){
        String nombre = "";

        while (nombre.equals("")) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("--                     Agregando jugador                     --");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Ingrese el nombre: ");

            Scanner scanner = new Scanner(System.in);
            nombre  = scanner.nextLine();
        }
        return nombre;
    }

    public Mastermind() {
        misJugadores = new ArrayList<>();
        miTablero = new Tablero();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

import java.util.Scanner;

/**
 *
 * @author hulkiniano
 */
public class AdivinaElNumero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcionJuego, opcionVolverAJugar;

        do {
            opcionJuego = menuInicio(sc);
            if (opcionJuego.equals("1")) {
                adivinaMaquina(sc);
            } else {
                adivinaJugador(sc);
            }
            opcionVolverAJugar = menuSalida(sc);
        } while (opcionVolverAJugar.equalsIgnoreCase("S"));
    }

    public static String menuInicio(Scanner sc) {
        String in = "";
        do {
            System.out.println("------------------------------------------");
            System.out.println("Introduzca una opción: ");
            System.out.println("--> 1 - Para que lo adivine la máquina");
            System.out.println("--> 2 - Para que lo adivine el usuario");
            System.out.print("Opción: ");
            in = sc.nextLine();
            if (!(in.equals("1") || in.equals("2"))) {
                System.out.println("------------------------------------------");
                System.out.println("Opción incorrecta. ");
            }
        } while (!(in.equals("1") || in.equals("2")));
        return in;
    }

    public static String menuSalida(Scanner sc) {
        String para = "";
        do {
            System.out.println("------------------------------------------");
            System.out.println("¿Quieres seguir jugando? (S/N)");
            para = sc.nextLine();
            if (!(para.equalsIgnoreCase("S") || para.equalsIgnoreCase("N"))) {
                System.out.print("Respuesta incorrecta. ");
            }
        } while (!(para.equalsIgnoreCase("S") || para.equalsIgnoreCase("N")));
        return para;
    }

    public static void adivinaMaquina(Scanner sc) {
        int adivinaMaquina, max = 100, min = 0, j = 0;
        String respuesta;
        System.out.println("------------------------------------------");
        System.out.println("Jugando a adivina máquina... ");
        System.out.println("Piensa un número del 1 al 100");
        do {
            adivinaMaquina = aleatorio(max, min);
            System.out.println("¿Es este tú número?: " + adivinaMaquina);
            respuesta = menuCorrectoMenorMayor(sc);
            if (respuesta.equalsIgnoreCase("Menor")) {
                max = adivinaMaquina - 1;
            }
            if (respuesta.equalsIgnoreCase("Mayor")) {
                min = adivinaMaquina + 1;
            }
            j++;
        } while (!respuesta.equalsIgnoreCase("Correcto"));
        System.out.println("");
        System.out.println("Lo adiviné!!! Sólo me hicieron falta " + j + " intentos");
    }

    public static void adivinaJugador(Scanner sc) {
        System.out.println("------------------------------------------");
        System.out.println("Jugando a que adivine el jugador...");
        int adivinaJugador, intentos = 0, numUsuario, max = 100, min = 0;
        String strUsuario;
        adivinaJugador = aleatorio(100, 0);
        do {
            do {
                System.out.print("Introduce un número del 1 al 100, a ver si aciertas: ");
                strUsuario = sc.nextLine();
                if (validaNumero(strUsuario) == false) {
                    System.out.println("Error, número incorrecto");
                }
            } while (!(validaNumero(strUsuario) == true));
            numUsuario = Integer.parseInt(strUsuario);
            if (numUsuario > max && numUsuario < min) {
                System.out.println("Error, número incorrecto");
            }
            intentos++;
            if (numUsuario > adivinaJugador) {
                System.out.println("No es ese número, es un número menor");
            } else if (numUsuario < adivinaJugador) {
                System.out.println("No es ese número, es un número mayor");
            } else if (numUsuario == adivinaJugador) {
                System.out.println("Has acertado!!!");
                System.out.println("Has necesitado " + intentos + " intentos");
            }
        } while (numUsuario != adivinaJugador);
    }

    public static boolean validaNumero(String strUsuario) {
        return strUsuario.matches("\\+?-?[0-9]+");
    }

    public static String menuCorrectoMenorMayor(Scanner sc) {
        String r = "";
        do {
            System.out.print("¿Es ese número (Correcto/Mayor/Menor)? ");
            r = sc.nextLine();
            if (!(r.equalsIgnoreCase("Correcto") || r.equalsIgnoreCase("Mayor") || r.equalsIgnoreCase("Menor"))) {
                System.out.print("Introduzca un valor correcto. ");
            }
        } while (!(r.equalsIgnoreCase("Correcto") || r.equalsIgnoreCase("Mayor") || r.equalsIgnoreCase("Menor")));
        return r;
    }

    public static int aleatorio(int max, int min) {
        int r = (int) (Math.random() * (max - min + 1) + min);
        return r;
    }
}

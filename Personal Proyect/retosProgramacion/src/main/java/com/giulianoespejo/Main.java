package com.giulianoespejo;
import java.util.HashMap;
import java.util.Scanner;



public class Main {

    static Scanner sc = new Scanner(System.in);
    static Scanner scNum = new Scanner(System.in);

    public static void main(String[] args) {
        //fizzbuzz(); //#0
        //lenguajeHacker(); //#1
        //partidoTenis();//#2
        primoFibonacciPar();
    }

    public static void primoFibonacciPar(){
        /*
         * Escribe un programa que, dado un número, compruebe y muestre si es primo,
         * fibonacci y par.
         * Ejemplos:
         * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
         * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
         */
    }

    public static void fibonacci(int n){
        if(n == 1){

        }
    }

    public static String par(int n){
        return (n % 2 == 0) ? "es par" : "es impar";
    }

    public static String primo(int n){
        String primo = "es primo";

        for (int i = 2; i < n; i++){
            if(n % i == 0){
                primo = "no es primo";
                break;
            }
        }
        return primo;
    }

    public static void partidoTenis(){
        /*
         * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
         * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
         * gane cada punto del juego.
         *
         * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
         * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
         *   15 - Love
         *   30 - Love
         *   30 - 15
         *   30 - 30
         *   40 - 30
         *   Deuce
         *   Ventaja P1
         *   Ha ganado el P1
         * - Si quieres, puedes controlar errores en la entrada de datos.
         * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
         */
        int puntos = 0;
        try {
            System.out.println("Ingrese la cantidad de puntos que va a ingresar");
            puntos = scNum.nextInt();
        }catch (Exception e){
            System.out.println("Error al ingresar la cantidad de puntos \n Por favor, intente nuevamente");
            scNum.nextLine();// scNum.nextLine() para evitar un recursividad infinita en caso de excepciones de entrada
            partidoTenis();
        }
        String[] puntosJugador = new String[puntos];

        for (int i = 0; i < puntosJugador.length; i++){
            System.out.println("Ingrese de quien fue el punto P1/P2");
            String puntoJugador = sc.nextLine();
            if(puntoJugador.equals("P1") || puntoJugador.equals("P2"))
                puntosJugador[i] = puntoJugador;
            else{
                System.out.println("Solo puede ingresar P1 o P2");
                i--;
            }
        }
        String[] valorPuntos = {"Love", "15", "30", "40"};
        int puntosP1 = 0, puntosP2 = 0;
        for (int i = 0; i < puntosJugador.length; i++){
            
            if(puntosJugador[i].equals("P1")){
                puntosP1 +=1;
            }else{
                puntosP2+=1;
            }

            if(puntosP1 < 3 || puntosP2 < 3){
                System.out.println(valorPuntos[puntosP1] + " - " + valorPuntos[puntosP2]);
            } else if ((puntosP1-puntosP2) == 2) {
                System.out.println("Gano el P1");
                break;
            } else if ((puntosP1-puntosP2) == -2) {
                System.out.println("Gano el P2");
                break;
            } else if ((puntosP1 >= 3 && puntosP2 >= 3) && puntosP1==puntosP2) {
                System.out.println("Deuce");
            }else if ((puntosP1-puntosP2) == 1) {
                System.out.println("Ventaja P1");
            }else if((puntosP1-puntosP2) == -1){
                System.out.println("Ventaja P2");
            }
        }
    }

    public static void lenguajeHacker(){
        /*
         * Escribe un programa que reciba un texto y transforme lenguaje natural a
         * "lenguaje hacker" (conocido realmente como "leet" o "1337"). Este lenguaje
         *  se caracteriza por sustituir caracteres alfanuméricos.
         * - Utiliza esta tabla (https://www.gamehouse.com/blog/leet-speak-cheat-sheet/)
         *   con el alfabeto y los números en "leet".
         *   (Usa la primera opción de cada transformación. Por ejemplo "4" para la "a")
         */
        HashMap<String, String > map = new HashMap();
        map.put("a","4");map.put("b", "I3");map.put("c","[");map.put("d",")");map.put("e","3");map.put("f","|=");map.put("g","&");map.put("h","#");
        map.put("i","1");map.put("j",",_|");map.put("k",">|");map.put("l","£");map.put("m","/\\/\\");map.put("n","^/");map.put("o","0");map.put("p","|*");
        map.put("q","(_,)");map.put("r","I2");map.put("s","5");map.put("t","7");map.put("u","(_)");map.put("v","\\/");map.put("w","\\/\\/");map.put("x","><");
        map.put("y","j");map.put("z","2");map.put("0","o");map.put("1","L");map.put("2","R");map.put("3","E");map.put("4","A");map.put("5","S");
        map.put("6","b");map.put("7","T");map.put("8","B");map.put("9","g");

        System.out.println("Ingrese el texto a traducir  sin caracteres especiales");
        String input = sc.nextLine().toLowerCase();
        String output = "";
        for (int i = 0; i < input.length(); i++){
            String valor = String.valueOf(input.toCharArray()[i]);
            if(map.containsKey(valor)){
                output += map.get(valor);
            }
            else{
                output += valor;
            }
        }
        System.out.println("La traduccion es: ");
        System.out.println(output);
    }

    public static void fizzbuzz() {
        /*
         * Escribe un programa que muestre por consola (con un print) los
         * números de 1 a 100 (ambos incluidos y con un salto de línea entre
         * cada impresión), sustituyendo los siguientes:
         * - Múltiplos de 3 por la palabra "fizz".
         * - Múltiplos de 5 por la palabra "buzz".
         * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
         */

        for (int i = 1; i <= 100; i++) {
            if(i % 3 == 0 && i % 5 == 0)
                System.out.println("fizzbuzz");
            else if(i % 3 == 0)
                System.out.println("fizz");
            else if(i % 5 == 0)
                System.out.println("buzz");
            else
                System.out.println(i);

        }
    }
}
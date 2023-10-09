/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptador;

/**
 *
 * @author Giuliano Espejo
 */
public class Modelo {

    private char[] abecedario = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] abecedario2 = new char[abecedario.length];

    public void crearAbecedario(String cantMove) throws Exception{
        int cantMov = Integer.parseInt(cantMove);
        for (int i = 0; i < 26; i++) {
            if (i + cantMov < 26) {
                abecedario2[i] = abecedario[i + cantMov];
            } else {
                abecedario2[i] = abecedario[(i + cantMov) - 25];
            }
        }
    }

    public String encriptar(String oracion) {
        StringBuilder result = new StringBuilder();
        char[] oracionChar = oracion.toLowerCase().toCharArray();
        for (char letra : oracionChar) {
            int index = buscarIndice(letra);
            if (index != -1) {
                result.append(abecedario2[index]);
            } else {
                result.append(letra); // Conservar caracteres que no estén en el abecedario
            }
        }
        return result.toString();
    }

// Método para buscar el índice de un carácter en el abecedario
    private int buscarIndice(char letra) {
        for (int i = 0; i < abecedario.length; i++) {
            if (abecedario[i] == letra) {
                return i;
            }
        }
        return -1; // Devolver -1 si no se encuentra la letra en el abecedario
    }

    public String desencriptar(String oracion) {
        StringBuilder resultado = new StringBuilder();
        char[] textoEncriptadoChar = oracion.toLowerCase().toCharArray();

        for (char letra : textoEncriptadoChar) {
            int indice = buscarIndice2(letra);
            if (indice != -1) {
                resultado.append(abecedario[indice]);
            } else {
                resultado.append(letra); // Conservar caracteres que no estén en el abecedario2
            }
        }

        return resultado.toString();
    }

// Método para buscar el índice de un carácter en el abecedario2
    private int buscarIndice2(char letra) {
        for (int i = 0; i < abecedario2.length; i++) {
            if (abecedario2[i] == letra) {
                return i;
            }
        }
        return -1; // Devolver -1 si no se encuentra la letra en el abecedario2
    }
}

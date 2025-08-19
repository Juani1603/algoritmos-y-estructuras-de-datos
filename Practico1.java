/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practico1;

/**
 *
 * @author Administrador
 */
public class Practico1 {

    public static void main(String[] args) {
        prEj8(6);
    }

    public static void prEj1() {
        for (int i = 1; i <= 49; i = i + 2) {
            System.out.println(i);
        }
    }

    public static void prEj2(int num1, int num2) {
        double promedio = (num1 + num2) / 2;
        System.out.println("Promedio:" + promedio);

        int numeroMayor;
        int numeroMenor;
        int cantPares = 0;

        if (num1 > num2) {
            numeroMayor = num1;
            numeroMenor = num2;
        } else {
            numeroMayor = num2;
            numeroMenor = num1;
        }
        for (int i = numeroMenor; i <= numeroMayor; i++) {
            if (i % 2 == 0) {
                cantPares++;
            }
        }
        System.out.println(cantPares);
    }

    public static void prEj3(int n) {
        int cantImpares = 0;
        int numeroImpar = 1;
        while (cantImpares < n) {
            cantImpares++;
            numeroImpar += 2;
            System.out.println(numeroImpar);
        }
    }

    public static void prEj4(int n) {
        while (n > 0) {
            int resto = n % 10;
            n = n / 10;
            System.out.println(resto);
        }
    }

    public static void prEj5(int n) {
        String numero = n + "";
        String numeroInvertido = "";

        for (int i = numero.length() - 1; i >= 0; i--) {
            numeroInvertido += numero.charAt(i);
        }
        System.out.print(numeroInvertido);
    }

    public static void prEj6(String palabra) {
        String palabraInvertida = "";
        boolean esPalindromo = false;

        for (int i = palabra.length() - 1; i >= 0; i--) {
            palabraInvertida += palabra.charAt(i);
        }
        if (palabra.equals(palabraInvertida)) {
            esPalindromo = true;
        }
        System.out.println(esPalindromo);
    }

    public static void prEj7(int n) {
        int cantFilas = 0;
        String asteriscos = "";
        while (cantFilas <= n) {
            cantFilas++;
            asteriscos += "*";
            System.out.println(asteriscos);
        }
    }

    public static void prEj8(int n) {
        int contador = 0;
        int primero = 0;
        int segundo = 1;

        while (contador <= n) {
            contador++;
            System.out.println(primero);
            int siguiente = primero + segundo;
            primero = segundo;
            segundo = siguiente;
        }
    }
}


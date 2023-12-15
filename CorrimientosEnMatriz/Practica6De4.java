import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practica6De4 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUMNAS = 10;

    public static void main(String[] args) {
        int[][] matrizDeEnteros = new int[MAXFILAS][MAXCOLUMNAS];
        cargarMatriz(matrizDeEnteros);
        System.out.println();
        cargarDato(matrizDeEnteros);
        publicarResultado(matrizDeEnteros);
    }

    public static void cargarMatriz(int[][] matrizDeEnteros) {
        System.out.println("La matriz original es:");
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                int numeroAleatorio = (int) (Math.random() * 10);
                matrizDeEnteros[fila][columna] = numeroAleatorio;
                System.out.print(matrizDeEnteros[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    public static void cargarDato(int[][] matrizDeEnteros) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ingrese un numero entero a cargar en la matriz: ");
            int entero = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese el numero de fila que va a modificar: ");
            int fila = Integer.valueOf(entrada.readLine());

            if (fila >= 0 && fila < MAXFILAS) {
                System.out.println("Indique el índice de la columna que desea modificar (de 0 a 9): ");
                int columna = Integer.valueOf(entrada.readLine());

                if (columna >= 0 && columna < MAXCOLUMNAS - 1) {
                    for (int pos = MAXCOLUMNAS - 1; pos > columna; pos--) {
                        matrizDeEnteros[fila][pos] = matrizDeEnteros[fila][pos - 1];
                    }
                    matrizDeEnteros[fila][columna] = entero;
                } else {
                    System.out.println("Índice de columna fuera de rango.");
                }
            } else {
                System.out.println("Fila fuera de rango.");
            }
        } catch (Exception e) {
            System.out.println("Error de entrada: " + e);
        }
    }

    public static void publicarResultado(int[][] matrizDeEnteros) {
        System.out.println("Nueva matriz es: ");
        for (int i = 0; i < MAXFILAS; i++) {
            for (int j = 0; j < MAXCOLUMNAS; j++) {
                System.out.print(matrizDeEnteros[i][j] + " ");
            }
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practica6De5 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUMNAS = 10;

    public static void main(String[] args) {
        int[][] matrizDeEnteros = new int[MAXFILAS][MAXCOLUMNAS];
        cargarMatriz(matrizDeEnteros);
        System.out.println();
        evaluarDato(matrizDeEnteros);
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

    public static void evaluarDato(int[][] matrizDeEnteros) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    
            System.out.println("Ingrese un numero entero a evaluar en la matriz: ");
            int entero = Integer.valueOf(entrada.readLine());
    
            for (int fila = 0; fila < MAXFILAS; fila++) {
                for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                    if (matrizDeEnteros[fila][columna] == entero) {
                        for (int i = columna; i < MAXCOLUMNAS - 1; i++) {
                            matrizDeEnteros[fila][i] = matrizDeEnteros[fila][i + 1];
                        }
                        matrizDeEnteros[fila][MAXCOLUMNAS - 1] = matrizDeEnteros[fila][MAXCOLUMNAS - 1];
                        break; // Salir del bucle después de eliminar la primera ocurrencia
                    }
                }
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






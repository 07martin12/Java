//15 min.
public class Practica6De2 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUMNAS = 10;

    public static void main(String[] args) {
        int[][] matrizDeEnteros = new int[MAXFILAS][MAXCOLUMNAS];
        cargarMatriz(matrizDeEnteros);
        System.out.println();
        elementosPares(matrizDeEnteros);
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

    public static void elementosPares(int[][] matrizDeEnteros) {
        System.out.println("Los elementos pares de la matriz son:");
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                if (matrizDeEnteros[fila][columna] % 2 == 0) {
                    System.out.print(matrizDeEnteros[fila][columna] + " ");
                }
            }
        }
    }
}

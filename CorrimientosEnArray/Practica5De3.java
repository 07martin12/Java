import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practica5De3 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int[] ArregloEnteros = new int[MAX];
        cargarArreglo(ArregloEnteros);
        EvaluarArreglo(ArregloEnteros);
        PublicarArreglo(ArregloEnteros);
    }

    public static void cargarArreglo(int[] ArregloEnteros) {
        System.out.println("El arreglo es: ");
        for (int pos = 0; pos < MAX; pos++) {
            int numeroAleatorio = (int) (Math.random() * MAX);
            ArregloEnteros[pos] = numeroAleatorio;
            System.out.print(ArregloEnteros[pos] + " ");
        }
        System.out.println();
    }

    public static void EvaluarArreglo(int[] ArregloEnteros) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insertar la posición del arreglo que desea modificar: ");
            int posicion = Integer.valueOf(entrada.readLine());

            if (posicion >= 0 && posicion < MAX - 1) {
                for (int pos = MAX - 1; pos > posicion; pos--) {
                    ArregloEnteros[pos] = ArregloEnteros[pos - 1];
                }
                
                System.out.println("Insertar el nuevo elemento: ");
                int nuevoElemento = Integer.valueOf(entrada.readLine());
                ArregloEnteros[posicion] = nuevoElemento;
            } else {
                System.out.println("Posición no válida. Debe estar entre 0 y " + (MAX - 2));
            }
        } catch (Exception exc) {
            System.out.println("Error de entrada: " + exc);
        }
    }

    public static void PublicarArreglo(int[] ArregloEnteros) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(ArregloEnteros[pos] + " ");
        }
    }
}

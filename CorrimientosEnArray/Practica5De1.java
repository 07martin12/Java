import java.io.BufferedReader; 
import java.io.InputStreamReader;

public class Practica5De1 {
    public static final int MAX = 10; 

    public static void main (String [] args) {
        int [] ArregloEnteros = new int [MAX];
        cargarArreglo(ArregloEnteros);
        EvaluarArreglo(ArregloEnteros);
    }

    public static void cargarArreglo (int [] ArregloEnteros) {
        System.out.println("El arreglo es: ");
        for (int pos = 0; pos<MAX; pos ++) {
            int numeroAleatorio = (int) (Math.random()*MAX);
            ArregloEnteros [pos] = numeroAleatorio;
            System.out.print(ArregloEnteros[pos] + " ");
        }   
        System.out.println();
    }

    public static void EvaluarArreglo (int [] ArregloEnteros) {
        try {
            BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Insertar la posición del arreglo que desea obtener: ");
            int posicion = Integer.valueOf(entrada.readLine());
            
            if (posicion>0 && posicion < MAX) {
                System.out.println("Posisicion encontrada en el indice: " + posicion + " para el elemento: " + ArregloEnteros[posicion]);
            } else {
                System.out.println("Posición no encontrada, intente nuevamente");
            }
        } catch (Exception exc) {
            System.out.println("Error de entrada: caracter incorrecto " + exc);
        }
    }
}






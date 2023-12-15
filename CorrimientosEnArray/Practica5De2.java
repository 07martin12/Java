public class Practica5De2 {
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
        System.out.println("Orden Invertido: ");
        for (int pos = MAX-1; pos>=0; pos--) {
            System.out.print(ArregloEnteros[pos] + " ");
        }
    }
}
    










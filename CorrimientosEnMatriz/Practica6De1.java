//30 min.
public class Practica6De1 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUMNAS = 10;

    public static void main (String [] args) {
        int [][] MatrizDeEnteros = new int [MAXFILAS] [MAXCOLUMNAS]; 
        CargarMatriz(MatrizDeEnteros);
        System.out.println();
        InvertirElementos(MatrizDeEnteros);
    }

    public static void CargarMatriz (int [][] MatrizDeEnteros ) {
            System.out.println("La matriz original es: "); 
        for (int fila = 0; fila<MAXFILAS; fila++) {
            for (int columna = 0; columna<MAXCOLUMNAS; columna++) { 
                int NumeroAleatorio = (int) (Math.random()*10);  
                MatrizDeEnteros[fila][columna] = NumeroAleatorio;
                System.out.print(MatrizDeEnteros[fila][columna] + " ");
            }
            System.out.println(); 
        }
        
    }

    public static void InvertirElementos(int[][] MatrizDeEnteros) {
        System.out.println("Matriz invertida:");
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = MAXCOLUMNAS - 1; columna >= 0; columna--) {
                System.out.print(MatrizDeEnteros[fila][columna] + " ");
            }
            System.out.println(); 
        }
    }
}

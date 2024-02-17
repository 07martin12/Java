package corrimientoDeDerecha;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Matriz4 {
	public static final int MAXFILAS = 5;
	public static final int MAXCOLUMNAS = 10;

	public static void main(String[] args) {
		int[][] Enteros = new int[MAXFILAS][MAXCOLUMNAS];
		int NumeroEntero = 0, PosFila = 0, PosColumna = 0;

		try {
			BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
			CargarEnteros(Enteros);
			System.out.println("La matriz original es: ");
			PublicarEnteros (Enteros);
			System.out.println ("Ingesar un numero entero: ");
			NumeroEntero = Integer.valueOf(entrada.readLine()); 
			System.out.println ("Ingesar la posicion de la fila que desea modificar: ");
			PosFila = Integer.valueOf(entrada.readLine());
			System.out.println ("Ingesar la posicion de la columna que desea modificar: ");
			PosColumna = Integer.valueOf(entrada.readLine());
			IngresarDatos (Enteros,NumeroEntero, PosFila, PosColumna);
			PublicarEnteros (Enteros);
		} catch (Exception exc) {
			System.out.println("Error de ejecución: " + exc);
			System.out.println ("Los valores númericos ingresados deben ser el tipo entero:");
		}
	}

	public static void CargarEnteros(int[][] mat) {
		int NumeroAleatorio = 0;
		
		for (int fil = 0; fil <MAXFILAS; fil++) {
			for (int colum = 0; colum <MAXCOLUMNAS; colum++) {
				NumeroAleatorio = (int) (Math.random () * 10);
				mat[fil][colum] = NumeroAleatorio;
			}
		}
	}
	
	public static void PublicarEnteros (int [] [] mat) {
		for (int fil = 0; fil <MAXFILAS; fil++) {
			for (int colum = 0; colum <MAXCOLUMNAS; colum++) {
				System.out.print (mat [fil] [colum] + " | ");
			}
			System.out.println ("");
		}
		System.out.println ("");
	}
	
	public static void IngresarDatos (int [][] matriz, int valor, int fila, int columna) {
		for (int fil = fila; fil <MAXFILAS; fil++) {
			for (int colum = MAXCOLUMNAS-1; colum >columna; colum--) {
				matriz [fil][colum] = matriz [fil][colum-1];
			}
	}
			matriz [fila][columna] = valor; 	
	}
}
	

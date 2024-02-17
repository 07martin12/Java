package corrimientoDeDerecha;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio9 {
public static final int MAX = 10;
public static void main (String [] arg) {
	int [] Enteros = new int [MAX];
	
	BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
	try {
		CargaAleatoria (Enteros);
		System.out.println ("\nIngresar un numero entero: ");
		int NumeroEntero = Integer.valueOf (entrada.readLine());
		IngresarElemento (Enteros, NumeroEntero);
		PublicarElemento (Enteros);
	} catch (Exception exc) {
		System.out.println ("Error de aplicación: " + exc);
	}
}

	public static void CargaAleatoria (int [] Enteros) {
		for (int i = 0; i<MAX; i++) {
			int NumeroAleatorio = (int) (Math.random ()*MAX);
			Enteros [i] = NumeroAleatorio;
			System.out.print(Enteros [i] + " | ");
		}
	}
	
	public static void IngresarElemento (int [] Enteros, int NumeroEntero) {
		for (int pos = MAX-1; pos>0; pos --) {
				Enteros [pos] = Enteros [pos-1]; 
				}
				Enteros [0] = NumeroEntero;
			}
		
	public static void PublicarElemento (int [] Enteros) {
		for (int j = 0; j<MAX; j++) {
			System.out.print(Enteros [j] + " | ");
		}
	}
}             
		

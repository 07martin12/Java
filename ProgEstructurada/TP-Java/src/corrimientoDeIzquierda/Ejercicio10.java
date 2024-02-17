package corrimientoDeIzquierda;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio10 {
	public static final int MAX = 10;

	public static void main(String[] args) {
		int[] ArregloDeEnteros = new int[MAX];
		int NumeroEntero = (char) 'a';

		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			CargarArregloDeEnteros(ArregloDeEnteros);
			System.out.println("");
			System.out.println("Ingresar un numero entero: ");
			NumeroEntero = Integer.valueOf(entrada.readLine());
			if (NumeroEntero != 'a') {
				EvaluarArregloDeEnteros(ArregloDeEnteros, NumeroEntero);
				ImprimirArregloDeEnteros(ArregloDeEnteros);
			}
		} catch (Exception exc) {
			System.out.println("Error de aplicación: " + exc);
		}
	}

	public static void CargarArregloDeEnteros(int[] ArregloDeEnteros) {
		for (int pos = 0; pos < MAX; pos++) {
			int NumeroAleatorio = (int) (Math.random() * MAX);
			ArregloDeEnteros[pos] = NumeroAleatorio;
			System.out.print(ArregloDeEnteros[pos] + " | ");
		}
	}

	public static void EvaluarArregloDeEnteros(int[] ArregloDeEnteros, int NumeroEntero) {
		Boolean Coincidencia = false; 
		
		for (int i = 0; i < MAX; i++) {
			if (ArregloDeEnteros[i] == NumeroEntero && Coincidencia == false) {
				for (int Copia = i; Copia<MAX-1;Copia++) { 
					ArregloDeEnteros[Copia] = ArregloDeEnteros[Copia + 1];
				}
				
			}
		}
	}

	public static void ImprimirArregloDeEnteros(int[] ArregloDeEnteros) {
		for (int j = 0; j < MAX; j++) {
			System.out.print(ArregloDeEnteros[j] + " | ");
		}
	}
}

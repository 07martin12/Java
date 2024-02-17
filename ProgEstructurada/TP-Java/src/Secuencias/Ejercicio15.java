package Secuencias;

public class Ejercicio15 {
	public static final int MAX = 20;
	public static final int SEP = 0;

	public static void main(String[] args) {
		int[] SecuenciaDeEnteros = new int[MAX];
		int FinDeSecuencia = 0, ComienzoDeSecuencia = 0;
		
		try {
			CargarSecuenciaDeEnteros(SecuenciaDeEnteros);
			ComienzoDeSecuencia = BuscarInicioDeSecuencia(SecuenciaDeEnteros);
			FinDeSecuencia = BuscarFinDeSecuencia(SecuenciaDeEnteros,ComienzoDeSecuencia);
			System.out.println("");
			System.out.println ("La posicion inicial de la primer secuencia de '0' es en: " + ComienzoDeSecuencia);		 
			System.out.println ("La posicion final de la primer secuencia de '0' es en: " + FinDeSecuencia);	
		} catch (Exception exc) {
			System.out.println("Error de aplicación: " + exc);
		}
	}

	public static void CargarSecuenciaDeEnteros(int SecuenciaDeEnteros[]) {
		for (int pos = 0; pos < MAX; pos++) {
			int NumeroAleatorio = (int) (Math.random() * 10);
			SecuenciaDeEnteros[pos] = NumeroAleatorio;
			System.out.print(SecuenciaDeEnteros[pos] + " | ");
		}
	}
	
	public static int BuscarInicioDeSecuencia (int SecuenciaDeEnteros []) {
		int PosicionInicial = 0;
		int Posicion = 0;
		for (int i = 0; i < MAX; i++) {
			if (SecuenciaDeEnteros[i] == SEP && Posicion != 1) {
				Posicion++;
				PosicionInicial= i;
			}
	}
		return PosicionInicial;
	}
	
	public static int BuscarFinDeSecuencia(int SecuenciaDeEnteros[], int ComienzoDeSecuencia) {
		int PosicionFinal = ComienzoDeSecuencia;
		
		while (PosicionFinal<MAX && SecuenciaDeEnteros[PosicionFinal+1] == SEP) {
			   PosicionFinal++;
		}
		
		return PosicionFinal;
	}
}

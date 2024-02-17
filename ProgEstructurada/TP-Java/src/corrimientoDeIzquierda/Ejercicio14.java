package corrimientoDeIzquierda;

public class Ejercicio14 {
	public static final int MAX = 10;
	
	public static void main(String[] args) {
		int [] Enteros = new int [MAX];
		
		try {
			CargaAleatoria (Enteros);
			System.out.println ("");
			EvaluarElemento (Enteros);
			ImprimirArregloDeEnteros (Enteros);
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
	
	public static void EvaluarElemento (int [] Enteros) {
		for (int pos = 0; pos<MAX; pos++ ) {
			if (Enteros[MAX-1]%2==0) {
				Enteros [MAX-1] = Enteros [MAX-2];
			}
			while (Enteros[pos]%2==0) {
				for (int par = pos; par<MAX-1;par++) {
					Enteros [par] = Enteros [par+1];	
				}	
			}
		}
	}
	
	public static void ImprimirArregloDeEnteros(int[] Enteros) {
		for (int j = 0; j < MAX; j++) {
			System.out.print(Enteros[j] + " | ");
		}
	}
}


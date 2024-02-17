package Secuencias;

public class Ejercicio16 {

	public static void main(String[] args) {
		int[] SecuenciaDeEnteros = { 1, 2, 3, 4, 0, 6, 7, 8, 9, 0, 8, 7, 6, 0, 4, 3, 2, 0 };
		int Resultados = 0;

		try {
			ImprimirSecuencia(SecuenciaDeEnteros);
			int ResultadoMayor = EvaluarSecuencia(SecuenciaDeEnteros, Resultados);
	
			int PosFinal = BuscarFinal (ResultadoMayor, SecuenciaDeEnteros, Resultados);
			int PosInicio = BuscarInicio (SecuenciaDeEnteros, PosFinal);
			
			System.out.println ("\nResultado Mayor: " + ResultadoMayor);
			System.out.println ("Posicion Inicial: " + PosInicio);
			System.out.println ("Posicion Final: " + PosFinal);
			
		} catch (Exception exc) {
			System.out.println("Error de aplicación: " + exc);
		}
	}

	public static void ImprimirSecuencia(int[] SecuenciaDeEnteros) {
		System.out.println("Secuencia de enteros\n");
		for (int pos = 0; pos < SecuenciaDeEnteros.length; pos++) {
			System.out.print(SecuenciaDeEnteros[pos] + " | ");
		}
	}

	public static int EvaluarSecuencia(int[] SecuenciaDeEnteros, int Resultados) {
	    int CantidadDeSecuencias = 0, Posicion = 0, ResultadoMayor = 0;

	    for (int pos = 0; pos < SecuenciaDeEnteros.length; pos++) {
	        if (SecuenciaDeEnteros[pos] == 0) {
	            CantidadDeSecuencias++;
	        }
	    }

	    int[] ResultadosDeSecuenciasSumadas = new int[CantidadDeSecuencias];

	    for (int pos = 0; pos < SecuenciaDeEnteros.length; pos++) {
	        if (SecuenciaDeEnteros[pos] == 0) {
	            Posicion++;
	            Resultados = 0;
	        } else {
	            Resultados += SecuenciaDeEnteros[pos];
	            ResultadosDeSecuenciasSumadas[Posicion] = Resultados;
	        }
	    }

	    for (int i = 0; i < ResultadosDeSecuenciasSumadas.length; i++) {
	        if (ResultadosDeSecuenciasSumadas[i] > ResultadoMayor) {
	            ResultadoMayor = ResultadosDeSecuenciasSumadas[i];
	        }
	    }

	    return ResultadoMayor;
	}


	public static int BuscarFinal (int ResultadoMayor, int [] SecuenciaDeEnteros, int Resultados) {
		int PosicionFinal = 0;
		boolean Coincidencia= false;
		 for (int j = 0; j < SecuenciaDeEnteros.length; j++) { 
			 if (SecuenciaDeEnteros[j] != 0 && Coincidencia != true) {
				 	Resultados += SecuenciaDeEnteros[j];
				 if (Resultados == ResultadoMayor) {
                	 PosicionFinal = j;         
                	 Coincidencia = true;
                 }	 
			 } else {
				 Resultados = 0;
			 }			
		 }
		 return PosicionFinal;
	}
	
	public static int BuscarInicio (int [] SecuenciaDeEnteros, int PosFinal) {
		int Inicio = PosFinal;
		boolean Coincidencia = false;
		 for (int j = PosFinal; j >0; j--) {
			 if (SecuenciaDeEnteros[j] != 0 && Coincidencia != true) {
				Inicio --;
			 } else {
				 Coincidencia = true;
			 }
		 }
		 
		 return Inicio;
	}
}


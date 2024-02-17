 package parciales;

public class PrimerParcial {
	public static final int SEP = 0;
	public static final int LimiteRep = 3;

	public static void main(String[] args) {
		int[] Pixeles = { 0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0 };

		int InicioDeSecuencia = 0, FinalDeSecuencia = 0;

		try {

			while (InicioDeSecuencia < Pixeles.length) {
				InicioDeSecuencia = BuscarInicio(Pixeles, FinalDeSecuencia);
				if (InicioDeSecuencia < Pixeles.length) {

					FinalDeSecuencia = BuscarFinal(Pixeles, InicioDeSecuencia);
					System.out.println("inicio de secuencia: " + InicioDeSecuencia + " final de secuencia: " + FinalDeSecuencia);
					
					if (EvaluarSecuencia(Pixeles, InicioDeSecuencia, FinalDeSecuencia)) {
						EliminarRepeticion(Pixeles, InicioDeSecuencia, FinalDeSecuencia);
						FinalDeSecuencia = InicioDeSecuencia;
					}
				}
			}
			MostrarArreglo(Pixeles);
		} catch (Exception exc) {
			System.out.println("Error de ejecución:" + exc);
		}
	}

	public static int BuscarInicio(int[] arr, int Inicio) {
		while (Inicio < arr.length && (arr[Inicio] == SEP)) {
			Inicio++;
		}
		return Inicio;
	}

	public static int BuscarFinal(int[] arr, int Final) {
		while (Final < arr.length && (arr[Final] != SEP)) {
			Final++;
		}
		return Final;
	}

	public static boolean EvaluarSecuencia(int[] arr, int Inicio, int Final) {
		boolean HayRepeticion = false;
		int Longitud = (Final - Inicio); int Repeticion = 1;

		while (Inicio < Final) {
			if (arr[Inicio] == arr[Inicio + 1]) {
				Repeticion++;
			}
			Inicio++;
		}

		if (Repeticion > LimiteRep) {
			if (Longitud == Repeticion) {
				HayRepeticion = true;
			}
		}

		return HayRepeticion;
	}

	public static void EliminarRepeticion(int[] arr, int Inicio, int Final) {
		int Longitud = Final - Inicio;
		arr[Inicio] = (-Longitud);

		for (int i = Inicio+2; i < Final; i++) {
			for (int j = Inicio+2; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
		}

	}

	public static void MostrarArreglo(int arr[]) {
		for (int pos = 0; pos < arr.length; pos++) {
			System.out.print(arr[pos] + " | ");
		}
	}
}
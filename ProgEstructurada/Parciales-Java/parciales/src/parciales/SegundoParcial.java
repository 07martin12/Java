package parciales;

public class SegundoParcial {
	public static final int MAXFILAS = 7;
	public static final int MAXCOLUMNA = 20;
	public static final int SEP = 0;
	public static final int PorcentajeMin = 50;

	public static void main(String[] args) {
		int[][] Running = { { 0, 300, 298, 298, 297, 0, 240, 233, 245, 240, 0, 257, 254, 254, 0, 234, 230, 222, 0, 0 },
				{ 0, 310, 302, 284, 271, 0, 280, 263, 263, 0, 0, 0, 264, 264, 0, 234, 230, 0, 0, 0 },
				{ 0, 310, 302, 294, 0, 0, 250, 243, 0, 245, 0, 257, 255, 253, 0, 234, 229, 0, 0, 0 },
				{ 0, 315, 320, 395, 398, 0, 351, 333, 353, 0, 0, 0, 334, 354, 0, 454, 490, 499, 0, 0 },
				{ 0, 410, 400, 397, 0, 0, 250, 243, 0, 0, 0, 257, 255, 253, 0, 234, 229, 220, 0, 0 },
				{ 0, 0, 420, 430, 430, 450, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 415, 425, 435, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int[] Dias = { 1, 2, 5, 0, 0, 0, 0 };

		int PosInicio = 0, PosFin = 0, PosFila = 0, DiasXEvaluar = 0, EntrenamientosCompletados = 0,
				KilometrosRecorridos = -1;

		try {
			DiasXEvaluar = BuscarDias(Dias);
			System.out.println("Los dias de entrenamiento progresivo fueron: ");
			PublicarResultados(Dias);

			while (PosFila < MAXFILAS) {
				while (PosInicio < MAXCOLUMNA) {
					KilometrosRecorridos++;
					PosInicio = BuscarInicio(Running, PosFin, PosFila);
					PosFin = BuscarFin(Running, PosInicio, PosFila);
					if (EntrenamientoCumplido(Running, PosInicio, PosFin, PosFila)) {
						EntrenamientosCompletados++;
					}
				}

				if (EntrenamientosCompletados == KilometrosRecorridos) {
					EliminarDiaCumplido(Dias, PosFila, EntrenamientosCompletados);
				}
					PosInicio = 0;
					PosFin = 0;
					EntrenamientosCompletados = 0;
					KilometrosRecorridos = -1;
					PosFila++;
			}

			System.out.println("Los dias de entrenamiento restantes fueron: ");
			PublicarResultados(Dias);

			EvaluarPorcentaje(Dias, DiasXEvaluar);
		} catch (Exception exc) {
			System.out.println("Error de ejecucion: " + exc);
		}

	}

	public static int BuscarDias(int[] Dias) {
		int DiasXEntrenar = 0;

		for (int pos = 0; pos < MAXFILAS; pos++) {
			if (Dias[pos] != SEP) {
				DiasXEntrenar++;
			}
		}
		return DiasXEntrenar;
	}

	public static int BuscarInicio(int[][] mat, int inicio, int fila) {
		while (inicio < MAXCOLUMNA && mat[fila][inicio] == SEP) {
			inicio++;
		}
		return inicio;
	}

	public static int BuscarFin(int[][] mat, int fin, int fila) {
		while (fin < MAXCOLUMNA && mat[fila][fin] != SEP) {
			fin++;
		}
		return fin;
	}

	public static boolean EntrenamientoCumplido(int[][] mat, int inicio, int fin, int fila) {
		boolean Cumplido = false;
		int Longitud = fin - inicio, Cumplimiento = 0;

		if (Longitud > 0) {
			while (inicio < fin) {
				if (mat[fila][inicio] >= mat[fila][inicio + 1]) {
					Cumplimiento++;
				}
				inicio++;
			}
			if (Longitud == Cumplimiento) {
				Cumplido = true;
			}
		}
		return Cumplido;
	}

	public static void EliminarDiaCumplido(int[] arr, int pos, int Dias) {
		int Dia = 0;

		Dia = arr[pos];
		if (Dia == pos + 1) {
			for (int j = pos; j < MAXFILAS-1; j++) {
				arr[j] = arr[j + 1];
			}
		}
	}

	public static void EvaluarPorcentaje(int[] arr, int DiasXEvaluar) {
		float PorcentajeCumplido = 0, DiasRestantes = 0;

		for (int pos = 0; pos < DiasXEvaluar; pos++) {
			if (arr[pos] != SEP) {
				DiasRestantes++;
			}
		}

		PorcentajeCumplido = (DiasRestantes / DiasXEvaluar) * 100;

		if (PorcentajeCumplido >= PorcentajeMin) {
			System.out
					.println("El porcentaje fue superior al: " + PorcentajeMin + " siendo del: " + PorcentajeCumplido);
		} else {
			System.out.println(
					"El porcentaje no fue superior al: " + PorcentajeMin + " siendo del: " + PorcentajeCumplido);
		}
	}

	public static void PublicarResultados(int[] arr) {
		for (int pos = 0; pos < MAXFILAS; pos++) {
			System.out.print(arr[pos] + " | ");
		}
		System.out.println(" ");
	}

}

package prefinal;

public class TercerEvaluacion {
	public static final char SEP = ' ';
	public static final int MAX_FILAS = 4;
	public static final int MAX_COLUMNAS = 16;

	public static void main(String[] args) {
		char[][] matrizChar = { { ' ', 'e', 'l', ' ', 'a', 'g', 'e', 'n', 't', 'e', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', 'J', 'a', 'm', 'e', 's', ' ', 'B', 'o', ' ', 's', 'e', ' ', ' ', ' ', ' ' },
				{ ' ', 'e', 'n', 'c', 'u', 'e', 'n', 't', 'r', 'a', ' ', 'e', 'n', ' ', ' ', ' ' },
				{ ' ', 'C', 'o', 'l', 'o', 'n', 'i', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };

		int PosInicio = 0, PosFin = 0, PosFila = 0, Encriptaciones = 0;

		try {
			System.out.println("Matriz original: ");
			PublicarMatriz(matrizChar);
			
			while (PosFila < MAX_FILAS) {
				while (PosInicio < MAX_COLUMNAS) {
					PosInicio = BuscarInicio(matrizChar, PosFin, PosFila);

					if (PosInicio < MAX_COLUMNAS) {
						PosFin = BuscarFin(matrizChar, PosInicio, PosFila);
						
						if (EsMayuscula(matrizChar, PosInicio, PosFila)) {
							InvertirSecuencia(matrizChar, PosInicio, PosFin - 1, PosFila);
							EvaluarSecuencia(matrizChar, PosInicio, PosFin, PosFila);

							Encriptaciones++;
						}
					}
				}

				PosInicio = 0;
				PosFin = 0;
				PosFila++;

			}

			System.out.println("La matriz encriptada es: ");
			PublicarMatriz(matrizChar);
			System.out.println("La cantidad de encriptaciones es de: " + Encriptaciones);

		} catch (Exception exc) {
			System.out.println("Error de ejecucion: " + exc);
		}
	}

	public static int BuscarInicio(char[][] mat, int PosInicio, int PosFila) {
		while (PosInicio < MAX_COLUMNAS && mat[PosFila][PosInicio] == SEP) {
			PosInicio++;
		}
		return PosInicio;
	}

	public static int BuscarFin(char[][] mat, int PosFin, int PosFila) {
		while (PosFin < MAX_COLUMNAS && mat[PosFila][PosFin] != SEP) {
			PosFin++;
		}
		return PosFin;
	}

	public static boolean EsMayuscula(char[][] mat, int PosInicio, int PosFila) {
		boolean HayMayuscula = false;

		if (mat[PosFila][PosInicio] >= 'A' && mat[PosFila][PosInicio] <= 'Z') {
			HayMayuscula = true;
		}

		return HayMayuscula;
	}

	public static void EvaluarSecuencia(char[][] mat, int PosInicio, int PosFin, int PosFila) {
		int Pos = 0;

		while (PosInicio < PosFin) {
		
			if (EvaluarElemento(mat, PosInicio, PosFila)) {
				Pos = PosInicio;
				DuplicarElemento(mat, Pos, PosFila);

				PosInicio = PosInicio + 2;
			}
			PosInicio++;

		}
	}

	public static boolean EvaluarElemento(char[][] mat, int PosInicio, int PosFila) {
		char[] Vocales = { 'a', 'e', 'i', 'o', 'u' };
		boolean ElementoCorrecto = false;
		int pos = 0;

		while (pos < Vocales.length && ElementoCorrecto != true) {
			if (mat[PosFila][PosInicio] == Vocales[pos]) {
				ElementoCorrecto = true;
			}
			pos++;
		}

		return ElementoCorrecto;
	}

	public static void DuplicarElemento(char[][] mat, int Pos, int PosFila) {

		for (int i = MAX_COLUMNAS - 1; i > Pos; i--) {
			mat[PosFila][i] = mat[PosFila][i - 1];
		}

	}

	public static void InvertirSecuencia(char[][] mat, int PosInicio, int PosFin, int PosFila) {
		char elemento = ' ';

		while (PosInicio < PosFin) {
			elemento = mat[PosFila][PosInicio];
			mat[PosFila][PosInicio] = mat[PosFila][PosFin];
			mat[PosFila][PosFin] = elemento;
			PosInicio++;
			PosFin--;

		}
	}

	public static void PublicarMatriz(char[][] mat) {
		for (int i = 0; i < MAX_FILAS; i++) {
			for (int j = 0; j < MAX_COLUMNAS; j++) {
				System.out.print(mat[i][j] + " | ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

}

package Secuencias;

public class matriz11 {
	public static final int MAXFILAS = 4;
	public static final int MAXCOLUMNAS = 20;
	public static final int SEPINT = 0;

	public static void main(String[] args) {
		int[][] Enteros = new int[MAXFILAS][MAXCOLUMNAS];
		int[][] Sumas = new int[MAXFILAS][MAXCOLUMNAS];

		int PosInicio = 0, PosFin = 0, NumFila = 0;

		try {
			CargarSecuencias(Enteros);
			System.out.println("Las secuencias originales son: ");
			PublicarSecuencias(Enteros);

			while (NumFila < MAXFILAS) {
				if (NumFila < MAXFILAS) {
					while (PosInicio < MAXCOLUMNAS) {
						PosInicio = BuscarInicio(Enteros, PosFin, NumFila);
						if (PosInicio < MAXCOLUMNAS) {
							PosFin = BuscarFinal(Enteros, PosInicio, NumFila);
							SumarElementos(Sumas, Enteros, PosInicio, PosFin, NumFila);
						}
					}
					NumFila++;
					PosInicio = 0;
					PosFin = 0;
				}
			}

			System.out.println("El valor mas alto de la secuencia cuya suma de valores es la mas alta es: ");
			EvaluarSumas(Sumas);
			PublicarSumas(Sumas);

		} catch (Exception exc) {
			System.out.println("Error de ejecución: " + exc);
		}
	}

	public static void CargarSecuencias(int[][] matInt) {
		int NumeroAleatorio = 0;
		int ElementosXSecuencia = 5;
		for (int fil = 0; fil < MAXFILAS; fil++) {
			matInt[fil][0] = SEPINT;
			
			for (int colum = 1; colum < MAXCOLUMNAS - 1; colum++) {
				if (colum % ElementosXSecuencia == 0) {
					matInt[fil][colum] = SEPINT;
				} else {
					NumeroAleatorio = (int) (Math.random() * 9) + 1;
					matInt[fil][colum] = NumeroAleatorio;
				}
			}
		}
	}

	public static void PublicarSecuencias(int[][] matInt) {
		System.out.println("Matriz de enteros: ");
		for (int fil = 0; fil < MAXFILAS; fil++) {
			for (int colum = 0; colum < MAXCOLUMNAS; colum++) {
				System.out.print(matInt[fil][colum] + " | ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static int BuscarInicio(int[][] mat, int inicio, int NumFila) {
		while (inicio < MAXCOLUMNAS && (mat[NumFila][inicio] == SEPINT)) {
			if (mat[NumFila][inicio] == SEPINT) {
				inicio++;
			}
		}
		return inicio;
	}

	public static int BuscarFinal(int[][] mat, int fin, int NumFila) {
		while (fin < MAXCOLUMNAS && (mat[NumFila][fin] != SEPINT)) {
			if (mat[NumFila][fin] != SEPINT) {
				fin++;
			}
		}
		return fin;
	}

	public static void SumarElementos(int[][] arrSuma, int[][] matEnteros, int inicioColumna, int finColumna,
			int NumFila) {

		for (int i = inicioColumna; i < finColumna; i++) {
			if (matEnteros[NumFila][i] != SEPINT) {
				arrSuma[NumFila][inicioColumna] += matEnteros[NumFila][i];
			}
		}
	}

	public static void EvaluarSumas(int[][] arrSuma) {
		int Valor = 0, Secuencia = 0, Fila = 0;

		for (int posfil = 0; posfil < MAXFILAS; posfil++) {
			for (int poscol = 0; poscol < MAXCOLUMNAS; poscol++) {
				if (Valor < arrSuma[posfil][poscol]) {
					Valor = arrSuma[posfil][poscol];
					Fila = posfil;		
					Secuencia++;
				}
			}
		}
		System.out.println(Valor + " para la secuencia n.°: " + Secuencia + " de la fila: " + Fila);
	}

	public static void PublicarSumas(int[][] arrSuma) {
		for (int fil = 0; fil < MAXFILAS; fil++) {
			for (int colum = 0; colum < MAXCOLUMNAS; colum++) {
				System.out.print(arrSuma[fil][colum] + " | ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}

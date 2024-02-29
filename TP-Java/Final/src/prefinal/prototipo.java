package prefinal;

public class prototipo {
	public static char SEP = ' ';
	public static int MAXFILAS = 5;
	public static int MAXCOLUMNAS = 20; 
	public static int VALORMAXIMO = 'F';
	public static int COINCIDENCIAS = 2; 
	
	public static void main (String [] args) {
		char[][] matriz = {
			    {' ', '1', '2', 'F', 'H', ' ', '2', 'A', '3', ' ', '3', 'R', 'B', 'J', ' ', '6', '5', 'K', ' ', ' '},
			    {' ', ' ', '2', '1', '4', '5', ' ', 'R', 'P', ' ', 'D', '3', ' ', '7', 'M', 'N', 'W', ' ', ' ', ' '},
			    {' ', '4', 'G', '8', ' ', '3', '5', '7', '1', ' ', ' ', '2', 'X', ' ', 'D', '4', '1', ' ', ' ', ' '},
			    {' ', ' ', ' ', '5', 'T', 'T', 'M', ' ', 'A', 'P', '1', '1', ' ', '2', '1', '3', ' ', '1', '3', ' '},
			    {' ', '6', '6', '4', ' ', '5', '4', ' ', ' ', 'A', '2', '1', '2', ' ', 'G', '4', '2', '1', '8', ' '}
			};

		int PosInicio = 0, PosFin = 0, PosFila = 0, SeñalEncontrada = 0, SeñalExtreterrestre = 0;

	
		try {
			System.out.println("Matriz original: ");
			PublicarMatriz(matriz);
			
			while (PosFila < MAXFILAS) {
				while (PosInicio < MAXCOLUMNAS) {
					PosInicio = BuscarInicio(matriz, PosFin, PosFila);

					if (PosInicio < MAXCOLUMNAS) {
						PosFin = BuscarFin(matriz, PosInicio, PosFila);
						
						if (EvaluarSecuencia(matriz, PosInicio, PosFin, PosFila)) {
							 SeñalEncontrada++;
						    if (EvaluarCoincidencia (SeñalEncontrada)) { 		
						    	System.out.println(EvaluarSecuencia(matriz, PosInicio, PosFin, PosFila));						
						    	SeñalExtreterrestre++;
						    }
						}
					}
				}

				PosInicio = 0;
				PosFin = 0;
				PosFila++;
				SeñalEncontrada = 0;
			}
				System.out.println("Se encontraron: " + SeñalExtreterrestre + " Señales extreterrestres");
			
		} catch (Exception exc) {
			System.out.println("Error de ejecucion: " + exc);
		}
	}

	public static int BuscarInicio(char[][] mat, int PosInicio, int PosFila) {
		while (PosInicio < MAXCOLUMNAS && mat[PosFila][PosInicio] == SEP) {
			PosInicio++;
		}
		return PosInicio;
	}

	public static int BuscarFin(char[][] mat, int PosFin, int PosFila) {
		while (PosFin < MAXCOLUMNAS && mat[PosFila][PosFin] != SEP) {
			PosFin++;
		}
		return PosFin;
	}

	public static boolean EvaluarSecuencia(char[][] matriz, int inicio, int fin, int fila) {
		char elemento = ' ';
		int sumarElementos = 0, ValorMaximo = (int) VALORMAXIMO; 
		boolean ValorExcedido = false;

		while (inicio < fin) {
			if (matriz[fila][inicio] >= '1' && matriz[fila][inicio] <= '9') {
				elemento = matriz[fila][inicio];
				sumarElementos += (int) elemento-'0';
			} else if (matriz[fila][inicio] >= 'A' && matriz[fila][inicio] <= 'Z') {
				elemento = matriz[fila][inicio];
				sumarElementos += (int) elemento-'A';
				sumarElementos = sumarElementos+10; 
			}
			inicio++;
		}
		
		
		
		if (sumarElementos > ValorMaximo) {
			ValorExcedido = true;
		}
		
		return ValorExcedido;
	}
	
	public static boolean EvaluarCoincidencia (int coincidenciasEncotradas) {
		boolean HayCoincidencia = false;
		
		if (coincidenciasEncotradas == COINCIDENCIAS) {
		    HayCoincidencia = true;
		}
		
		return HayCoincidencia;
	}
	
	public static void PublicarMatriz(char[][] mat) {
		for (int i = 0; i < MAXFILAS; i++) {
			for (int j = 0; j < MAXCOLUMNAS; j++) {
				System.out.print(mat[i][j] + " | ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}

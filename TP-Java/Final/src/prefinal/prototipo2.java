package prefinal;

public class prototipo2 {
	public static final char SEP = ' ';
	public static final int MAXFILAS = 4;
	public static final int MAXCOLUMNAS = 16;

	public static void main(String[] args) {
		char[][] matriz = { { ' ', 'e', 'l', ' ', 'a', 'g', 'e', 'n', 't', 'e', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', 'j', 'a', 'm', 'e', 's', ' ', 'b', 'o', ' ', 's', 'e', ' ', ' ', ' ', ' ' },
				{ ' ', 'e', 'n', 'c', 'u', 'e', 'n', 't', 'r', 'a', ' ', 'e', 'n', ' ', ' ', ' ' },
				{ ' ', 'c', 'o', 'l', 'o', 'n', 'i', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };
		char[] arregloR = { 'F', 'C', 'J', 'P', 'D' };

		int posinicio = 0, posfin = 0, posfila = 0, secuenciasencriptadas = 0;

		try {
			publicarMatriz(matriz);
			while (posfila < MAXFILAS) {
				while (posinicio < MAXCOLUMNAS) {
					posinicio = buscarInicio(matriz, posfin, posfila);
					if (posinicio < MAXCOLUMNAS) {
						posfin = buscarFin(matriz, posinicio, posfila);
						evaluarSecuencia(matriz, arregloR, posinicio, posfin, posfila, secuenciasencriptadas);
						secuenciasencriptadas += encriptaciones(secuenciasencriptadas);
					}
				}
				posinicio = 0;
				posfin = 0;
				posfila++;
			}
			System.out.println("La cantidad de encriptaciones fue de: " + secuenciasencriptadas);
			publicarMatriz(matriz);
		} catch (Exception exc) {
			System.out.println("Error de ejecución: " + exc);
		}
	}

	public static int buscarInicio(char[][] matriz, int inicio, int fila) {
		while (inicio < MAXCOLUMNAS && matriz[fila][inicio] == SEP) {
			inicio++;
		}
		return inicio;
	}

	public static int buscarFin(char[][] matriz, int fin, int fila) {
		while (fin < MAXCOLUMNAS && matriz[fila][fin] != SEP) {
			fin++;
		}
		return fin;
	}

	public static void evaluarSecuencia(char[][] matriz, char[] arreglo, int inicio, int fin, int fila,
			int secuencias) {
		int pos = inicio;
		
		while (inicio < fin) {
			if (buscarVocal(matriz, inicio, fila)) {
				reemplazarSecuencia(matriz, arreglo, inicio, fila);
				encriptaciones(secuencias + 1);
			}
			inicio++;
		}
		invertirSecuencia(matriz, pos, fin - 1, fila);
	}

	public static boolean buscarVocal(char[][] matriz, int inicio, int fila) {
		switch (matriz[fila][inicio]) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
		}
	}

	public static void reemplazarSecuencia(char[][] matriz, char[] arreglo, int inicio, int fila) {
		switch (matriz[fila][inicio]) {
		case 'a':
			matriz[fila][inicio] = arreglo[0];
			break;
		case 'e':
			matriz[fila][inicio] = arreglo[1];
			break;
		case 'i':
			matriz[fila][inicio] = arreglo[2];
			break;
		case 'o':
			matriz[fila][inicio] = arreglo[3];
			break;
		case 'u':
			matriz[fila][inicio] = arreglo[4];
			break;
		}
	}

	public static void invertirSecuencia(char[][] matriz, int inicio, int fin, int fila) {
		char elemento;

		while (inicio <= fin) {
			elemento = matriz[fila][inicio];
			matriz[fila][inicio] = matriz[fila][fin];
			matriz[fila][fin] = elemento;
			inicio++;
			fin--;
		}
	}

	public static void publicarMatriz(char[][] matriz) {
		for (int i = 0; i < MAXFILAS; i++) {
			for (int j = 0; j < MAXCOLUMNAS; j++) {
				System.out.print(matriz[i][j] + " | ");
			}
			System.out.println();
		}
	}

	public static int encriptaciones(int secuencias) {
		// Aquí deberías poner la lógica de encriptaciones, no está definida en tu
		// código.
		// Solo devuelve el valor actual para evitar errores de compilación.
		return secuencias;
	}
}

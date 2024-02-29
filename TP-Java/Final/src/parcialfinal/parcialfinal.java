package parcialfinal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class parcialfinal {
	public static final int MAXFILAS = 3;
	public static final int MAXCOLUMNAS = 20;
	public static final int SEP = 0;

	public static void main(String[] args) {
		int[][] Biblioteca = { { 0, 12, 15, -18, 0, 5, -55, 63, 88, 0, 0, -74, 99, 0, 0, 11, 25, 64, 0, 0 },
				{ 0, 0, 2, -6, 52, 0, 0, -85, 87, 89, 0, 0, 1, 10, 20, -30, 0, 0, 0, 0 },
				{ 0, 8, -23, 24, 33, 84, -98, 0, 0, 21, 22, -34, 36, 44, 0, 4, 13, 26, 0, 0 } };
		
		int[] Tematica = { 'A', 'C', 'T' };
		
		int TipoTematica = 0, NumEstanteria = 0, CodigoLibro = 0, ModificarLibro = 0, LibroPrestado = 0;

		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingresar la tematica del libro:\n(0)para acción\n(1)para ciencia ficción\n(2)para terror");
			TipoTematica = Integer.valueOf(entrada.readLine());

			if (TipoTematica >= SEP && TipoTematica <= Tematica.length) {
				System.out.println("Ingresar el numero de estanteria del libro:");
				NumEstanteria = Integer.valueOf(entrada.readLine());

				if (EstanteriaCorrecta(Biblioteca, TipoTematica, NumEstanteria)) {
					System.out.println("Ingresar el codigo del libro:");
					CodigoLibro = Integer.valueOf(entrada.readLine());

					if (CodigoLibro > SEP) {
						System.out.println("(0) para eliminar\n(1) para registrar");
						ModificarLibro = Integer.valueOf(entrada.readLine());

						switch (ModificarLibro) {
						case 0:
							if (LibroExistente(Biblioteca, CodigoLibro)) {
								EliminarLibro(Biblioteca, TipoTematica, NumEstanteria, CodigoLibro);
								System.out.println("Libro eliminado con exito");
								PublicarMatriz(Biblioteca);
							} else {
								System.out.println("Libro a eliminar actualmente esta siendo prestado");
							}
							break;
						case 1:
							if (!LibroExistente(Biblioteca, CodigoLibro)) {
								RegistrarLibro(Biblioteca, TipoTematica, NumEstanteria, CodigoLibro);
								System.out.println("Libro registrado con exito");
								PublicarMatriz(Biblioteca);
							} else {
								System.out.println("Libro a registrar ya existe");
							}
							break;
						default:
							System.out.println("Opcion incorrecta");
							break;
						}
					} else {
						System.out.println("El codigo del libro debe ser mayor a cero");
					}
				} else {
					System.out.println(
							"el numero de estanteria es menor a cero o supera el limite de estanterias para la tematica");
				}
			} else {
				System.out.println(
						"El numero del la tematica es menor a cero o supra el limite de tematicas disponibles");
			}

			EvaluarEstanteria(Biblioteca, LibroPrestado);
		} catch (Exception exc) {
			System.out.println("Error de ejecución: " + exc);
		}
	}

	public static boolean EstanteriaCorrecta(int[][] mat, int fila, int secuencia) {
		boolean SecuenciaEncontrada = false;

		int secuenciasEncontradas = 0, inicio = 0, fin = 0;

		while (inicio < MAXCOLUMNAS) {
			inicio = BuscarInicio(mat, fin, fila);
			if (inicio < MAXCOLUMNAS) {
				fin = BuscarFin(mat, inicio, fila);
				secuenciasEncontradas++;
			}
		}

		if (secuencia <= secuenciasEncontradas) {
			SecuenciaEncontrada = true;
		}

		return SecuenciaEncontrada;
	}

	public static int BuscarInicio(int[][] mat, int PosInicio, int PosFila) {
		while (PosInicio < MAXCOLUMNAS && mat[PosFila][PosInicio] == SEP) {
			PosInicio++;
		}
		return PosInicio;
	}

	public static int BuscarFin(int[][] mat, int PosFin, int PosFila) {
		while (PosFin < MAXCOLUMNAS && mat[PosFila][PosFin] != SEP) {
			PosFin++;
		}
		return PosFin;
	}

	public static boolean LibroExistente(int[][] mat, int libro) {
		boolean LibroExiste = false;
		int elemento = 0;

		for (int i = 0; i < MAXFILAS; i++) {
			for (int j = 0; j < MAXCOLUMNAS; j++) {
				elemento = mat[i][j];

				if (elemento < 0) {
					elemento = elemento * (-1);
				}
				if (libro == elemento) {
					LibroExiste = true;
				}
				elemento = 0;
			}
		}

		return LibroExiste;
	}

	public static void RegistrarLibro(int[][] mat, int fila, int secuencia, int libro) {
		int inicio = 0, fin = 0;

		while (inicio < MAXCOLUMNAS && secuencia != 0) {
			inicio = BuscarInicio(mat, fin, fila);
			if (inicio < MAXCOLUMNAS) {
				fin = BuscarFin(mat, inicio, fila);
				secuencia--;
			}
		}

		for (int i = MAXCOLUMNAS - 1; i > fin; i--) {
			mat[fila][i] = mat[fila][i - 1];
		}

		mat[fila][fin - 1] = libro;

		OrdenarEstanteria(mat, fila, inicio, fin);
	}

	public static void EliminarLibro(int[][] mat, int fila, int secuencia, int libro) {

		int inicio = 0, fin = 0, pos = 0, el = 0;

		while (inicio < MAXCOLUMNAS && secuencia != 0) {
			inicio = BuscarInicio(mat, fin, fila);
			if (inicio < MAXCOLUMNAS) {
				fin = BuscarFin(mat, inicio, fila);
				secuencia--;
			}
		}
		
		for (int i = inicio; i < fin; i++) {
			el = mat[fila][i];
			if (libro == el)
			 pos = i;
		}
		
		System.out.println ("el" + el + "y" + libro);
		
		for (int j = pos; j < MAXCOLUMNAS-1; j++) {
			mat[fila][j] = mat[fila][j + 1];
		}


	//	OrdenarEstanteria(mat, fila, inicio, fin);

	}

	public static void OrdenarEstanteria(int[][] mat, int fila, int inicio, int fin) {
		int libro = 0, libroPrestado = 0, codigoMenor = 0;

		for (int Pos = inicio; Pos < fin; Pos++) {
			libro = mat[fila][Pos];

			if (libro < 0) {
				libroPrestado = libro;
				libro = libro * (-1);
			}

			if (libro > mat[fila][Pos + 1]) {
				codigoMenor = mat[fila][Pos + 1];

				if (libroPrestado > 0) {

					mat[fila][Pos + 1] = libroPrestado;
					libroPrestado = 0;
				} else {
					mat[fila][Pos + 1] = libro;
				}

				mat[fila][Pos] = codigoMenor;
			}
		}
	}

	public static void PublicarMatriz(int[][] mat) {
		for (int i = 0; i < MAXFILAS; i++) {
			for (int j = 0; j < MAXCOLUMNAS; j++) {
				System.out.print(mat[i][j] + " | ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void EvaluarEstanteria(int[][] mat, int libroprestado) {

	}

}

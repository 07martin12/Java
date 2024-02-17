package parciales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CuartoParcial {
	public static final int MAXFILAS = 3;
	public static final int MAXCOLUMNAS = 20;
	public static final int SEP = 0;

	public static void main(String[] args) {
		int[][] Babel = { { 0, 12, 15, -18, 0, 5, -55, 63, 88, 0, 0, -74, -99, 0, 0, 11, 25, 64, 0, 0 },
				{ 0, 0, 2, -6, 52, 0, 0, -85, 87, 89, 0, 0, 1, 10, 20, -30, 0, 0, 0, 0 },
				{ 0, 8, -23, 24, 33, 84, -98, 0, 0, 21, 22, -34, -36, -44, 0, 4, 13, 26, 0, 0 } };

		char[] Tematica = { 'A', 'C', 'T' };

		int TematicaElegida = 0, Estanteria = 0, Libro = 0, PosInicio = 0, PosFin = 0, Secuencias = 0,
				ModificarLibro = 0;

		boolean DatosCorrectos = false;

		try {
			InformarPrestaciones(Babel);

			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

			while (DatosCorrectos != true) {
				System.out.println("Tematicas:\nOpcion (1): Accion\nOpcion (2): Ciencia Ficcion\nOpcion (3): Terror");
				TematicaElegida = Integer.valueOf(entrada.readLine());

				if (TematicaElegida <= Tematica.length) {
					System.out.println("Ingrese el numero de estanteria: ");
					Estanteria = Integer.valueOf(entrada.readLine());

					while (PosInicio < MAXCOLUMNAS) {
						PosInicio = BuscarInicio(Babel, TematicaElegida, PosFin);
						PosFin = BuscarFin(Babel, TematicaElegida, PosInicio);
						Secuencias++;
					}
					PosInicio = 0;
					PosFin = 0;

					if (Estanteria <= Secuencias) {
						System.out.println("Ingrese el numero del libro: ");
						Libro = Integer.valueOf(entrada.readLine());

						if (Libro > 0) {
							while (PosInicio < MAXCOLUMNAS || Estanteria == 0) {
								PosInicio = BuscarInicio(Babel, TematicaElegida, PosFin);
								PosFin = BuscarFin(Babel, TematicaElegida, PosInicio);
								Estanteria--;
							}

							System.out.println("¿Desea eliminar el libro o registrarlo?\nOpcion (1) Registrar\nOpcion (0) Eliminar");
							ModificarLibro = Integer.valueOf(entrada.readLine());

							if (ModificarLibro == 0) {
								if (!LibroCorrecto(Babel, Libro)) {
									EliminarLibro(Babel, PosInicio, TematicaElegida, Libro);
									DatosCorrectos = true;
									
								} else {
									System.out.println("El libro no se puede eliminar porque esta siendo utilizado");
								}
							} else if (ModificarLibro == 1) {
								if (!LibroExistente(Babel, Libro)) {
									RegistrarLibro(Babel, PosFin, TematicaElegida, Libro);
									DatosCorrectos = true;
								} else {
									System.out.println("El libro ya existe en la bibliteca");
								}
							} else {
								System.out.println("Opcion incorrecta");
							}
						} else {
							System.out.println("Numero de libro invalido");
						}

					} else {
						System.out.println("Numero de estanteria incorrecto");
					}
				} else {
					System.out.println("Numero de tematica incorrecto");
				}
			}
			PublicarResultado (Babel);
		} catch (Exception exc) {
			System.out.println("Error de ejecucion: " + exc);
		}

	}

	public static void InformarPrestaciones(int[][] mat) {
		int LibroPrestado = 0, MayorPrestacion = 0, Fila = 0;

		for (int i = 0; i < MAXFILAS; i++) {
			for (int j = 0; j < MAXCOLUMNAS; j++) {
				if (mat[i][j] < 0) {
					LibroPrestado++;
				}
			}

			if (LibroPrestado > MayorPrestacion) {
				MayorPrestacion = LibroPrestado;
				Fila = i;
			}
			LibroPrestado = 0;
		}

		System.out.println("La mayor cantidad de libros prestados fue de: " + MayorPrestacion
				+ " para la tematica N.°: " + (Fila + 1));
	}

	public static int BuscarInicio(int[][] mat, int fila, int inicio) {
		while (inicio < MAXCOLUMNAS && mat[fila][inicio] == SEP) {
			inicio++;
		}
		return inicio;
	}

	public static int BuscarFin(int[][] mat, int fila, int fin) {
		while (fin < MAXCOLUMNAS && mat[fila][fin] != SEP) {
			fin++;
		}
		return fin;
	}

	public static boolean LibroExistente(int[][] mat, int Libro) {
		boolean LibroExiste = false;
		int Elemento = 0;
		
		for (int i = 0; i <MAXFILAS; i++) {
			for (int j = 0; j <MAXCOLUMNAS; j++) {
				Elemento = mat [i] [j];
				if (Elemento == Libro) {
					LibroExiste = true;
				}
			}
		}
		return LibroExiste;
	}
	
	public static boolean LibroCorrecto (int [] [] mat, int Libro) { 
		boolean LibroExiste = false;
		Libro = Libro-Libro*2;
		
		if (LibroExistente (mat, Libro)) {
			LibroExiste = true;
		}
		return LibroExiste;
	}
	
	public static void RegistrarLibro (int [] [] mat, int Fin, int Fila, int Elemento) {
		for (int Pos = MAXCOLUMNAS-1; Pos>Fin; Pos--) {
			mat [Fila] [Pos] = mat [Fila] [Pos-1];  
		}
		mat [Fila] [Fin] = Elemento;
	}
	
	public static void EliminarLibro (int [] [] mat, int Inicio, int Fila, int Elemento) {
		for (int Pos = Inicio; Pos<MAXCOLUMNAS-1; Pos++) {
			mat [Fila] [Pos] = mat [Fila] [Pos+1];  
		}
	}
	
	public static void PublicarResultado (int [] [] mat) {
		for (int i = 0; i<MAXFILAS; i++) {
			for (int j = 0; j<MAXCOLUMNAS; j++) {
				System.out.print (mat [i] [j]+ " | ");
			}
			System.out.println ("");
		}
	}
}



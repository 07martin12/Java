package parcialfinal;

public class izquierda {

	public static void main(String[] args) {
		int [] arreglo = {0,1,2,3,0};
		int elemento = 2;
		
		publicararreglo (arreglo);
		System.out.println ("");
		correrizquierda (arreglo, elemento);
		publicararreglo (arreglo);
		
	}
	
	public static void correrizquierda (int [] arreglo, int elemento) {
		for (int pos = elemento; pos<arreglo.length-1; pos++) {
			arreglo [pos] = arreglo [pos+1];
		}
	}
	
	public static void publicararreglo (int [] arreglo) {
		for (int pos = 0; pos<arreglo.length; pos++) {
			System.out.print (arreglo [pos] + " | ");
		}
	}

}

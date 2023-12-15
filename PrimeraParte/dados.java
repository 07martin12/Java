import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dados {
    public static void main(String[] args) {
        int numero = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingresar un número del 1 al 6");
            numero = Integer.valueOf(entrada.readLine());
            if (numero >= 1 && numero <= 6) {
                int repeticiones = lanzamientoDados(numero);
                System.out.println("El número ingresado (" + numero + ") tuvo la siguiente cantidad de repeticiones: " + repeticiones);
            } else {
                System.out.println("El número debe estar entre 1 y 6");
            }
        } catch (Exception exc) {
            System.out.println("Los caracteres ingresados son incorrectos. Error: " + exc.getMessage());
        }
    }

    public static int lanzamientoDados(int numero) {
        int dado, repeticiones = 0;
        for (int i = 0; i < 1000; i++) {
            dado = (int) (Math.random() * 6 + 1);

            if (dado == numero) {
                repeticiones++;
            }
        }
        return repeticiones;
    }
}




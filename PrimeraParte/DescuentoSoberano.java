import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DescuentoSoberano {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Ingreso de datos
        try {
            System.out.print("Ingrese el día (1 para lunes, 2 para martes, ..., 7 para domingo): ");
            int dia = Integer.parseInt(reader.readLine());

            System.out.print("Ingrese el número de ticket: ");
            int numeroTicket = Integer.parseInt(reader.readLine());

            System.out.print("Ingrese el importe: ");
            double importe = Double.parseDouble(reader.readLine());

            System.out.print("Ingrese el último dígito del DNI: ");
            int ultimoDigitoDNI = Integer.parseInt(reader.readLine());

            // Verificación de condiciones sin utilizar if-else
            boolean aplicarDescuento = (dia == 5 || dia == 6) & (numeroTicket % 2 == 0) & (importe <= 15000) & (ultimoDigitoDNI % 2 != 0);

            // Mostrar resultado
            System.out.println("¿Aplicar descuento?: " + aplicarDescuento);
        } catch (Exception e) {
            System.err.println("Error al leer la entrada. Asegúrate de ingresar datos válidos.");
        }
    }
}

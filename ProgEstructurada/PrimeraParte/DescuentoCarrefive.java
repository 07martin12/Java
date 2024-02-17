import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DescuentoCarrefive {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Ingreso de datos
            System.out.print("Ingrese el día de la semana (1 para martes, 2 para jueves): ");
            int diaSemana = Integer.parseInt(reader.readLine());

            System.out.print("Ingrese el importe del ticket: ");
            double importeTicket = Double.parseDouble(reader.readLine());

            // Verificación de condiciones sin utilizar if-else
            boolean aplicarDescuento = (diaSemana == 1) & (importeTicket > 13000) & (importeTicket <= 20000) |
                    (diaSemana == 1) & (importeTicket > 20000) |
                    (diaSemana == 2) & (importeTicket > 25000);

            // Calcular el descuento
            double descuento = (diaSemana == 1) ? ((importeTicket > 13000) ? 0.05 : 0.075) :
                                (diaSemana == 2) ? 0.1 : 0.0;

            // Aplicar tope de reintegro para el jueves
            descuento = (diaSemana == 2) ? Math.min(descuento, 3000 / importeTicket) : descuento;

            // Mostrar resultado
            System.out.println("¿Aplicar descuento?: " + aplicarDescuento);
            if (aplicarDescuento) {
                System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
            }
        } catch (Exception e) {
            System.err.println("Error al leer la entrada. Asegúrate de ingresar datos válidos.");
        }
    }
}

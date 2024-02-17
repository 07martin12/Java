import java.io.BufferedReader;
import java.io.InputStreamReader;

public class carrefive {
    public static void main(String[] args) {
        int idProducto = 1;
        String nombre, fecha, hora, prioridad;
        final int LIMITE_SEGURIDAD = 12, LIMITE_PRODUCTO = 180;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (idProducto != 0) {
                System.out.println("Ingrese el ID del producto (0 para salir): ");
                idProducto = Integer.parseInt(entrada.readLine());

                if (idProducto != 0) {
                    System.out.println("Ingrese el nombre del producto vendido: ");
                    nombre = entrada.readLine();
                    System.out.println("Ingrese la fecha de compra: ");
                    fecha = entrada.readLine();
                    System.out.print("Ingrese el horario de la compra: ");
                    hora = entrada.readLine();
                    System.out.println("Y por último, ingrese la cantidad de unidades vendidas: ");
                    int unidades = Integer.parseInt(entrada.readLine());

                    prioridad = condicionCompra(unidades, LIMITE_SEGURIDAD, LIMITE_PRODUCTO);

                    System.out.println("Informe al proveedor:");
                    System.out.println("ID_Producto: " + idProducto);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Fecha de compra: " + fecha);
                    System.out.println("Horario de compra: " + hora);
                    System.out.println("Unidades vendidas: " + unidades);
                    System.out.println("Prioridad: " + prioridad);
                }
            }

            System.out.println("Compra finalizada. ¡Hasta pronto!");
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }

    public static String condicionCompra(int unidades, final int limiteSeguridad, final int limiteProducto) {
        String resultado;

        switch (evaluarCondicion(unidades, limiteSeguridad, limiteProducto)) {
            case "Baja":
                resultado = "Baja";
                break;
            case "Media":
                resultado = "Media";
                break;
            case "Alta":
                resultado = "Alta";
                break;
            case "No hay unidades del producto":
                resultado = "No hay unidades del producto";
                break;
            case "Se superó el stock de unidades":
                int exceso = unidades - limiteProducto;
                resultado = "Se superó el stock de unidades. Stock restante: " + exceso;
                break;
            default:
                resultado = "Normal";
                break;
        }

        return resultado;
    }

    private static String evaluarCondicion(int unidades, int limiteSeguridad, int limiteProducto) {
        if (unidades >= limiteSeguridad && unidades<=limiteProducto) {
            return "Baja";
        } else if (unidades < limiteSeguridad * 0.3 && unidades != 0) {
            return "Media";
        } else if (unidades < limiteSeguridad * 0.7 && unidades != 0) {
            return "Alta";
        } else if (unidades == 0) {
            return "No hay unidades del producto";
        } else if (unidades > limiteProducto) {
            return "Se superó el stock de unidades";
        } else {
            return "Normal";
        }
    }
}

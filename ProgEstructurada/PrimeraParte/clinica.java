import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clinica {
    public static void main(String[] args) {
        BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
        int informe = 1, cantidad_pacientes = 0, pacientes_78años = 1, cantidad_prestadores = 0;

        try {
            while (informe != 0) {
                System.out.println("Ingrese el numero de informe correspondiente (0 para salir):");
                informe = Integer.parseInt(entrada.readLine());

                if (informe >= 0 && informe <= 4) {
                    switch (informe) {
                        case 1:
                            System.out.println(
                                    "Informe 1: Se solicita la cantidad de pacientes con un límite de 15 personas");
                            cantidad_pacientes = Integer.parseInt(entrada.readLine());

                            if (cantidad_pacientes < 15) {
                                for (int i = 1; i < cantidad_pacientes; i++) {
                                    System.out.println(i + ") Ingresar la edad del paciente: ");
                                    int edad = Integer.parseInt(entrada.readLine());
                                    System.out.println(i + ") Edad del paciente: " + edad);
                                    if (edad >= 78) {
                                        System.out.println("Pacientes mayores a 78 años: " + pacientes_78años++);
                                    }
                                }

                                System.out.println("Lista de pacientes cargados con éxito");
                            } else {
                                System.out.println("Denegado, límite de personas superado");
                            }
                            break;

                        case 2:
                            System.out.println(
                                    "Informe 2: Se solicita la cantidad de médicos en práctica laboral con un límite de 10 empleados");
                            cantidad_prestadores = Integer.parseInt(entrada.readLine());

                            if (cantidad_prestadores < 10) {
                                int prestadoresMas10Pacientes = 0;

                                for (int j = 1; j <= cantidad_prestadores; j++) {
                                    System.out.println(j + ") Ingresar la cantidad de pacientes por médico: ");
                                    int cantidad_pacientes_medico = Integer.parseInt(entrada.readLine());
                                    System.out.println(j + ") Cantidad de pacientes: " + cantidad_pacientes_medico);

                                    if (cantidad_pacientes_medico > 10) {
                                        prestadoresMas10Pacientes++;
                                    }
                                }

                                System.out.println(
                                        "Cantidad de prestadores que han atendido a más de 10 pacientes en los últimos 2 días: "
                                                + prestadoresMas10Pacientes);
                            } else {
                                System.out.println("Denegado, límite de personas superado");
                            }
                            break;

                        case 3:
                            System.out.println(
                                    "Informe 3: Se desea saber la cantidad de pacientes de cada sexo y el promedio de edades de cada grupo.");

                            System.out.println("Ingrese la cantidad de pacientes femeninos (no mayor a 10):");
                            int cantidadFemeninos = Integer.parseInt(entrada.readLine());

                            if (cantidadFemeninos > 10 || cantidadFemeninos < 0) {
                                System.out.println("Cantidad inválida. Debe ser entre 0 y 10.");
                                break;
                            }

                            int contadorFemeninos = 0;
                            int sumaEdadesFemeninos = 0;

                            for (int i = 1; i <= cantidadFemeninos; i++) {
                                System.out.println("Ingrese la edad de la paciente femenina " + i + ":");
                                int edad = Integer.parseInt(entrada.readLine());
                                sumaEdadesFemeninos += edad;
                                contadorFemeninos++;
                            }

                            double promedioFemeninos = (double) sumaEdadesFemeninos / contadorFemeninos;
                            System.out.println("Promedio de edades para pacientes femeninos: " + promedioFemeninos);

                            System.out.println("Ingrese la cantidad de pacientes masculinos (no mayor a 10):");
                            int cantidadMasculinos = Integer.parseInt(entrada.readLine());

                            if (cantidadMasculinos > 10 || cantidadMasculinos < 0) {
                                System.out.println("Cantidad inválida. Debe ser entre 0 y 10.");
                                break;
                            }

                            int contadorMasculinos = 0;
                            int sumaEdadesMasculinos = 0;

                            for (int i = 1; i <= cantidadMasculinos; i++) {
                                System.out.println("Ingrese la edad del paciente masculino " + i + ":");
                                int edad = Integer.parseInt(entrada.readLine());
                                sumaEdadesMasculinos += edad;
                                contadorMasculinos++;
                            }

                            double promedioMasculinos = sumaEdadesMasculinos / contadorMasculinos;
                            System.out.println("Promedio de edades para pacientes masculinos: " + promedioMasculinos);
                            break;

                        case 4:
                            System.out.println("Informe 4: Se desea conocer cuántos pacientes no tienen obra social.");

                            System.out.println("Ingrese la cantidad de pacientes (no mayor a 15):");
                            int cantidadTotalPacientes = Integer.parseInt(entrada.readLine());

                            if (cantidadTotalPacientes > 15 || cantidadTotalPacientes < 0) {
                                System.out.println("Cantidad inválida. Debe ser entre 0 y 15.");
                                break;
                            }

                            int pacientesSinObraSocial = 0;
                            
                            for (int i = 1; i <= cantidadTotalPacientes; i++) {
                                int tieneObraSocial = -1;
                                while (tieneObraSocial != 0 && tieneObraSocial != 1) {
                                    System.out.println("¿El paciente " + i
                                            + " tiene obra social? (Ingrese '1' para sí, '0' para no):");
                                    tieneObraSocial = Integer.parseInt(entrada.readLine());

                                    if (tieneObraSocial != 0 && tieneObraSocial != 1) {
                                        System.out.println("Valor no válido. Ingrese solo '0' para no o '1' para sí.");
                                    }
                                }

                                if (tieneObraSocial == 0) {
                                    pacientesSinObraSocial++;
                                }
                            }

                            System.out.println("Cantidad de pacientes sin obra social: " + pacientesSinObraSocial);

                            break;

                        case 0:
                            System.out.println("Hasta luego, gracias por su tiempo!");
                            break;
                    }
                } else {
                    System.out.println("Número invalido. Debe ser entre 1 y 4.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error de aplicación");
        }
    }
}

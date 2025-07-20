import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leeOpcion = new Scanner(System.in);
        Scanner leeCantidad = new Scanner(System.in);
        Consulta consulta = new Consulta();
        while (true) {
            System.out.println("       ");
            System.out.println("""
                    ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
                    Bienvenido/a al Conversor de Tipo de Cambio :)
                    
                    1) Dólar =====>>> Peso Mexicano
                    2) Peso Mexicano =====>>> Dólar
                    3) Dólar =====>>> Peso Argentino
                    4) Peso Argentino  =====>>> Dólar
                    5) Dólar =====>>> Real Brasileño
                    6) Real Brasileño =====>>> Dólar
                    7) Dólar =====>>> Peso Colombiano
                    8) Peso Colombiano =====>>> Dólar
                    9) Salir
                    
                    Elija el número de opción deseada?
                    ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
                    """);

            try {
                var opcionUsuario = Integer.valueOf(leeOpcion.nextLine());
                var base = "";
                var target = "";
                if (opcionUsuario.equals(1)) {
                    System.out.println("Ingrese la cantidad de Dólares USD a convertir a Pesos MX: ");
                    base = "USD";
                    target = "MXN";
                } else if (opcionUsuario.equals(2)) {
                    System.out.println("Ingrese la cantidad de Pesos Mexicanos a convertir a Dólares USD: ");
                    base = "MXN";
                    target = "USD";
                } else if (opcionUsuario.equals(3)) {
                    System.out.println("Ingrese la cantidad de Dólares a convertir a Pesos Argentinos ARS: ");
                    base = "USD";
                    target = "ARS";
                } else if (opcionUsuario.equals(4)) {
                    System.out.println("Ingrese la cantidad de Pesos Argentinos ARS a convertir a Dólares USD: ");
                    base = "ARS";
                    target = "USD";
                } else if (opcionUsuario.equals(5)) {
                    System.out.println("Ingrese la cantidad de Dólares USD a convertir a Reales Brasileños BRL: ");
                    base = "USD";
                    target = "BRL";
                } else if (opcionUsuario.equals(6)) {
                    System.out.println("Ingrese la cantidad de Reales Brasileños BRL a convertir a Dólares USD: ");
                    base = "BRL";
                    target = "USD";
                } else if (opcionUsuario.equals(7)) {
                    System.out.println("Ingrese la cantidad de Dólares USD a convertir a Peso Colombianos COP: ");
                    base = "USD";
                    target = "COP";
                } else if (opcionUsuario.equals(8)) {
                    System.out.println("Ingrese la cantidad de Peso Colombianos COP a convertir a Dólares USD: ");
                    base = "COP";
                    target = "USD";
                } else if (opcionUsuario.equals(9)) {
                    System.out.println("Finalizando la aplicación.");
                    System.exit(0);
                } else  {
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    continue;
                }
                var montoAConvertir = Double.valueOf(leeCantidad.nextLine());



                TipoDeCambio cambio = consulta.buscaTipoDeCambio(base, target, montoAConvertir);
                System.out.println("    ");
                LocalDate fecha_consulta = LocalDate.now();
                LocalTime hora_consulta = LocalTime.now();
                System.out.println("El valor de "+ montoAConvertir + " "+cambio.base_code()+" corresponde a >>>>>>  "+cambio.conversion_result()+" "+cambio.target_code()+" al día de hoy "+ fecha_consulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" a las "+hora_consulta.format(DateTimeFormatter.ofPattern("HH:mm:ss"))+" horas" );
                System.out.println("   ");

                GeneradorArchivo generador = new GeneradorArchivo();
                generador.guardarJson(cambio);

            } catch (NumberFormatException e) {
                System.out.println("La información ingresada no es un número " + e.getMessage());
                System.out.println("Favor de ingresar un opción válida");
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }
        }
    }
}

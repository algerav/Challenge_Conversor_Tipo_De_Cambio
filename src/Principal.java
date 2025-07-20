//El programa convierte el tipo de cambio de una cantidad entre distintas monedas como
//Dólares (USD), Pesos Mexicanos (MXN), Peso Argentino (ARS), Real Brasileño (BRL) y Peso Colombiano (COP).


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


//La clase "Principal" ejecuta el programa dentro de un loop "while" dónde se pide al usuario que seleccione la
//operación a convertir y el monto a convertir.
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
                    
                    1) Dólar (USD) =====>>> Peso Mexicano (MXN)
                    2) Peso Mexicano (MXN) =====>>> Dólar (USD)
                    3) Dólar (USD) =====>>> Peso Argentino (ARS)
                    4) Peso Argentino (ARS) =====>>> Dólar (USD)
                    5) Dólar (USD) =====>>> Real Brasileño (BRL)
                    6) Real Brasileño (BRL) =====>>> Dólar (USD)
                    7) Dólar (USD) =====>>> Peso Colombiano (COP)
                    8) Peso Colombiano (COP) =====>>> Dólar (USD)
                    9) Salir
                    
                    Elija el número de opción deseada?
                    ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
                    """);

            //La sentencia "try" evalua las distintas opciones que el usuario selecciona asegurando que sean opciones válidas,
            //de lo contrario la sentencia "catch" mostrará que la información ingresada no es correcta y que se seleccione alguna
            //opción válida
            try {
                var opcionUsuario = Integer.valueOf(leeOpcion.nextLine());  //opcionUsuario tendrá la opción seleccionada por el usuario que será un valor tipo Int.
                var base = ""; //Inicialización de las variables base correspondiente al parámetro base_code de la API "ExchangeRate-API" utilizada en la clase "Consulta.java"
                var target = "";//Inicialización de las variables target correspondiente al parámetro target_code de la API "ExchangeRate-API" utilizada en la clase "Consulta.java"

                //La sentencia "if" evalúa la operación a realizar en el convertidor:
                if (opcionUsuario.equals(1)) {
                    System.out.println("Ingrese la cantidad de Dólares USD a convertir a Pesos MX: ");
                    base = "USD";
                    target = "MXN";
                } else if (opcionUsuario.equals(2)) {
                    System.out.println("Ingrese la cantidad de Pesos Mexicanos MXN a convertir a Dólares USD: ");
                    base = "MXN";
                    target = "USD";
                } else if (opcionUsuario.equals(3)) {
                    System.out.println("Ingrese la cantidad de Dólares USD a convertir a Pesos Argentinos ARS: ");
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

                var montoAConvertir = Double.valueOf(leeCantidad.nextLine()); //montoAConvertir tendrá el monto ingresado por el usuario que será un valor tipo Double.



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

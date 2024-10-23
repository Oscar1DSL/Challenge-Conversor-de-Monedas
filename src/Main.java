import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] currencies = {"USD", "MXN", "COP", "ARS", "BRL"};
        int salir = 1;
        Converter converter = new Converter();
        Scanner input = new Scanner(System.in);

        while (salir != 0) {
            System.out.println("""
                    ******************************************************************************
                                    Bienvenido/a al Conversor de Moneda =]
                    """);
            String primaryCurrency = fnSetCurrency(input, currencies, "Elije tu Divisa (Moneda de Origen):");

            if (primaryCurrency.equals("SALIR")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            String secondaryCurrency = fnSetCurrency(input, currencies, "Elije la Divisa a la que deseas convertir (Moneda de Destino):");

            if (secondaryCurrency.equals("SALIR")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.println("Ingrese el valor que desea convertir: ");
            var numValue = Float.valueOf(input.nextLine());

            var convertedNum = converter.Converter(primaryCurrency, secondaryCurrency, numValue);
            System.out.println("El resultado de la conversion es: "
                    + numValue + " [" + primaryCurrency + "]" + " ===> " + convertedNum + " [" + secondaryCurrency + "]");
        }
    }

    public static String fnSetCurrency(Scanner input, String[] currencies, String message) {
        while (true) {
            System.out.println("""
                ****************************************************************************** 
                1) Dolar                    4) Peso Argentino
                2) Peso Mexicano            5) Real Brasileño
                3) Peso Colombiano
                6) Salir
                ****************************************************************************** 
                """);
            System.out.println(message);

            if (input.hasNextInt()) {
                var option = input.nextInt();
                input.nextLine();

                if (option >= 1 && option <= currencies.length) {
                    return currencies[option - 1];
                } else if (option == 6) {
                    return "SALIR";
                } else {
                    System.out.println("Opción no válida, intenta de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida, introduce un número.");
                input.nextLine();
            }
        }
    }
}




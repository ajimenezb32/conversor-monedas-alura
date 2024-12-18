import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        buscadorMoneda currencyFetcher = new buscadorMoneda();

        int option = 0;
        while (option != 2) {
            System.out.println("**********************\n" +
                    "Bienvenidos al conversor de monedas\n\n" +
                    "1. Convertir monedas\n" +
                    "2. Salir");
            System.out.print("Seleccione una opción: ");
            option = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el código de la moneda base (por ejemplo, USD): ");
                    String baseCurrency = inputScanner.nextLine().toUpperCase();
                    System.out.print("Ingrese el código de la moneda objetivo (por ejemplo, COP): ");
                    String targetCurrency = inputScanner.nextLine().toUpperCase();
                    conversorMoneda.convert(baseCurrency, targetCurrency, currencyFetcher, inputScanner);
                    break;
                case 2:
                    System.out.println("Saliendo.............. ");
                    break;
                default:
                    System.out.println("Opción no válida!");
                    break;
            }
        }
    }
}

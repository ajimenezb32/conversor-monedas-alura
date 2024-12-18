import java.util.Scanner;

public class conversorMoneda {

    public static void convert(String baseCurrency, String targetCurrency, buscadorMoneda fetcher, Scanner inputScanner) {
        double amount;
        double convertedAmount;

        Currency exchangeRate = fetcher.getExchangeRate(baseCurrency, targetCurrency);
        System.out.printf("La tasa de conversión de hoy es:\n1 %s = %.2f %s%n", baseCurrency, exchangeRate.conversion_rate(), targetCurrency);
        System.out.printf("Ingrese la cantidad en %s: ", baseCurrency);
        amount = Double.parseDouble(inputScanner.nextLine());
        convertedAmount = amount * exchangeRate.conversion_rate();
        System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
    }

    public static void convertAnotherCurrency(buscadorMoneda fetcher, Scanner inputScanner) {
        System.out.print("Ingrese el código de la moneda base: ");
        String baseCurrency = inputScanner.nextLine().toUpperCase();
        System.out.print("Ingrese el código de la moneda objetivo: ");
        String targetCurrency = inputScanner.nextLine().toUpperCase();
        convert(baseCurrency, targetCurrency, fetcher, inputScanner);
    }
}

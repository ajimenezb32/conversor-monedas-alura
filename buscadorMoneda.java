import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class buscadorMoneda {

    public Currency getExchangeRate(String baseCurrency, String targetCurrency) {
String apiKey = "";

URI endpoint = URI.create("https://v6.exchangerate-api.com/v6/" 
                          + apiKey 
                          + "/pair/" 
                          + baseCurrency 
                          + "/" 
                          + targetCurrency);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(endpoint)
                .GET()
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(httpResponse.body(), Currency.class);
        } catch (Exception exception) {
            throw new RuntimeException("No se encuentra la moneda: " + exception.getMessage());
        }
    }
}

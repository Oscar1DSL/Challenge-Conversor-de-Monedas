import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonetaryExchangeRate {
    public Currency fnConvertCurrency(String primaryCurrency, String secondaryCurrency, float value){
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/c143cb4f8065a99cf8eb0249/pair/" + primaryCurrency + "/" + secondaryCurrency + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Currency.class);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error");
        }
    }
}

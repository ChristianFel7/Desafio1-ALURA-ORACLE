import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.*;
import netscape.javascript.JSObject;


public class ConsultaExchange {

    public static Double buscaExchange(String coin, String destinyCoin){

        String apiKey = "b83ed85ffc054a963c744b2a"; //Trocar pela leitura de entrada do usuario


        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + coin);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();


        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(response.body()).getAsJsonObject();



            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");


            JsonElement taxaDestino = conversionRates.get(destinyCoin);

            return taxaDestino.getAsDouble();



        } catch (Exception e) {
            throw new RuntimeException("Não consegui realizar a conversao");
        }


    }
}

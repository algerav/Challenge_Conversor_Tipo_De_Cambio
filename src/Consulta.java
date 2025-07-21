import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//La clase "Consulta" ejecuta el metodo "buscaTipoDeCambio" recibe los parámetros del usuario y ejecuta un "GET" a
//al URI de exchange-api con la sentencia indicada en la documentación para hacer el cambio de moneda:
//https://v6.exchangerate-api.com/v6/00ea0ba48fa95c26188b5953/pair/base_code/target_code/Amount
//Para saber los códigos de las distintas monedas se utiliza:
//https://v6.exchangerate-api.com/v6/00ea0ba48fa95c26188b5953/codes

    public class Consulta {
        public TipoDeCambio buscaTipoDeCambio (String base, String target, Double montoAConvertir){

            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/00ea0ba48fa95c26188b5953/pair/"+base+"/"+target+"/"+montoAConvertir);

        //Se utiliza HttpClient y HttpRequest para hacer la consulta a la API de exchangerate.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                 .uri(direccion)
                 .build();
        try {
            HttpResponse<String> response = null;
            response = client
                         .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TipoDeCambio.class); //La librería "GSON" nos permite pasar los parámetros "json" a un clase java "TipoDeCambio.java"
        } catch (Exception e) {
            throw new RuntimeException("Cantidad Inválida ");
        }
    }
}

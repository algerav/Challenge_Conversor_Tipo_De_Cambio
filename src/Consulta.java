import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

    public class Consulta {
        public TipoDeCambio buscaTipoDeCambio (String base, String target, Double montoAConvertir){
          //  URI direccion = URI.create("https://v6.exchangerate-api.com/v6/00ea0ba48fa95c26188b5953/pair/base_code/target_code/"+montoAConvertir);
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/00ea0ba48fa95c26188b5953/pair/"+base+"/"+target+"/"+montoAConvertir);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                 .uri(direccion)
                 .build();
        try {
            HttpResponse<String> response = null;
            response = client
                         .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TipoDeCambio.class);
        } catch (Exception e) {
            throw new RuntimeException("Cantidad Inválida ");
        }
    }
}

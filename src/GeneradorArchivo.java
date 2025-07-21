import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


//El metodo "guardarJason" de la clase "GeneradorArchivo" genera un archivo json con el nombre del tipo de cambio
//que se realizó
public class GeneradorArchivo {
    public void guardarJson (TipoDeCambio cambio) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();  //Se crea una instancia para crear el archivo "json"
        FileWriter escritura = new FileWriter(cambio.base_code() + "-" + cambio.target_code() +".json");  //Se crea el archivo "json" con en nombre del tipo de cambio reealizado
        escritura.write(gson.toJson(cambio)); //Se escribe el contenido "json" en el archivo creado
        escritura.close(); //Se cierra el archivo
    }
}

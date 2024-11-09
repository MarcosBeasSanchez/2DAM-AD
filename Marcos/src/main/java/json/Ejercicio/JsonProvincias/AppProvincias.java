package json.Ejercicio.JsonProvincias;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class AppProvincias {

	public static void main(String[] args)  {
		
		try {
            // Configurar Gson con el deserializador personalizado
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Localidades.class, new LocalidadesTypeAdapter());  //me falta implementar los adaptadores correctamente
            Gson gson = gsonBuilder.setPrettyPrinting().create();

            // Leer el archivo JSON
            Reader reader = new FileReader("provincias.json");
            
            Root lista = gson.fromJson(reader, Root.class);
            System.out.println(lista);  

            // Cerrar el lector de archivos
            String jsonBonito = gson.toJson(lista);
            System.out.println(jsonBonito);
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error leyendo archivo");
        }

		
		

	}

}

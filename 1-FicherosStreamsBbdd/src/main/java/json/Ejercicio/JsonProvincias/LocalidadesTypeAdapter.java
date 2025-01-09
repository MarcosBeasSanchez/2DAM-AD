package json.Ejercicio.JsonProvincias;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

public class LocalidadesTypeAdapter extends TypeAdapter<Localidades> {

    @Override
    public void write(JsonWriter out, Localidades value) throws IOException {
        out.beginObject();
        out.name("localidad");
        out.beginArray();
        for (Localidad localidad : value.getLocalidades()) {
            out.beginObject();
            out.name("_c").value(localidad.getC());
            out.name("__cdata").value(localidad.getCdata());
            out.endObject();
        }
        out.endArray();
        out.endObject();
    }

    @Override
    public Localidades read(JsonReader in) throws IOException {
    	
    	/*in.beginObject();: Intenta consumir un { en el JSON, esperando el inicio de un objeto.
		 * in.nextName();: Intenta leer el nombre de un campo dentro de ese objeto.*/
    	
    	Localidades localidades = new Localidades ();
		Gson gson = new Gson (); //HACE FALTA COMPROBARLO ES COPIA PEGA DEL PROFE
	
		in.beginObject();
		in.nextName();
		
		if (in.peek() == JsonToken.BEGIN_ARRAY) // si llega un array
		{
			TypeToken listaDeLocaliades = TypeToken.getParameterized(ArrayList.class, Localidad.class).getType();
			localidades.setLocalidad(gson.fromJson(in, listaDeLocaliades));
		}

		else //llega un elemento consumirlo
			localidades.getLocalidad.add(gson.fromJson(in, Localidad.class));
		
		
		// Consumir final objeto 
		in.endObject();
		
		return localidades;
    	
    

        return localidades;
    }
}

package json.Ejercicio.JsonToXml2;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class EnumCategoriaAdapter extends TypeAdapter<Categoria> {

	@Override
    public void write(JsonWriter out, Categoria value) throws IOException {
        out.value(value != null ? value.toString() : null); // Usa toString() para la serialización
    }

    @Override
    public Categoria read(JsonReader in) throws IOException {
        String categoria = in.nextString();
        return Categoria.crearCategoria(categoria); // Usa el método crearCategoria
    }

}

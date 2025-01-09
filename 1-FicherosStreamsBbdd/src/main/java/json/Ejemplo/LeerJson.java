package json.Ejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LeerJson {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<Empleado> empleados;

		Gson gson = new Gson();

		Reader reader = new FileReader(new File("empleados.json"));
		//para leeer arrays Json
		TypeToken<List<Empleado>>listaEmpleados = new TypeToken<List<Empleado>>() {};

		empleados = gson.fromJson(reader, listaEmpleados);

		//reader.close();
		
		empleados.forEach(System.out::println);

	}

}

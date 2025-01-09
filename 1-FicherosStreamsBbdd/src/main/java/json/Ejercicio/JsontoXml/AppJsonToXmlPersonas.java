package json.Ejercicio.JsontoXml;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class AppJsonToXmlPersonas {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Leer Json -> fromjson
		Personas personas;
		Gson gsonLector = new Gson(); //leector
		Reader reader = new FileReader("personas.json"); //lector de json
		personas = gsonLector.fromJson(reader, Personas.class); //lee el archivo
		
		//Escribir Json por la terminal de manera bonita
		Gson gsonEscribidor= new GsonBuilder().setPrettyPrinting().create(); //escribidor
		String json = gsonEscribidor.toJson(personas);
		System.out.println(json);
		
		/*TypeToken<List<Persona>>listaPersonas = new TypeToken<List<Persona>>() {};
		persona = (Personas) gson.fromJson(reader, listaPersonas);*/
		
		System.out.println(personas);
		System.out.println("\n");
		
		//Escribir Xml -> toxml
		try {
			JAXBContext context = JAXBContext.newInstance(Personas.class);
			Marshaller ms = context.createMarshaller();
			
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(personas, System.out); //escribe el xml
			ms.marshal(personas, new FileWriter("personas.xml")); //exporta el xml
			
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		
		

	}

}

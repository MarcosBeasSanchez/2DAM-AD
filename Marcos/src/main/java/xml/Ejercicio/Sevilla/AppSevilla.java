package xml.Ejercicio.Sevilla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import json.Ejercicio.JsonProvincias.Lista;

public class AppSevilla {

	public static void main(String[] args) {
		
		Tiempo tiempo = cargarDatos();
		System.out.println(tiempo);
		EscribirDatos(tiempo); //En en la terminal 
		EscribirJson(tiempo);
	}

	private static void EscribirJson(Tiempo tiempo) {
		
		GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
		//sino se añaden los @JsonAdapter hay que utilizarlos
//		creadorGson.registerTypeAdapter (LocalTime.class, new LocalTimeAdapterSevillaJson());
//		creadorGson.registerTypeAdapter (LocalDate.class, new LocalDateSevillaJson());
//		creadorGson.registerTypeAdapter (LocalDateTime.class, new JsonLocalDateTimeAdapterSevilla());
		Gson gson = creadorGson.create();
		String json = gson.toJson(tiempo);
		
		try {
			FileWriter file = new FileWriter("sevilla.json");
			file.write(json);
			file.close();
			System.out.println("Json Guardado correctamente sevilla.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static void EscribirDatos(Tiempo tiempo) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Tiempo.class);
			
			Marshaller ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(tiempo, System.out /*new File("sevillaEscrito.xml")*/);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Tiempo cargarDatos() {
		
		Tiempo tiempo = new Tiempo();
		try {
			JAXBContext context = JAXBContext.newInstance(Tiempo.class);
			
			Unmarshaller ums = context.createUnmarshaller();
			 tiempo = (Tiempo) ums.unmarshal(new File("sevilla.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return tiempo;
	}

}

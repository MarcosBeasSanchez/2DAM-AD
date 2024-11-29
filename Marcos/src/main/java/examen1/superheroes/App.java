package examen1.superheroes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import csv.Ejercicio.EmpleYDep.profe.BooleanToText;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class App 
{
    public static void main( String[] args )
    {
    	List<SuperHeroe> squad = cargarDatos();
    	System.out.println(squad);
    	
    	escribirDatos(squad);
    	
    }

	private static void escribirDatos(List<SuperHeroe> squad) {
		
		List<Member>allMembers = squad.stream().flatMap(t -> t.getMembers().stream()).toList();
		System.out.println(allMembers);
	    MemberList memberList = new MemberList(allMembers);

		Writer writer;
		try {
			writer = new FileWriter("miembros.xml"); //nombre del fichero
			JAXBContext context = JAXBContext.newInstance(MemberList.class); //La clase la cual se va escribir
			Marshaller ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(memberList, writer); //variable y escritor
			System.out.println("miembros.xml EXPORTADO OK");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}

	private static List<SuperHeroe> cargarDatos() {
		List<SuperHeroe> squadd = null;
		Reader reader;
		try {
			reader = new FileReader("examen.json");
			
			TypeToken<List<SuperHeroe>>lista = new TypeToken<List<SuperHeroe>>() {};
			
			GsonBuilder creadorGson = new GsonBuilder()
					
					.registerTypeAdapter(SecretBase.class, new SecretBaseJson())
					.registerTypeAdapter(Boolean.class, new BooleanToJson())
					;
	    	Gson gson = creadorGson.create();
	    	
	    	squadd = gson.fromJson(reader, lista);
            System.out.println("Leído correctamente");
	    	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return squadd;
		
	}
}

package json.Ejercicio.JsonToXml2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import daw.com.Teclado;
import stream.Ejercicio.Subasta.profe.Subasta;

public class AppPruebaIdiomas {

	public static void main(String[] args) {

		// Leer Json
		List<PruebaIdiomas> test = null;
		GsonBuilder gsonBuilder = new GsonBuilder();

		TypeToken<List<PruebaIdiomas>> listaPruebas = new TypeToken<List<PruebaIdiomas>>() {
		};
		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapterIdiomas());

		Gson gson = gsonBuilder.create();

		try (Reader reader = new FileReader(new File("pruebaIdiomas.json"))) {
			test = gson.fromJson(reader, listaPruebas.getType());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		test.forEach(System.out::println);

		// Escribir Xml
		ContedorPruebaIdiomas contenedor= new ContedorPruebaIdiomas(test);
		try {
			JAXBContext context = JAXBContext.newInstance(ContedorPruebaIdiomas.class);
			Marshaller ms = context.createMarshaller();

			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(contenedor, System.out);
			ms.marshal(contenedor, new FileWriter("pruebaIdiomas.xml"));

		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nEjer1");
		Long cuantos = test.stream().count();
		System.out.println("Pruebas de idiomas  descritas en el documento: "+ cuantos);
		
		System.out.println("\nEjer2");
		System.out.println("Titulo de pruebas de nivel que van a durar más de dos horas. :");
		test.stream().filter(p-> p.getHoras() > 2)
		.map(PruebaIdiomas::getTitulo)
		.forEach(System.out::println);
		
		System.out.println("\nEjer3");
		System.out.println("De las pruebas de tipo No Presencial muestra la URL de información. :");
		test.stream().filter(p -> p.getTipoFormacion().equals(TipoFormacion.NOPRESENCIAL))
		.map(PruebaIdiomas :: getUrl)
		.forEach(System.out::println);
		
		System.out.println("\nEjer4");
		System.out.println("Pide por teclado el código de la prueba ID y muestra su título y profesores.:");
		String idSolicitado = Teclado.leerString("ID?");
		 test.stream().filter(p-> p.getDolarId().equalsIgnoreCase(idSolicitado))
		.forEach(p-> System.out.println(p.getTitulo()+ " / " + p.getProfesores()));
		 
		 System.out.println("\nEjer5");
			System.out.println("Para cada uno de las pruebas, muestra su título y sus profesores.:");
			
			 test.stream().forEach(p-> System.out.println(p.getTitulo()+ " / " + p.getProfesores()));
				

		
		

	}
}

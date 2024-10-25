package xml.Ejercicio.Cartelera;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import csv.Ejercicio.Instituto.Instituto;




public class LeerXml {

	public static void main(String[] args) {
		
		List<Pelicula>pelis = cargarDatos();
		Cartelera cartelera = new Cartelera();
		cartelera.setPeliculas(pelis);
		
    	pelis.forEach(System.out::println);
    	escribirCartelera (cartelera);
    	
		//ejercicio1
    	System.out.println("\nMostrar actores que han hecho peliculas posteriores al año 2003");
    	
    	pelis.stream().filter(p->p.getFecha().isAfter(LocalDate.of(2003, 12, 31)))
    	.flatMap(p -> p.getActores().stream())
    	.map(Actor::getNombre)
    	.distinct()
    	.collect(Collectors.toList())
    	.forEach(System.out::println);
		

	}

	private static List<Pelicula> cargarDatos() {
		
		List<Pelicula> pelis = new ArrayList<>();
		try {
			JAXBContext context = JAXBContext.newInstance(Cartelera.class);
			Unmarshaller ums = context.createUnmarshaller();
			Cartelera peliculas = (Cartelera) ums.unmarshal(new File("cartelera.xml"));
			for(Pelicula p : peliculas.getPeliculas()) {
				//System.out.println(p.toString());
				pelis.add(p);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return pelis;
	}
	
	public static void escribirCartelera (Cartelera cartelera)
	{
		
		try {
			JAXBContext context = JAXBContext.newInstance(Cartelera.class);
			Marshaller ms = context.createMarshaller();

									
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(cartelera, System.out);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

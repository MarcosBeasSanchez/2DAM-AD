package csv.EjercicioRepasoGeneral.subasta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

	public static <T> void main(String[] args) {
		
		final Consumer<Object> ESCRIBIDOR = System.out::println;
		
		Usuario juan = new Usuario("Juan",100);
		Usuario pedro = new Usuario("Pedro",150);
		Usuario enrrique = new Usuario("Enrrique",300);
		
		List<Subasta> subastas = new ArrayList<>();
		Subasta subasta = new Subasta ("Telefono Movil",juan);
		subastas.add(subasta);
		
		subasta.pujar(pedro,100);
		
		Puja pujaMayor = subasta.getPujaMayor();
		if (pujaMayor != null) {
			System.out.println("La puja mayor es : " + pujaMayor.getPujador());
		}
		
		subasta.pujar(enrrique, 50);
		subasta.mostrarPujaMayor();
		
		// Ejecutar la subasta
        if (subasta.ejecutar()) {
            System.out.println("\nSubasta cerrada : " + subasta.getPujaMayor().getPujador() + " cerrado con : " + subasta.getPujaMayor().getCantidad());
            System.out.println("\nSaldos : Juan "
            + juan.getCredito() + " Pedro " 
            + pedro.getCredito() + " Enrique " 
            + enrrique.getCredito());
        } else {
            System.out.println("La subasta no ha sido ejecutada");
        }
        
        //Ejer2
        System.out.println("\nEjer2");
        subastas.stream()
        .map(Subasta::getPropietario)
        .map(Usuario::getNombre)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .forEach(ESCRIBIDOR);
        
        //Ejer3
        System.out.println("\nEjer3");
        subastas.stream()
        .filter(s -> !s.getPujas().isEmpty()) // Filtrar subastas que hayan recibido alguna puja
        .map(Subasta::getNombreProducto)      // Obtener el nombre del producto
        .distinct()                           // Evitar duplicados
        .sorted()                             // Ordenar alfabéticamente
        .forEach(System.out::println);        // Mostrar los nombres
        
        //Ejer3
        System.out.println("\nEjer4");
        subastas.stream()
        .filter(s -> s.getPujaMayor() != null && s.getPujaMayor().getCantidad() > 50)
        .map(Subasta::getNombreProducto)
        .collect(Collectors.toList())
        .forEach(ESCRIBIDOR);
        
        System.out.println("\nEjer5");
        subastas.stream().map(s -> s.getPropietario().getNombre()).forEach(ESCRIBIDOR);
        
        boolean hayGanadoresPropietarios = subastas.stream()
                .anyMatch(s -> !s.isAbierta() && s.getPujaMayor() != null && subastas.stream()
                .anyMatch(s2 -> s2.getPropietario() == s.getPujaMayor().getPujador()));
        		System.out.println("¿Hay ganadores que son propietarios? " + hayGanadoresPropietarios);

		

	}

}

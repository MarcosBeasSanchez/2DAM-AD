package stream.Ejercicio.TraderYTransaccion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjercicioTraderYTransaccion {

	public static void main(String[] args) {
		
		final Consumer<Object> ESCRIBIDOR = System.out::println;

		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
		//EJER1 
		 List<Transaction> resultado = transactions.stream()
		            .filter(t -> t.getYear() == 2011)           // Filtrar por año 2011
		            .sorted(Comparator.comparing(Transaction::getValue)) // Ordenar por valor ascendente
		            .collect(Collectors.toList());    
		System.out.println("\nEjer1");
		resultado.forEach(ESCRIBIDOR);
		
		//EJER2
		Set<String>ciudadesunicas = transactions.stream()
				.map(t -> t.getTrader().getCity()) // Obtener la ciudad de cada trader
				.collect(Collectors.toSet()); // Lo hacemos un set que evita duplicados
		System.out.println("\nEjer2");
		ciudadesunicas.forEach(ESCRIBIDOR);
		
		//EJER3	
		Set<Trader> trCambridge = transactions.stream() //No sale ordenado porque Set elimina duplicados y orden
				.map(Transaction :: getTrader) // obtenemos el trader de las transacciones
				.filter(trader -> "Cambridge".equals(trader.getCity())) // filtramos por Cambridge
				.sorted(Comparator.comparing(Trader::getName)) 
				.collect(Collectors.toSet());
		System.out.println("\nEjer3");
		trCambridge.forEach(ESCRIBIDOR);
		
		//EJER4
		Stream<String> nombres = transactions.stream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted();
		System.out.println("\nEjer4");
		nombres.forEach(ESCRIBIDOR);
		
		//EJER5
		Set<Trader> trMilan = transactions.stream()
				.map(Transaction :: getTrader)
				.filter(trader -> "Milan".equals(trader.getCity()))
				.collect(Collectors.toSet());
		System.out.println("\nEjer5");
		trMilan.forEach(ESCRIBIDOR);
		
		//EJER6
		System.out.println("\nEjer6");
		transactions.stream()
				.filter(ts -> "Cambridge".equals(ts.getTrader().getCity()))
				.map(Transaction:: getValue)
				.forEach(ESCRIBIDOR);
		
		//EJER7
		System.out.println("\nEjer7");
		transactions.stream()
			.map(Transaction::getValue)
			.max((a,b) -> Integer.compare(a, b))
			.ifPresent(ESCRIBIDOR);;
		
		//EJER8
		System.out.println("\nEjer8");
		transactions.stream()
			.map(Transaction::getValue)
			.min((a,b) -> Integer.compare(a, b))
			.ifPresent(ESCRIBIDOR);
		
		//EJER8
		System.out.println("\nEjer9");
		
		
	}

}

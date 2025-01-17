package stream.Ejercicio.Subasta.profe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppSubasta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Subasta subasta;
		Usuario usuario;
		Set<Usuario> usuarios = cargarUsuarios ();
		
		usuario = usuarios.stream().filter(u->u.getNombre().equals("Juan")).findFirst().get(); 
		subasta = new Subasta ("Telefono movil", usuario);
		
		usuario = usuarios.stream().filter(u->u.getNombre().equals("Pedro")).findFirst().get();
		
		System.out.println(subasta.pujar(usuario, 100)?
				"puja aceptada":"puja no aceptada");
			
		System.out.println("puja mayor: ");
		subasta.getPujaMayor().
				ifPresent(s -> System.out.println (s.getPujador().getNombre() + "->"+s.getCantidad()));
		
		System.out.println(
		subasta.getPujaMayor().
			map(p -> p.getPujador().getNombre() + " ," + p.getCantidad()).
			orElse("no hay dato")
		);
		
		
		usuario = usuarios.stream().filter(u->u.getNombre().equals("Enrique")).findFirst().get();
		
		System.out.println(subasta.pujar(usuario, 50)?
				"puja aceptada":"puja no aceptada");
	
		
		System.out.println("puja mayor: ");
		subasta.getPujaMayor().
				ifPresent(s -> System.out.println (s.getPujador().getNombre() + "->"+s.getCantidad()));

		
		System.out.println(subasta.ejecutar()?
				"subasta ejecutada":"no se ha podido ejecutar la subasta");
		
		
		usuarios.stream().forEach(u ->System.out.println(u.getNombre() +"->"+ u.getCredito()));
		
		// Consultas
		List<Subasta> subastas = new ArrayList<Subasta>();
		subastas.add(subasta);
		
		System.out.println("Cuenta los usuarios que tienen cuenta de correo en Gmail:");
		System.out.println(
					usuarios.stream().
					filter(u->u.getEmail().contains("gmail")).
					count());
		
		System.out.println("nombres de usuarios que sean propietarios de subastas ordenados\r\n" + 
				"por orden alfab�tico inverso:");
		
		subastas.stream().
				map(s -> s.getPropietario().getNombre()).
				distinct().
				sorted((n1,n2) -> n2.compareTo(n1)).
				forEach(System.out::println);
		
		
		System.out.println("nombres de los productos cuyas subastas hayan recibido alguna\r\n" + 
				"puja ordenados alfab�ticamente:");
		subastas.stream().
				filter(s -> !s.getPujas().isEmpty()).
				map (Subasta::getProducto).
				forEachOrdered(System.out::println);
		
		
		System.out.println("el nombre de los productos de aquellas subastas que hayan recibido\r\n" + 
				"pujas superiores a 50 euros:");
		
		subastas.stream().
				filter (s -> s.getPujas().stream().anyMatch(p->p.getCantidad() > 50)).
				map (Subasta::getProducto).
				forEach(System.out::println);
		
		System.out.println("si hay usuarios que hayan ganado alguna subasta y que sean propietarios de\r\n" + 
				"subastas:");
		
		 
		List<Usuario> propietarios =  
				subastas.stream().
				map(Subasta::getPropietario).
				distinct().
				collect(Collectors.toList());
		
		 
		boolean existe = subastas.stream().
				filter(((Predicate<Subasta>)Subasta::isAbierta).negate()).
				map(s ->s.getPujaMayor().get().getPujador()).
				distinct().
				anyMatch(u -> propietarios.contains(u));
				
		System.out.println(existe?"Hay propietarios y ganadors":"No hay propietarios y ganadores");		

		
		System.out.println("Pujas en subastas:");
		List<Puja> pujas = subastas.stream().
						flatMap(s->s.getPujas().stream()).
						collect(Collectors.toList());
		
		pujas.forEach(p -> System.out.println(p.getPujador().getNombre() 
								+"->" + p.getCantidad()
								+"->" + p.getSubasta().getProducto()));
		
		System.out.println("Calcular ganancias");
		
		Predicate <Subasta> cerrada = s -> !s.isAbierta();
		
		float ganancias = (float) subastas.stream().
				filter(cerrada).
				mapToDouble(s ->s.getPujaMayor().get().getCantidad()).sum()*0.05f;
		
		float ganancias1 = (float) subastas.stream().
				filter(cerrada).
				map(s ->s.getPujaMayor().get().getCantidad()).reduce(0f,(p1,p2) -> p1+p2)*0.05f;
		
		System.out.println("ganancias =" + ganancias1);
	}
	
	public static Set<Usuario> cargarUsuarios ()
	{
		Set<Usuario> usuarios = new HashSet<Usuario> (); 
		
		
		
		usuarios.add (Usuario.builder().
							nombre("Juan").
							credito(100).
							email("juan@yahoo.es").
							build());
	
		
		usuarios.add (Usuario.builder().
							nombre("Pedro").
							credito(150).
							email("pedro@gmail.com").
							build());
		

		usuarios.add (Usuario.builder().
							nombre("Enrique").
							credito(300).
							email("enrique@madrid.org").
							build());
		
		return usuarios;
	}

}

package ejercicio.institutoOpencsv;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.opencsv.bean.CsvToBeanBuilder;

import ejercicio.EmpleYDep.profe.Depart;

import java.util.function.Function;
import static java.util.stream.Collectors.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class App 
{
	public final static Predicate <Persona> MAYORDEEDAD = p -> p.getFechaNacimiento().
						plusYears(18).
						isBefore(LocalDate.now());
	
    public static void main( String[] args )
    {
    	List<Instituto>institutos = cargarDatos();
    	institutos.forEach(System.out::println);
    
    	
    	// Listado del nombre y el número de teléfono, ordenado por nombre, 
    	// de todos los institutos cuyo código de centro comience por “28”.
    	System.out.println("\nEjercicio 1");
    	institutos.stream().
    				filter (i -> i.getCodigo().startsWith("001")).
    				sorted(Comparator.comparing(Instituto::getNombre)).
    				map(i-> i.getNombre() + "->" + i.getTelefono()).
    				forEach(System.out::println);
    	
    	// Listado del nombre de todas las personas de todos los institutos 
    	// que tengan un vehículo de color “verde”.
    	System.out.println("\nEjercicio 2");
    	institutos.stream().
    		flatMap (i -> i.getPersonas().stream()).
    		filter(p -> p.getVehiculo().
    						map(Vehiculo::getColor).
    						orElse("").
    						equals("verde")).
			map(Persona::getNombre).
			forEach(System.out::println);
    	
    	// Listado de todas las compañías de telecomunicaciones de todas 
    	// las personas mayores de edad de todos los institutos. 
    	System.out.println("\nEjercicio 3");
    	institutos.stream().
    		flatMap (i -> i.getPersonas().stream()).
    		filter (MAYORDEEDAD).
    		flatMap(p -> p.getContactos().stream()).
    		map(Contacto::getEmpresa).
    		distinct().
    		forEach(System.out::println);
    	
    	// Total del presupuesto de todos los institutos que tengan más de una persona. 
    	System.out.println("\nEjercicio 4");
    	System.out.println(
    			institutos.stream().
    				filter (i -> i.getPersonas().size() > 1).
    				mapToDouble(Instituto::getPresupuesto).
    				sum());
    	
    	// Listado de los centros de adultos, es decir 
    	// los institutos que no tengan alumnos menores de edad.
    	System.out.println("\nEjercicio 5");
    	institutos.stream().
    		filter (i -> i.getPersonas().stream().allMatch(MAYORDEEDAD)).
    		forEach(System.out::println);
		
    	
    	
    	// Ejer6
    	System.out.println("\nEjercicio 6");
    	ejer6();
    	
    	
    }
    
    private static void ejer6() {
		// TODO Auto-generated method stub
    	
    	Function <Persona,String> nombreYContactos = p -> p.getNombre() + 
				"->" + 
				p.getContactos().stream().
					map(Contacto::toString).
					reduce((s1,s2)->s1 +", " +s2).
					orElse("sin contactos");

    	Function <Instituto, Stream<String>> nombreYContactosmayordeEdad;

    	nombreYContactosmayordeEdad = i -> i.getPersonas().stream().
    			filter(MAYORDEEDAD).
    			map(nombreYContactos);


    	
    	cargarDatos().stream().
    	collect(groupingBy(Instituto::getNombre,
    			flatMapping(nombreYContactosmayordeEdad, toList()))).
    	entrySet().
    	forEach(System.out::println);
		
    	 
    	
    	cargarDatos().stream().
    	collect(toMap(Instituto::getNombre,
    			nombreYContactosmayordeEdad.
    			andThen(st -> st.collect(toList())))).
    	entrySet().
    	forEach(System.out::println);
    	
	}

    public static List<Instituto> cargarDatos() {
        List<Instituto> instituto = new ArrayList<>();
        try {
            List<Instituto> beans = new CsvToBeanBuilder<Instituto>(new FileReader("instituto.csv"))
                    .withType(Instituto.class)
                    .withSeparator(':') // Asegúrate de que el delimitador aquí sea correcto
                    .build()
                    .parse();
            
            instituto = beans;
        } catch (IllegalStateException | FileNotFoundException e1) {
            System.out.println("Error leyendo fichero: " + e1.getMessage());
        }
        
        return instituto;
    

		
		//metodo 2
		
    	/*List <Instituto> todos = new ArrayList<>();
    	 	Instituto i1,i2;

    	i1 = Instituto.builder().
    			nombre("I1").
    			codigo("28001").
    			presupuesto(10000).
    			telefono("11111").	
    			persona (Persona.builder().
    					nif("P001").
    					nombre("per01").
    					fechaNacimiento(LocalDate.now().minusYears(19)).
    					vehiculo (Optional.of(Vehiculo.builder().
    								matricula("000AAA").
    								color("verde").
    								modelo("Seat Panda").
    								build())).
    					contacto (Contacto.builder().
    							empresa("Movistar").
    							numero("99999").
    							os("Android").
    							build()).
    					build()).
    			persona (Persona.builder().
    					nif("P002").
    					nombre("per02").
    					fechaNacimiento(LocalDate.now().minusYears(17)).
    					contacto (Contacto.builder().
    							empresa("Movistar").
    							numero("343434").
    							os("Android").
    							build()).
    					build()).
    			persona (Persona.builder().
    					nif("P003").
    					nombre("per03").
    					fechaNacimiento(LocalDate.now().minusYears(21)).
    					vehiculo (Optional.of(Vehiculo.builder().
    								matricula("000BBB").
    								color("rojo").
    								modelo("Kia").
    								build())).
     					contacto (Contacto.builder().
    							empresa("Movistar").
    							numero("11111").
    							os("Android").
    							build()).
     					contacto (Contacto.builder().
    							empresa("Orange").
    							numero("22222").
    							os("IOS").
    							build()).
    					build()).
    			build();
    	
    	i2 = Instituto.builder().
    			nombre("I2").
    			codigo("28002").
    			presupuesto(10000).
    			telefono("22222").	
    			persona (Persona.builder().
    					nif("P011").
    					nombre("per11").
    					fechaNacimiento(LocalDate.now().minusYears(19)).
    					vehiculo (Optional.of(Vehiculo.builder().
    								matricula("000HHHH").
    								color("rojo").
    								modelo("Seat Ibiza").
    								build())).
    					contacto (Contacto.builder().
    							empresa("O2").
    							numero("88888").
    							os("IOS").
    							build()).
    					build()).
    			build();
    	
    	todos.add(i1);
    	todos.add(i2);
    	return todos;*/
    }
    
    
}

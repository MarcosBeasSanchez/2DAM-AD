package ejercicio.EmpleYDep.profe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import daw.com.Teclado;

public class AppConsultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List <Depart> departamentos = cargarDatos();
		

		// Query 1
		System.out.println("\nEJERCICIO 1");
		departamentos.stream().
			flatMap(d->d.getEmpleados().stream()).
			sorted((e1,e2)->e1.getNombre().compareTo(e2.getNombre())).
			forEach(System.out::println);
		

		// query 2
		System.out.println("\nEJERCICIO 2");
		Function <Emple, List<String>> funcion = e -> {ArrayList <String> r = new ArrayList<>(); 
							r.add(e.getNombre());
							r.add(e.getCargo());
							return r;
							};
						
		departamentos.stream().
		flatMap(d->d.getEmpleados().stream()).
		//sorted ((e1,e2) -> Float.compare(e1.getSalario(), e2.getSalario())).
		sorted(Comparator.comparing(Emple::getSalario)/*.reversed()*/).
		map (funcion).
		forEach(System.out::println);
	

		// query 3
		System.out.println("\nEJERCICIO 3");
		departamentos.stream().
			flatMap(d-> d.getEmpleados().stream()).
			forEach (e -> System.out.println( e.getNombre() +":"+ e.getSalario()+"->"+e.getComision()));

		

		// query 4
		System.out.println("\nEJERCICIO 4");
		//Obtener el valor total a pagar que resulta de sumar a los empleados del departamento introducido
		//por teclado, una bonificaci�n de 500000�, en orden alfab�tico del empleado.
		departamentos.stream().
			flatMap(d->d.getEmpleados().stream()).
			sorted((e1,e2) -> e1.getNombre().compareTo(e2.getNombre())).
			forEach(e -> System.out.println(e.getNombre()+"->" +e.getSalario() + "+500000 : "+ (e.getSalario()+ 500000)));
		

		// query 6
		// modo 1
/*		departamentos.stream().
			collect(Collectors.groupingBy(Depart::getCiudad)).
			forEach((c,ds) -> System.out.println (c +"->" + ds.stream().map(Depart::getNombre).reduce((s1,s2) -> s1 + ","+s2).orElse("")));
*/
		// otro forma de hacerlo						
/*		departamentos.stream().
			collect(Collectors.groupingBy(Depart::getCiudad,
					Collectors.mapping(Depart::getNombre,Collectors.toList()))).
			forEach((c,ds) -> System.out.println(c +"->" + ds));
*/
/*
		// query 9
		//Entregar el nombre del departamento cuya suma de salarios sea la m�s alta, indicando el valor
		//de la suma.
		// Function que suma los salarios de un departamento
		ToDoubleFunction <Depart> sumaSalarios = d->d.getEmpleados().stream().mapToDouble(Emple::getSalario).sum();
		
		Map <String,Double> sumaSalariosDepartamentos = departamentos.stream().
						collect(Collectors.groupingBy(Depart::getNombre,Collectors.summingDouble(sumaSalarios)));
		// Mostrar suma salarios de todos los departamentos
		sumaSalariosDepartamentos.forEach((c,ds) -> System.out.println(c +"->" + ds));
		
		//Obtener departamento con m�xima suma salario
		sumaSalariosDepartamentos.entrySet().stream().
				max((entry1,entry2) -> Double.compare(entry1.getValue(), entry2.getValue())).
				ifPresent(System.out::println);
*/			
				
/*				
		// query 10
		// Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo.
		departamentos.stream().
				flatMap(d -> d.getEmpleados().stream()).
				map(e -> e.getJefe()).
				filter(Optional::isPresent).
				distinct().
				map( e -> e.get().getNombre()).
				forEach(System.out::println);
*/
/*		
		// query 11
		// Hallar el salario promedio por departamento.
		ToDoubleFunction <Depart> media = d->d.getEmpleados().stream().mapToDouble(Emple::getSalario).average().orElse(0);
		departamentos.stream().
			collect(Collectors.groupingBy(Depart::getNombre,Collectors.averagingDouble(media))).
			forEach((c,ds) -> System.out.println(c +"->" + ds));
*/		
/*		
		// query 14
		// Suponer que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los
		//empleados, su salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no
		//comisi�n.
		departamentos.stream().
			flatMap(d -> d.getEmpleados().stream()).
			forEach (e -> System.out.println (e.getNombre() + 
								"->" + 
								e.getSalario() + 
								"->" + 
								(e.getSalario() * 1.07) +
								"->" +
								(e.getComision()> 0?"tiene comisi�n":"no tiene comisi�n")));
		
		
		departamentos.stream().
			flatMap(d->d.getEmpleados().stream()).
			collect(Collectors.averagingDouble(Emple::getSalario));
*/
	// Query 7
	// Hallar el salario más alto, el más bajo y la diferencia entre ellos.
		DoubleSummaryStatistics summary = departamentos.stream().
		flatMap(d->d.getEmpleados().stream()).
		mapToDouble(Emple::getSalario).summaryStatistics();
	
		System.out.println(summary.getMax());
		System.out.println(summary.getMax());
	
	// Query 13
	//  Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
		DoubleSummaryStatistics summary1 = departamentos.stream().
				flatMap(d->d.getEmpleados().stream()).
				filter (e -> e.getComision()>0).
				mapToDouble(Emple::getComision).summaryStatistics();
		
		System.out.println(summary1.getCount());
		System.out.println(summary1.getSum());
		
	}
	
	public static List<Depart> cargarDatos ()
	{
		final Optional<Emple> SINJEFE = Optional.empty();
		List <Depart> departamentos = new ArrayList<>();
		Depart departamento;
		Emple empleado1,empleado2,empleado3;
		
		
		departamento = new Depart ("001", "Comercial", "Madrid");
		empleado1 = new Emple ("00001A","Miguel", false,
					LocalDate.of(1966, 7, 1),
					LocalDate.of(2000, 1, 20),
					34000,10000,"profe",
					SINJEFE);
		
		empleado2 = new Emple ("00002B","Ana Rosa", true,
				LocalDate.of(1996, 8, 12),
				LocalDate.of(2004, 12, 20),
				24000,5000,"secretaria",
				empleado1);
		
		empleado3 = new Emple ("00003C","Rodolfo", false,
				LocalDate.of(2002, 10, 1),
				LocalDate.of(2019, 9, 20),
				44000,15000,"jefe estudios",
				empleado1);
		
		departamento.addEmple(empleado1);
		departamento.addEmple(empleado2);
		departamento.addEmple(empleado3);
		departamentos.add(departamento);
		
		departamento = new Depart ("002", "Marketing", "Pamplona");
		empleado1 = new Emple ("00004D","Flora", true,
					LocalDate.of(1986, 4, 1),
					LocalDate.of(2010, 1, 20),
					34000,10000,"profe",
					SINJEFE);
		
		empleado2 = new Emple ("00005E","Mary", true,
				LocalDate.of(1999, 4, 1),
				LocalDate.of(2004, 1, 20),
				44000,13000,"profe",
				empleado1);
		
		empleado3 = new Emple ("00006F","Alfredo", false,
				LocalDate.of(1998, 7, 1),
				LocalDate.of(2018, 10, 20),
				34500,0,"profe mate",
				empleado1);
		
		departamento.addEmple(empleado1);
		departamento.addEmple(empleado2);
		departamento.addEmple(empleado3);
		departamentos.add(departamento);
		
		return departamentos;
	}

}

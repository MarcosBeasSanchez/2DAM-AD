package ejercicio;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

import daw.com.Teclado;

public class EjercicioStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Alumno> alumnos;
		Stream <Alumno> streamAlumnos;
		List <String> nombres;
		Function <String,String> sacarIniciales;
		String curso;
		
		alumnos = EjercicioLambdas.cargarAlumnos();
		
		
		// Ejercicio 1
		System.out.println("Ejercicio 1");
		/**
		// Forma 1
		nombres = alumnos.stream().
						filter(Alumno::isRepetidor). // filtrar repetidores
						filter(Alumno::estaAprobado). // filtrar aprobados
						map (Alumno::getNombre). // quedarnos s�lo con los nombres
						collect(toList()); // crear lista con los nombres
		
		sacarIniciales = s -> Arrays.stream(s.split(" ")). // convertir nombre y apellidos a stream
							map(p -> p.substring(0, 1).toUpperCase()). // convertir cada palabra a una s�la letra may�scula
							reduce("", (p1,p2)->p1+p2); // juntar las iniciales
		
		nombres.stream(). // convertir lista de nombres a stream
				map(sacarIniciales). // sacar iniciales de cada nombre
				forEach(System.out::println); // mostrar iniciales en pantalla
		**/
		
		/**
		// Forma 2
		alumnos.stream().
			filter(Alumno::isRepetidor). // filtrar repetidores
			filter(Alumno::estaAprobado). // filtrar aprobados
			map (Alumno::getNombre). // quedarnos s�lo con los nombres
			map(sacarIniciales). // quedarnos con las iniciales de los nombres
			forEach(System.out::println); //Mostrar inicales en pantalla
		**/
		
		// Forma 3
		alumnos.stream().
				filter(Alumno::isRepetidor). // filtrar repetidores
				filter(Alumno::estaAprobado). // filtrar aprobados
				map (Alumno::getNombre). // quedarnos s�lo con los nombres
				map(s -> Arrays.stream(s.split(" ")).
						map(p -> p.substring(0, 1).toUpperCase()).
						reduce("", (p1,p2)->p1+p2)). // quedarnos con las iniciales
				forEach(System.out::println); // Mostrar en pantalla

		// Ejercicio 2
		System.out.println("Ejercicio 2");
		alumnos.stream().
			filter (a -> a.getFecha().plusYears(18).isAfter(LocalDate.now())). // filtrar mayores de edad
			map (Alumno::getCurso). // quedarnos con los cursos
			distinct(). // eliminar cursos repetidos
			forEach(System.out::println); // Mostrar
		
		// Ejercicio 3
		// Forma 1
		System.out.println("Ejercicio 3 - Forma 1");
		
		alumnos.stream().
			collect(groupingBy(Alumno::getCurso)). // agrupar por curso
			forEach (								// mostar por pantalla, es un Map
					(c,listaAlumnos) -> 		// Clave c, valor listaAlumnos
					System.out.println(c + "->" + listaAlumnos)
					);
		
		System.out.println("Ejercicio 3  - Forma 2");
		alumnos.stream().
			collect(groupingBy(Alumno::getCurso,
							mapping (Alumno::getNombre,toList()))).
			forEach (
					(c,listaAlumnos) -> 
					System.out.println(c + "->" + listaAlumnos)
					);
		
		System.out.println("Ejercicio 4");
		alumnos.stream().
		collect(groupingBy((Alumno::getCurso), counting())). // agrupar por curso y contar
		forEach (								// mostar por pantalla, es un Map
				(c,cuantos) -> 		// Clave c, valor listaAlumnos
				System.out.println(c + "->" + cuantos)
				);

		System.out.println("Ejercicio 5");
		System.out.println (
				alumnos.stream().anyMatch (a -> a.getCurso().equals("DAM2"))?
						"Hay alumnos del curso DAM2":
						"No hay alumnos del curso DAM2");
		
		System.out.println("Ejercicio 6");
		List<String> cursos = alumnos.stream().
								map(Alumno::getCurso).
								distinct().
								collect(toList());
		do
		{
			cursos.forEach(System.out::println);	
			curso = Teclado.leerString("curso");			
		}while (!cursos.contains(curso));
		
		String cursoActual = curso;
		System.out.println(
				alumnos.stream().
					filter(a->a.getCurso().equals(cursoActual)).
					filter(Alumno::isRepetidor).
					sorted((a1,a2) -> Float.compare(a1.getNota(), a2.getNota())).
					findFirst().
					map(Alumno::getNombre).orElse("No hay alumnos"));
		
		System.out.println("Ejercicio 7");
				
		alumnos.stream().
			collect(groupingBy (Alumno::getCurso,counting())).
			forEach((c,cuantos) -> System.out.println(c + "->" + cuantos) );
		
		// Crear un Map con curso y n� de alumnos
		Map <String, Long> alumnosPorCursoMap = 		
				alumnos.stream().
					collect(groupingBy (Alumno::getCurso,counting()));
				
		Stream <Entry<String,Long>> alumnosPorCursoStream; 
		alumnosPorCursoStream = alumnosPorCursoMap.entrySet().stream();// Crear stream de un Map
		
		String cursoConMasAlumnos = 
				alumnosPorCursoStream.max(Entry.comparingByValue((v1,v2)->Long.compare(v1, v2))). 
				map(Entry::getKey).orElse("");
		System.out.println("El curso con m�s alumnos es " +cursoConMasAlumnos);
		
		//Calcular media del cursoConMasAlumnos
		double notaMedia = 
				 alumnos.stream().
				 	filter (a->a.getCurso().equals(cursoConMasAlumnos)).
				 	mapToDouble(Alumno::getNota).average().orElse(0);
			
		System.out.printf("La nota media del curso %s es de %.2f\n", cursoConMasAlumnos, notaMedia);
					
		
	}

}
package ejercicio;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EjercicioLambdas {

	
	
	
	public static void main(String[] args) {
		
		final Consumer<Object> ESCRIBIDOR = System.out::println;
		
		List <Alumno> alumnos;
		Comparator<Alumno> comparador1,comparador2, comparador3, comparador4;
		Predicate <Alumno> predicado1, predicado2,predicado3;
		Set<String> cursos;
		String curso;

		// Cargar alumnos
		alumnos = cargarAlumnos ();
		
		System.out.println("\nlistado de alumnos cargados");
		alumnos.forEach(ESCRIBIDOR);
		
		// ordenar por nombre
		comparador1 = (a,b) -> a.getNombre().compareToIgnoreCase(b.getNombre());
		alumnos.sort(comparador1);
		
		///alumnos.stream().sorted(comparador1)
		
		// ordenar por nombre inverso
		alumnos.sort(comparador1.reversed());
		
		// ordenar por fecha y nombre
		comparador2 = (a,b) -> a.getFecha().compareTo(b.getFecha());
		
		alumnos.sort(comparador2.thenComparing(comparador1));
		
		// ordenar por curso y nota
		comparador4 = (a,b) -> a.getCurso().compareToIgnoreCase(b.getCurso());
		comparador3 = (a,b) -> Float.compare(a.getNota(), b.getNota());
		alumnos.sort(comparador4.thenComparing(comparador3));
		
		cursos = new HashSet<String> ();
		
		alumnos.forEach(a -> cursos.add(a.getCurso()));	
		// lectura del curso
		do
		{
			System.out.println("cursos disponibles");
			cursos.forEach(ESCRIBIDOR);
			curso = Teclado.leerString("\nCurso").toUpperCase();		
		}while (!cursos.contains(curso));
		
		String cursoActual = curso;
		
		predicado1 = (a) -> a.getCurso().equals(cursoActual);
		predicado2 = Alumno::estaAprobado;
		predicado3 = a -> a.getFecha().isAfter(LocalDate.now().minusYears(18));
		
		List <Alumno> copiaAlumnos = new ArrayList<>(alumnos);
		copiaAlumnos.removeIf(predicado1.negate().or(predicado2.negate()));
		
		
		System.out.println("\nlistado de alumnos aprobados en el curso " + curso);
		copiaAlumnos.forEach(a-> Pantalla.escribirString(a.getNombre() + " " + a.getNota() + "\n"));

		//Con stream
		alumnos.stream().filter(predicado1.and(predicado2)).map(Alumno::getNombre).forEach(ESCRIBIDOR);
		
		System.out.println("alumno más joven");
		Pantalla.escribirString(Collections.max(alumnos, comparador2)+"\n");
		System.out.println("alumno más viejuno");
		Pantalla.escribirString(Collections.min(alumnos, comparador2)+"\n");
		
		//Con streams
		alumnos.stream()
		.max(comparador2)
		.ifPresentOrElse(ESCRIBIDOR,()-> System.out.println("No hay nota"));
		
		//Alumnnos repetidores que hayan aprobado
		System.out.println("\nINICIALES ALUMNOS REPETIDORES QUE HAN APROBADO"); 
		List<String> inicialesAlumnosRepetidoresAprobados = alumnos.stream()
                .filter(alumno -> alumno.isRepetidor() && alumno.getNota() >= 5.0)
                .map(alumno -> obtenerIniciales(alumno.getNombre()))
                .collect(Collectors.toList());
                
		System.out.println(inicialesAlumnosRepetidoresAprobados);
		
        //Cursos donde hay menores
		System.out.println("\nCURSOS DONDE HAY MENORES");
		Set<String> cursosConMenores = alumnos.stream()
                .filter(predicado3)
                .map(Alumno::getCurso)
                .collect(Collectors.toSet()); //falta hacer el ifPresentOrElse
		;
		
		
		System.out.println("Cursos con alumnos menores de edad: " + cursosConMenores);
	}
	
	public static String obtenerIniciales(String nombre) {
        String[] partesNombre = nombre.split(" ");
        StringBuilder iniciales = new StringBuilder();
        for (String parte : partesNombre) {
            iniciales.append(parte.charAt(0));
        }
        return iniciales.toString();
    }
	
	public static List<Alumno> cargarAlumnos ()
	{
		List <Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno;
		try (BufferedReader fichero = new BufferedReader (new FileReader ("alumnos.csv")) )
		{
			
			while (fichero.ready())
			{
				alumno = Alumno.fromCSV(fichero.readLine());
				alumnos.add(alumno);
			}
			
			/*alumnos = fichero.lines(). // obtener lineas de fichero como stream
			 * 				map(Alumno::fromCSV).// convertir la linea a un alumno
			 * 				toList();// convertir stream de alumnos a lista
			 */
			
		}
		
		catch (IOException e)
		{
			Pantalla.escribirString("\nError accediendo al fichero...");
			
		}
		
		return alumnos;
	}

}

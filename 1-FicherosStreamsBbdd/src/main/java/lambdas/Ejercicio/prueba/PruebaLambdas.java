package lambdas.Ejercicio.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PruebaLambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<>();
		List<Alumno> alumnos1 = new ArrayList<>();
		
		Consumer<Alumno> escribidor, insertador;
		Predicate<Alumno> mayorDeEdad;
		Supplier<Alumno> productor;
		
		Alumno a1,a2,a3,a4;
    	a1 = Alumno.builder().
				dni("001").
				nombre("a1").
				edad(20).
				build();

		a2 = Alumno.builder().
				dni("002").
				nombre("a2").
				build();

		alumnos.add(a1);
		
		alumnos.add(a2);
		
		escribidor = System.out::println;
		
		alumnos.forEach(escribidor);
		
		mayorDeEdad =  a -> a.getEdad() >= 18;
		
		alumnos.removeIf(mayorDeEdad.negate());
		
		alumnos.forEach(escribidor);
		
		productor = () -> new Alumno ("00"+Math.random());
		
		alumnos.add (productor.get());
		alumnos.add (productor.get());
		
		alumnos.forEach(escribidor);
		
		insertador = alumnos1::add;
		
		alumnos.forEach(insertador);
	}

}

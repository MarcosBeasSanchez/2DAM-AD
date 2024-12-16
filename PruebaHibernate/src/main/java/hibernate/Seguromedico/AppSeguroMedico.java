package hibernate.Seguromedico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import hibernate.muchosamuchos.dao.GenericJPADAO;

public class AppSeguroMedico {
	
	static final String UNIDADPERSISTENCIA = "SeguroMedico";
	private GenericJPADAO<Seguro, Integer> seguroDao;
	private GenericJPADAO<AsistenciaMedica, Integer> AsistenciaMedicaDao;
	
	public AppSeguroMedico() {
		seguroDao = new GenericJPADAO<Seguro, Integer>(Seguro.class,UNIDADPERSISTENCIA);
		AsistenciaMedicaDao = new GenericJPADAO<AsistenciaMedica, Integer>(AsistenciaMedica.class,UNIDADPERSISTENCIA);
	}

	public static void main(String[] args) {
		
		AppSeguroMedico app = new AppSeguroMedico();
	
		//onetomany
		app.cargarDatos();
		
		//Lanza una consulta que nos retorne todos los seguros que hay en la base de datos
		app.mostrarTodosSeguros();
		//Lanza una consulta que nos retorne solo las columnas NIF y Nombre de todos los seguros
		app.mostrarNifyNombre();
		
		//Lanza una consulta que nos retorne sólo el NIF para el seguro con nombre “Marcos Tortosa
		//Oltra”.
		app.MarcosTortosaOltra();
		
		//Crea una consulta que retornará aquellas AsistenciaMedica con importe mayor o igual a
		//10.000 €.
		app.Mayor10000();
		
		//Lanza una consulta que retorne el idAsistenciaMedica de todas las asistencias médicas cuyo
		//saldo esté entre 2.000 y 5.000 euros. Usa parámetros por posición para los valores 2000 y 5000
		
		
		//Lanza una consulta que calcule la suma de todos los importes de todas las asistencias
		//médicas. Haz que se muestren en pantalla.
		
		//Lanza una consulta que calcule el saldo medio de todas las asistencias médicas. Haz que se
		//muestren en pantalla.
		
		//Lanza una consulta que calcule cuantos seguros hay. Haz que se muestren en pantalla.
		
		//Lanza una consulta que muestre para cada seguro cuántas asistencias médicas posee. Haz
		//que se muestren en pantalla.
		
		//Lanza una consulta que obtenga todos los objetos Seguro en la parte del FROM pero que en
		//la parte del SELECT retorne el nombre de la alergia que padecen (algunos valdrán null) .
		
		//Lanza una consulta que retorne todos los seguros. Haz que se muestre en pantalla el
		//idAsistenciaMedica de cada asistencia médica (No debes lanzar otra consulta). Comprueba
		//cuántas consultas lanza Hibernate internamente.
		
		
	}
	
	private void Mayor10000() {
		String query = "SELECT a FROM AsistenciaMedica a WHERE a.importe <=?1";
		AsistenciaMedicaDao.executeQuery(query, 10000).forEach(System.out::println);
		
	}

	private void MarcosTortosaOltra() {
		String query = "SELECT s.nif FROM Seguro s WHERE s.nombre=?1 AND s.ape1=?2 AND s.ape2=?3";
		seguroDao.executeQuery(query, "Marcos","Tortosa", "Oltra").forEach(System.out::println);
	}

	private void mostrarNifyNombre() {
		Stream<Object[]>arrayStream;
		String  query = "SELECT s.nif,s.nombre FROM Seguro s";
		arrayStream = seguroDao.executeQuery(query);
		arrayStream.forEach(q -> System.out.println(q[0] +" , " + q[1]));
	}

	private void mostrarTodosSeguros() {
		String query = "SELECT s FROM Seguro s";
		seguroDao.executeQuery(query).forEach(System.out::println);;
		//seguroDao.findAll().forEach(System.out::println);
	}

	public void cargarDatos() {
		
		List<Seguro> seguros = new ArrayList<>();

		AsistenciaMedica a1,a2,a3,a4;
		Seguro s1,s2,s3;

		a1 = AsistenciaMedica.builder().
				breveDescripcion("a1").
				explicacion("la primera").
				fechaYHora(LocalDateTime.now()).
				importe(100).
				lugar("Maestranza").
				tipoAsistencia("normal").
				build();

		a2 = AsistenciaMedica.builder().
				breveDescripcion("a2").
				explicacion("la segunda").
				fechaYHora(LocalDateTime.now().minusDays(3)).
				importe(200).
				lugar("Maestranza").
				tipoAsistencia("urgente").
				build();

		a3 = AsistenciaMedica.builder().
				breveDescripcion("a3").
				explicacion("la tercera").
				fechaYHora(LocalDateTime.now().minusMonths(2)).
				importe(100).
				lugar("La Paz").
				tipoAsistencia("normal").
				build();

		a4 = AsistenciaMedica.builder().
				breveDescripcion("a4").
				explicacion("la cuarta").
				fechaYHora(LocalDateTime.now()).
				importe(130).
				lugar("Maestranza").
				tipoAsistencia("revision").
				build();
		


		s1 = Seguro.builder().
						ape1("Sutil").
						ape2("Martin").
						casado(false).
						coberturas(Coberturas.builder().
										dental(false).
										fecundacionInVitro(false).
										oftalmologia(true).
										build()).
						edad(45).
						embarazada(false).
						enfermedades(Enfermedades.builder().
										alergia(true).
										nombreAlergia("Al trabajo").
										build()).
						fechaCreacion(LocalDate.now().minusWeeks(45)).
						nif("001").
						nombre("Miguel").
						numHijos(2).
						sexo(Sexo.HOMBRE).
						asistencia(a1).
						asistencia(a2).
						build();


		s2 = Seguro.builder().
				ape1("Cordero").
				ape2("Gonzalez").
				casado(false).
				coberturas(Coberturas.builder().
								dental(true).
								fecundacionInVitro(false).
								oftalmologia(true).
								build()).
				edad(48).
				embarazada(false).
				enfermedades(Enfermedades.builder().
								alergia(true).
								nombreAlergia("renitis").
								estomacal(true).
								build()).
				fechaCreacion(LocalDate.now().minusWeeks(5)).
				nif("002").
				nombre("Rosa").
				numHijos(2).
				sexo(Sexo.MUJER).
				asistencia(a3).
				asistencia(a4).
				build();

		s3 = Seguro.builder().
				ape1("Sanchez").
				ape2("Gonzalez").
				casado(true).
				coberturas(Coberturas.builder().
								dental(true).
								fecundacionInVitro(false).
								oftalmologia(true).
								build()).
				edad(68).
				embarazada(false).
				enfermedades(Enfermedades.builder().
								alergia(true).
								nombreAlergia("polen olivo").
								estomacal(false).
								build()).
				fechaCreacion(LocalDate.now().minusWeeks(5)).
				nif("003").
				nombre("Juan").
				numHijos(3).
				sexo(Sexo.HOMBRE).
				build();
		
		seguroDao.save(s1);
		seguroDao.save(s2);
		seguroDao.save(s3);
		
		System.out.println("DATOS CARGADOS CORRECTAMENTE");
		//seguros.add(s1);
		//seguros.add(s2);
		//seguros.add(s3);

		//return seguros;
	}
	

}

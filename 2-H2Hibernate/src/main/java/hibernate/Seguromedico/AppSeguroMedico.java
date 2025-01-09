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
	
		//ONE TO MANY
		app.cargarDatos();
		
		app.mostrarTodosSeguros();
		System.out.println("--------------------------");
		app.mostrarNifyNombre();
		System.out.println("--------------------------");
		app.marcosTortosaOltra();
		System.out.println("--------------------------");
		app.mayor10000();
		System.out.println("--------------------------");
		app.asistenciaSaldo2000_5000();
		System.out.println("--------------------------");
		app.sumaImportesAsistencias();
		System.out.println("--------------------------");
		app.saldoMedio();
		System.out.println("--------------------------");
		app.cuantosSeguros();
		System.out.println("--------------------------");
		app.cuantasAsistenciasPorSeguro();
		System.out.println("--------------------------");
		app.consulta();
		System.out.println("--------------------------");
		//app.todosLosSegurosIdAsistenciaMedica();
		
		
	}
	
	private void todosLosSegurosIdAsistenciaMedica() {
		//Lanza una consulta que retorne todos los seguros. Haz que se muestre en pantalla el
		//idAsistenciaMedica de cada asistencia médica (No debes lanzar otra consulta). Comprueba
		//cuántas consultas lanza Hibernate internamente.
		System.out.println("EJERCICIO-11");
		String query = "SELECT s.asistencias.idAsistenciaMedica FROM Seguro s";
		seguroDao.executeQuery(query).forEach(System.out::println);
	}

	private void consulta() {
		//Lanza una consulta que obtenga todos los objetos Seguro en la parte del FROM pero que en
		//la parte del SELECT retorne el nombre de la alergia que padecen (algunos valdrán null) .
		System.out.println("EJERCICIO-10");
		String query = "SELECT s.enfermedades.nombreAlergia FROM Seguro s";
		seguroDao.executeQuery(query).forEach(System.out::println);
	}

	private void cuantasAsistenciasPorSeguro() {
		//Lanza una consulta que muestre para cada seguro cuántas asistencias médicas posee	
		System.out.println("EJERCICIO-9");
		String query = "SELECT SIZE(s.asistencias) FROM Seguro s";
		int[] c = {1};
		seguroDao.executeQuery(query).forEach(a -> System.out.println("Seguro " + (c[0]++) + " -> " + a));

	}

	private void cuantosSeguros() {
		//Lanza una consulta que calcule cuantos seguros hay. Haz que se muestren en pantalla.
		String query = "SELECT COUNT (q) FROM Seguro q";
		System.out.println("EJERCICIO-8");
		seguroDao.executeQuery(query).forEach( a -> System.out.println("Total de Seguros -> " + a));;

	}

	private void saldoMedio() {
		//Lanza una consulta que calcule el saldo medio de todas las asistencias médicas
		System.out.println("EJERCICIO-7");
		String query = "SELECT AVG(q.importe) FROM AsistenciaMedica q";
		AsistenciaMedicaDao.executeQuery(query).forEach(a -> System.out.println("Saldo medio de todas las Asistencias Medicas -> " + a));;

	}

	private void sumaImportesAsistencias() {
		//Lanza una consulta que calcule la suma de todos los importes de todas las asistencias médicas
		System.out.println("EJERCICIO-6");
		String query = "SELECT SUM(q.importe) FROM AsistenciaMedica q";
		AsistenciaMedicaDao.executeQuery(query).forEach(a-> System.out.println("Suma total de importes de todas las asistencias medicas -> " +  a));;

		
	}

	private void asistenciaSaldo2000_5000() {
		//Lanza una consulta que retorne el idAsistenciaMedica de todas las asistencias médicas cuyo
		//saldo esté entre 2.000 y 5.000 euros. Usa parámetros por posición para los valores 2000 y 5000
		System.out.println("EJERCICIO-5");
		String query = "SELECT a.idAsistenciaMedica FROM AsistenciaMedica a WHERE a.importe BETWEEN ?1 AND ?2";
		AsistenciaMedicaDao.executeQuery(query,2000f,5000f).forEach(a-> System.out.println("ID -> " +  a));;
	}

	private void mayor10000() {
		//Crea una consulta que retornará aquellas AsistenciaMedica con importe mayor o igual a 10.000 €.
		System.out.println("EJERCICIO-4");
		String query = "SELECT a FROM AsistenciaMedica a WHERE a.importe <=?1";
		AsistenciaMedicaDao.executeQuery(query, 11000f).forEach(System.out::println);
		
	}

	private void marcosTortosaOltra() {
		//Lanza una consulta que nos retorne sólo el NIF para el seguro con nombre “Marcos Tortosa Oltra”.
		System.out.println("EJERCICIO-3");
		String query = "SELECT s.nif FROM Seguro s WHERE s.nombre=?1 AND s.ape1=?2 AND s.ape2=?3";
		seguroDao.executeQuery(query, "Marcos","Tortosa", "Oltra").forEach(System.out::println);
	}

	private void mostrarNifyNombre() {
		//Lanza una consulta que nos retorne solo las columnas NIF y Nombre de todos los seguros
		System.out.println("EJERCICIO-2");
		Stream<Object[]>arrayStream;
		String  query = "SELECT s.nif,s.nombre FROM Seguro s";
		arrayStream = seguroDao.executeQuery(query);
		arrayStream.forEach(q -> System.out.println(q[0] +" , " + q[1]));
	}

	private void mostrarTodosSeguros() {
		//Lanza una consulta que nos retorne todos los seguros que hay en la base de datos
		System.out.println("EJERCICIO-1");
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
				importe(4000).
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
				importe(11000).
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
										nombreAlergia("Alergia a el polen").
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
				ape1("Tortosa").
				ape2("Oltra").
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
								nombreAlergia("Alergia a las algas").
								estomacal(true).
								build()).
				fechaCreacion(LocalDate.now().minusWeeks(5)).
				nif("002").
				nombre("Marcos").
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
								nombreAlergia("Alergia a trabajar").
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

package hibernate.muchosamuchos;


import java.time.LocalDate;
import hibernate.muchosamuchos.dao.GenericJPADAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AppGruposAlumnosModulo {
	
	
	//no funciona este ejercicio en h2 mirarlo por encima las exepciones
	
	
	//alumno -> dni,nommbre,fechanacimeinto,direccion
	//
	//direccion-> calle,portal y poblacion
	//profesor->dni, nombre, especialidad(String)
	//
	//grupo-> nombre(@id),ubicacion, Set(alumnos),Profesor
	//(un grupo tiene varios alumnos y un solo profesor)
	//modulo-> id,nombre,profesor
	//(un alumo tiene una nota en un modulo)



	//cargarDatos()
	//ponernotas()
	//eliminar alumnos de un grupo
	//listar los distitos modulos que cursan los alumnos de un grupo
	//subir un punto a todos los alumnos en un modulo
	//mostrar los alumnos aprobados de un modulo
	//

	static final String UNIDADPERSISTENCIA = "muchosamuchos";
	private GenericJPADAO <Alumno,String> alumnoDAO ;
	private GenericJPADAO <Grupo,String> grupoDAO ;
	private GenericJPADAO <Profesor,String> profeDAO ;
	private GenericJPADAO <Modulo,String> moduloDAO ;
	private GenericJPADAO <Calificacion,Integer> calificacionDAO ;
	public AppGruposAlumnosModulo ()
	{
		
		grupoDAO = new GenericJPADAO(Grupo.class,UNIDADPERSISTENCIA);
		alumnoDAO = new GenericJPADAO(Alumno.class,UNIDADPERSISTENCIA);
		profeDAO = new GenericJPADAO(Profesor.class,UNIDADPERSISTENCIA);
		moduloDAO = new GenericJPADAO(Modulo.class,UNIDADPERSISTENCIA);
		calificacionDAO = new GenericJPADAO(Calificacion.class,UNIDADPERSISTENCIA);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppGruposAlumnosModulo app = new AppGruposAlumnosModulo ();
		
		app.cargarDatos ();
		
		// Poner calificaciones a varios alumnos en varios módulos
		app.ponerNotas();
		
		// Eliminar alumnos de un grupo
		app.eliminarAlumnosGrupo ();

		// Listar los distintos módulos que cursan los alumnos de un grupo.
		app.listarModulosGrupos();
		
		// Subir un punto a todos los alumnos en un módulo.
		app.subirUnPunto ();
		
		//Mostrar los alumnos aprobados de un módulo.
		app.mostrarAprobados ();
		
		System.out.println("fin");
	}
	
	public void mostrarAprobados() {
		// TODO Auto-generated method stub
		String modulo = "DAM02";

		/*
		//obtener todas las calificaciones
		List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();
		
		// filtrar y mostrar
		calificaciones.stream().
						filter(c -> c.getModulo().getId().equals(modulo) && 
								c.getNota()> 4).
						map(Calificacion::getAlumno).
						forEach(System.out::println);
		
		*/
		String query ="SELECT c.alumno FROM Calificacion c WHERE c.modulo.id = ?1 AND c.nota > 5";
		
		calificacionDAO.executeQuery(query, modulo).forEach(System.out::println);
	
	}

	public void subirUnPunto() {
		// TODO Auto-generated method stub
		String modulo = "DAM02";
		
		// Comprobar que se va a hacer la actualización
		System.out.println("antes de actualizar");
		calificacionDAO.findAll().forEach(System.out::println);
		
		/*
		//obtener todas las calificaciones
		List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();
	
		calificaciones.stream().
						filter(c -> c.getModulo().getId().equals(modulo)). // filtrar calificaciones de un módulo
						map(c -> {c.setNota(c.getNota() + 1);
									return c;}). // Actualizar calificaciones
						forEach(calificacionDAO::update); // Guardar actualilzación en la BBDD
		*/
		
		String query ="UPDATE Calificacion c SET c.nota = c.nota +1 WHERE c.modulo.id = ?1 AND c.nota < 10";
		
		calificacionDAO.executeQuery(query, modulo);
		
		// Comprobar que se ha hecho la actualización
		System.out.println("después de actualizar");
		calificacionDAO.findAll().forEach(System.out::println);
		
	}

	public void eliminarAlumnosGrupo() {
		// TODO Auto-generated method stub
		String grupo = "g1";
		
		System.out.println("alumnos antes de borrar en el grupo " + grupo);
		grupoDAO.findById(grupo).
				orElseGet(Grupo::new).
				getAlumnos().
				forEach(System.out::println);
		
		/*
		grupoDAO.findById(grupo). // obtener grupo
				map(Grupo::getAlumnos). // obtener alumnos del grupo
				ifPresentOrElse(alumnos -> alumnos.forEach(alumnoDAO::delete), // eliminar alumnos
						() -> System.out.println("sin datos"));
		
		*/

		
		String query = "DELETE FROM Alumno a WHERE a IN "
				+ "(SELECT al FROM Grupo g JOIN g.alumnos al WHERE g.nombre = ?1)";
		
		alumnoDAO.executeQuery(query, grupo);
		
		System.out.println("alumnos después de borrar en el grupo " + grupo);
		grupoDAO.findById(grupo).
				orElseGet(Grupo::new).
				getAlumnos().
				forEach(System.out::println);
	}

	public void listarModulosGrupos ()
	{
		// obtener alumnos grupo
		String grupo = "g2"; 
		
		/*
		Set<Alumno> alumnos =  grupoDAO.findById(grupo).orElseGet(Grupo::new).getAlumnos();
		List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();
 		calificaciones.stream().filter(c -> alumnos.contains(c.getAlumno())).
 				map(Calificacion::getModulo).
 				map(Modulo::getNombre).
 				forEach(System.out::println);
 		*/
		
 		String query = "SELECT DISTINCT c.modulo.nombre FROM Calificacion c "
 				+ "WHERE c.alumno IN "
 				+ "(SELECT a FROM Grupo g JOIN g.alumnos a "
 				+ "WHERE g.nombre = ?1)";
 		
 		calificacionDAO.executeQuery(query, grupo).forEach(System.out::println);
 		
	}
	
	public void ponerNotas() {
		// TODO Auto-generated method stub
		Calificacion calificacion;
		Alumno a = alumnoDAO.findById("a000002").get();
		Modulo m = moduloDAO.findById("DAM01").get();
		
		calificacion = Calificacion.builder().alumno(a).modulo(m).nota(12).build();
		
		// se guarda automaticamente alumno y modulo , porque no hay cascade
		calificacionDAO.save(calificacion);
		
		a = alumnoDAO.findById("a000003").get();
		m = moduloDAO.findById("DAM01").get();
		
		calificacion = Calificacion.builder().
				alumno(a).modulo(m).nota(2).build();
		
		calificacionDAO.save(calificacion);
		
		a = alumnoDAO.findById("a000003").get();
		m = moduloDAO.findById("DAM02").get();
		
		calificacion = Calificacion.builder().
				alumno(a).modulo(m).nota(8).build();
		
		calificacionDAO.save(calificacion);
		
		a = alumnoDAO.findById("a000004").get();
		m = moduloDAO.findById("DAM03").get();
		
		calificacion = Calificacion.builder().
				alumno(a).modulo(m).nota(3).build();
		
		calificacionDAO.save(calificacion);
	}

	public void cargarDatos ()
	{
		Profesor p1,p2;
		Alumno a1,a2,a3,a4,a5;
		Grupo g1,g2;
		Modulo m1,m2,m3,m4;
		
		
		p1 = Profesor.builder().dni("00000001").
						nombre("profesor 1").
						especialidad("infor").
						build();
		//profeDAO.save(p1);
		
		p2 = Profesor.builder().dni("00000002").
				nombre("profesor 2").
				especialidad("ciencia").
				build();
		//profeDAO.save(p2);
		
		a1 = Alumno.builder().dni("a000001").
						nombre("Alumno 1").
						fechaNacimiento(LocalDate.now().minusYears(20)).
						direccion(Direccion.builder().
								calle("calle").
								portal(1).
								poblacion("Madrid").
								build()).
						build();
		
		
		a2 = Alumno.builder().dni("a000002").
				nombre("Alumno 2").
				fechaNacimiento(LocalDate.now().minusYears(20)).
				direccion(Direccion.builder().
						calle("calle").
						portal(2).
						poblacion("Madrid").
						build()).
				build();
		
		a3 = Alumno.builder().dni("a000003").
				nombre("Alumno 3").
				fechaNacimiento(LocalDate.now().minusYears(20)).
				direccion(Direccion.builder().
						calle("calle").
						portal(3).
						poblacion("Madrid").
						build()).
				build();
		
		a4 = Alumno.builder().dni("a000004").
				nombre("Alumno 4").
				fechaNacimiento(LocalDate.now().minusYears(20)).
				direccion(Direccion.builder().
						calle("calle").
						portal(4).
						poblacion("Madrid").
						build()).
				build();
		
		a5 = Alumno.builder().dni("a000005").
				nombre("Alumno 5").
				fechaNacimiento(LocalDate.now().minusYears(20)).
				direccion(Direccion.builder().
						calle("calle").
						portal(5).
						poblacion("Madrid").
						build()).
				build();
		/*
		alumnoDAO.save(a1);
		alumnoDAO.save(a2);
		alumnoDAO.save(a3);
		alumnoDAO.save(a4);
		alumnoDAO.save(a5);
		*/
		g1 = Grupo.builder().
				nombre("g1").
				ubicacion("101").
				alumno(a1).
				alumno(a2).
				tutor(p1).
				build();
		//se va a dar cuenta que no exite y creara alumnos y profesor
		//(por el cascade)
		grupoDAO.save(g1);
		
		g2 = Grupo.builder().
				nombre("g2").
				ubicacion("102").
				alumno(a3).
				alumno(a4).
				alumno(a5).
				tutor(p2).
				build();
		grupoDAO.save(g2);
		
		
		m1 = Modulo.builder().
					id("DAM01").
					nombre("Mod1").
					profesor(p1).
					build();
		m2 = Modulo.builder().
				id("DAM02").
				nombre("Mod2").
				profesor(p1).
				build();
		m3 = Modulo.builder().
				id("DAM03").
				nombre("Mod3").
				profesor(p2).
				build();
		m4 = Modulo.builder().
				id("DAM04").
				nombre("Mod4").
				profesor(p2).
				build();
		
		moduloDAO.save(m1);
		moduloDAO.save(m2);
		moduloDAO.save(m3);
		moduloDAO.save(m4);
	}
}

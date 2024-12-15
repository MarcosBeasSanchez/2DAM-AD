package hibernate.muchosauno;

import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import hibernate.muchosauno.modelo.*;
import hibernate.pruebaHibernate.dao.GenericJPADAO;

public class AppGrupos {

	public static void main(String[] args) {
		/*
		 * 1. Crear las tablas 2.Crear una app que haga -Insertar 2 grupos -Insertar 3
		 * alumnos -Cambiar 1 alumno de grupo -Borrar 1 alumno -Borrar un grupo 3.
		 * Mostrar los datos de un grupo
		 */
		Logger.getLogger("org.hibernate").setLevel(Level.OFF); // quitar letras rojas al hacer run
		System.out.println("Hello World!");
		
		GenericJPADAO<Alumno, Integer> alumnoDao;
		GenericJPADAO<Grupo, Long> grupoDao;
		alumnoDao=new GenericJPADAO<>(Alumno.class,"hibernate");
	    grupoDao=new GenericJPADAO<>(Grupo.class,"hibernate");
		Alumno a1, a2, a3;
		Grupo g1, g2;

		// Insertar Grupos
		g1 = Grupo.builder().idGrupo(1L).nombre("Grupo1").tutor("Mario").curso(1).build();
		g2 = Grupo.builder().idGrupo(2L).nombre("Grupo2").tutor("Miguel").curso(2).build();
		
		// Insertar alumnos
		a1=Alumno.builder().firstName("juan").fecha(LocalDate.now().minusYears(1)).grupo(g1).build();		
		//Alumno alumno = new Alumno("Miguel", LocalDate.now(), g1); 
		a2 = Alumno.builder().firstName("rosa").fecha(LocalDate.now().minusWeeks(6)).grupo(g2).build();
		a3 = Alumno.builder().firstName("manolo").fecha(LocalDate.of(2000, 12, 12)).grupo(g1).build();

		System.out.println("Insertando gurpos..."); // no hace falta xq los alumnos tienen los grupos dentro
		// grupo1 = grupoDao.save(grupo1);
		// grupo2 = grupoDao.save(grupo2);

		System.out.println("Insertando alumnos...");
		a1 = alumnoDao.save(a1);
		a2 = alumnoDao.save(a2);
		a3 = alumnoDao.save(a3);
		
		
		System.out.println("Cambiar 1 alumno de grupo...");
		   Alumno alumnoActualizar=alumnoDao.findById(1).orElseGet(Alumno::new);
		   alumnoActualizar.setGrupo(g2);
		   System.out.println("\nAlumno 1 datos despues:"+alumnoDao.update(alumnoActualizar));
		   
		   
		   System.out.println("Borrar  Alumno 2..."); 
		   Alumno alumnoBorrar=alumnoDao.findById(2).orElseGet(Alumno::new);
		   alumnoDao.delete(alumnoBorrar);
		   
		   
		   
		   System.out.println("Borrar  Grupo 1..."); 
		   Optional<Grupo> gr= grupoDao.findById(1L);
		   Long idGrupo = gr.map(Grupo::getIdGrupo).orElse(0L);
		   alumnoDao.executeQuery("SELECT a FROM Alumno a WHERE a.grupo.idGrupo = ?1", 
				   
					idGrupo).forEach(a->{((Alumno) a).setGrupo(g2);  //cambiar los alumnos de grupo antes de borrar el grupo
					alumnoDao.update((Alumno) a);
					});
		   grupoDao.delete(g1);
		   
		   
		   
		   System.out.println(" Mostrar los datos de un grupo"); 
		   Optional<Grupo> g= grupoDao.findById(2L);
		   
		   alumnoDao.executeQuery("SELECT a FROM Alumno a WHERE a.grupo.idGrupo = ?1", 
					g.get().getIdGrupo()).forEach(System.out::println);    

	}

}

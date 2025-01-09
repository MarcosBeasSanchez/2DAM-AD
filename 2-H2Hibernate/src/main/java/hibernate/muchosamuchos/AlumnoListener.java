package hibernate.muchosamuchos;
import java.util.List;

import javax.persistence.PreRemove;

import hibernate.muchosamuchos.dao.GenericJPADAO;


public class AlumnoListener {
	private final String UNIDADPERSISTENCIA = "muchosamuchos";
	@PreRemove
	public void borradoAlumno (Alumno alumno)
	{

		GenericJPADAO <Calificacion,Integer> calificacionDAO;
		calificacionDAO = new GenericJPADAO(Calificacion.class,UNIDADPERSISTENCIA);
		/*
		 //otra version
		List<Calificacion> calificaciones  = (List<Calificacion>) calificacionDAO.findAll();
		
		calificaciones.stream().
				filter(c ->c.getAlumno().equals(alumno)).
				forEach(calificacionDAO::delete);
		*/
		//solo borra a lo que accede, no trae todo
		String query = "DELETE FROM Calificacion c WHERE c.alumno.dni = ?1";
		calificacionDAO.executeQuery(query, alumno.getDni());
	}

}

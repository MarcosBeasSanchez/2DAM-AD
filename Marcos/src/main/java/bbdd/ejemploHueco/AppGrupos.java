package bbdd.ejemploHueco;

import bbdd.ejemploHueco.controladores.AlumnoControlador;
import bbdd.ejemploHueco.dao.AlumnoDAO;
import bbdd.ejemploHueco.modelo.Alumno;
import bbdd.ejemploHueco.vistas.Vista;

public class AppGrupos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Leer y mostrar un alumno
		Alumno alumno = new Alumno ();
		AlumnoControlador alumnoControlador;
		Vista alumnoVista;
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		
		alumnoControlador = new AlumnoControlador (alumno);
		alumnoControlador.leerDatos();
		
		alumnoDAO.findById("001").
				ifPresentOrElse(null, null);
		
		alumnoVista = new AlumnoVista(alumno);
		alumnoVista.mostrarModelo();
		
		
	}

}

package basedatos.app;

import java.util.function.Consumer;

import basedatos.Service;
import basedatos.unidirecional1an.ControladorDepart;
import basedatos.unidirecional1an.Depart;
import basedatos.unidirecional1an.DepartDAO;
import basedatos.unidirecional1an.VistaDepart;

public class Listar implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		DepartDAO dao = new DepartDAO ();
	
		// Función para mostrar un deparamento
		Consumer<Depart> mostrarDepart = d -> new VistaDepart (d).mostrarModelo();
		
		//Buscar y mostrar todos los Departamentos y Empleados
		dao.findAll().forEach(mostrarDepart);

	}

}

package hibernate.ejercicioExamen.banco.acciones;

import hibernate.ejercicioExamen.banco.dao.GenericJPADAO;
import hibernate.ejercicioExamen.banco.modelo.Cliente;
import hibernate.ejercicioExamen.banco.modelo.Contacto;
import hibernate.ejercicioExamen.banco.modelo.Cuenta;


public class AccionBanco {

	private final static String UNIDADPERSISTENCIA = "banco";
	protected static GenericJPADAO<Cliente,String> clienteDAO = new GenericJPADAO<Cliente,String> (Cliente.class,UNIDADPERSISTENCIA);
	protected static GenericJPADAO<Cuenta,String> cuentaDAO = new GenericJPADAO<Cuenta,String> (Cuenta.class,UNIDADPERSISTENCIA);
	protected GenericJPADAO<Contacto,String> contactoDAO = new GenericJPADAO<Contacto,String> (Contacto.class,UNIDADPERSISTENCIA);
	
	/*
	public AccionBanco ()
	{
		clienteDAO = new GenericJPADAO<Cliente,String> (Cliente.class,UNIDADPERSISTENCIA);
		cuentaDAO = new GenericJPADAO<Cuenta,String> (Cuenta.class,UNIDADPERSISTENCIA);

	}

	*/
}

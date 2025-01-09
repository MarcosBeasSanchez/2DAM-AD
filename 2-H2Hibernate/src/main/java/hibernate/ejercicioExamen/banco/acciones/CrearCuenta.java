package hibernate.ejercicioExamen.banco.acciones;


import hibernate.ejercicioExamen.banco.modelo.Cliente;
import hibernate.ejercicioExamen.banco.modelo.Contacto;
import hibernate.ejercicioExamen.banco.modelo.Cuenta;
import hibernate.ejercicioExamen.banco.modelo.CuentaEmpresa;
import hibernate.ejercicioExamen.banco.modelo.CuentaPersonal;
import utilidadesmenu.MenuAction;
import daw.com.Teclado;

public class CrearCuenta extends AccionBanco implements MenuAction {

	private Cuenta cuenta;
	
	public CrearCuenta ()
	{
		cuenta = null;
	}
	
	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		
		// leer el tipo de cuenta a crear
		leerTipoCuenta ();
			
		// leer clientes
		leerClientes ();
		
		// leerDatosCuenta
		leerDatosCuenta ();
		
		// Mostrar cuenta leída
		System.out.println(cuenta);
		
		// insertar cuenta en BBDD
		cuentaDAO.save(cuenta);
		
		System.out.println("cuenta creada correctamente");
	}

	private void leerTipoCuenta() {
		// TODO Auto-generated method stub
		int tipo;
		
		do
		{
			tipo = Teclado.leerInt("tipo de cuenta (1. personal - 2. empresa)");
		}while (tipo != 1 && tipo != 2);

		cuenta = tipo== 1 ? new CuentaPersonal() : new CuentaEmpresa();
		
	}

	private void leerClientes() {
		// TODO Auto-generated method stub
		String nif;
		Cliente cliente;
		Contacto contacto;
		
		do
		{
			nif = Teclado.leerString("Nif :");
			cliente = clienteDAO.findById(nif).orElse(new Cliente());
			if (cliente.getNif() == null)
			{
				cliente.setNif(nif);
				// Leer otros datos
				
				cliente.setNombre(Teclado.leerString("\nNombre :"));
				cliente.setAval(Teclado.leerFloat("Avales :"));
				do
				{
					contacto = leerContacto ();
					cliente.addContacto(contacto);
					
				}while (Teclado.leerString("Introducir otro contacto (S/N)?)").equalsIgnoreCase("s"));
				
			}
			cuenta.addCliente(cliente);
			
		}while (Teclado.leerString("Introducir otro cliente (S/N)?)").equalsIgnoreCase("s"));
		
	}

	private Contacto leerContacto() {
		// TODO Auto-generated method stub
		Contacto c;
		String telefono;
		
		do
		{
			telefono = Teclado.leerString("\nTeléfono contacto: ");
		}while (contactoDAO.findById(telefono).isPresent());
		
		c = new Contacto (telefono);
		
		c.setProveedor(Teclado.leerString("\nEmpresa Telelcomunicaciones: "));
		
		return c;
	}

	private void leerDatosCuenta() {
		// TODO Auto-generated method stub
		String ncc;
		float saldo;
		
		
		do
		{
			ncc = Teclado.leerString("\nNumero de cuenta :");
		}while (cuentaDAO.findById(ncc).isPresent());
		
		cuenta.setNcc(ncc);
		do
		{
			saldo = Teclado.leerFloat("Saldo :");
		}while (saldo <0);
		
		cuenta.setSaldo(saldo);
		
		// leer datos espécificos del tipo de cuenta
	
		
		// Uso de Pattern Matching
		if (cuenta instanceof CuentaPersonal personal)
		{
			personal.setCredito(Teclado.leerString("\nTarjeta de crédito(S/N)").equalsIgnoreCase("s"));
		}
		else if (cuenta instanceof CuentaEmpresa empresa)
		{
			empresa.setCif(Teclado.leerString("\ncif :"));
			empresa.setNombre(Teclado.leerString("\nnombre :"));
			empresa.setLocal(Teclado.leerString("\ndispone de local propio(S/N)").equalsIgnoreCase("s"));
		}
			
		
		
	}
	
	

}

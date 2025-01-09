package hibernate.ejercicioExamen.banco.acciones;


import hibernate.ejercicioExamen.banco.modelo.Cuenta;

import utilidadesmenu.MenuAction;
import daw.com.Teclado;

public class IngresarDinero extends AccionBanco implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		String ncc;
		float cantidad;
		Cuenta c;
	
		ncc = UtilidadesBanco.leerNCC();
		
		// pedir cantidad ingresar
		do
		{
			cantidad = Teclado.leerFloat("cantidad: ");
		}while (cantidad <= 0);
		
		// ingresar
		c = cuentaDAO.findById(ncc).get();
		c.ingresar(cantidad);
		
		// actualizar cuenta
		cuentaDAO.update(c);
		
	}

}

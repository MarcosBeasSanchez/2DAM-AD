package hibernate.ejercicioExamen.banco.acciones;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import utilidadesmenu.MenuAction;

public class RealizarQuerys extends AccionBanco implements MenuAction {

	private Consumer<Object[]> imprimirResultado;
	private Runnable sinDatos;

	public RealizarQuerys() {
		imprimirResultado = o -> System.out.println(Arrays.stream(o).reduce((o1, o2) -> o1 + "," + o2).get());

		sinDatos = () -> System.out.println("sin datos");
	}

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		mostrarSaldoEntidad();
		mostrarClienteMasRico();
		mostrarTelCoMasUsada();
		mostrarCuentasEmpresarialesMorosas();

	}

	private void mostrarSaldoEntidad() {
		// TODO Auto-generated method stub
		String query;
		Stream<Object[]> resultado;

		query = "SELECT c.ncc, c.saldo FROM Cuenta c";

		resultado = cuentaDAO.executeQuery(query);
		resultado.forEach(imprimirResultado);

		query = "SELECT SUM(c.saldo) FROM Cuenta c";
		
		cuentaDAO.executeQuerySingleResult(query).ifPresentOrElse(s -> System.out.println("Suma de saldos de todas las cuentas :" + s),
				sinDatos);

	}

	private void mostrarClienteMasRico() {
		// TODO Auto-generated method stub
		Optional<Object[]> resultadoUnico;

		String query = "SELECT cliente, SUM(cuenta.saldo) FROM Cuenta cuenta INNER JOIN cuenta.clientes cliente" + " "
				+ "GROUP BY cliente.nif ORDER BY SUM(cuenta.saldo) DESC";
		
		resultadoUnico = cuentaDAO.executeQuerySingleResult(query);
		System.out.println("Cliente mas rico: ");
		resultadoUnico.ifPresentOrElse(imprimirResultado, sinDatos);

	}

	private void mostrarTelCoMasUsada() {
		// TODO Auto-generated method stub
		Optional<Object[]> resultadoUnico;
		String query = "SELECT t.proveedor, COUNT(t)" + "FROM Cliente cliente INNER JOIN cliente.telefonos t "
				+ "GROUP BY t.proveedor ORDER BY COUNT(t) DESC";

		resultadoUnico = clienteDAO.executeQuerySingleResult(query);
		System.out.println("Compañia de telecomunicaciones mas usada y nºveces : ");
		resultadoUnico.ifPresentOrElse(imprimirResultado, sinDatos);

	}

	private void mostrarCuentasEmpresarialesMorosas() {
		// TODO Auto-generated method stub
		String query;
		Stream<Object[]> resultado;

		query = "SELECT c.ncc, c.saldo FROM Cuenta c " + "WHERE TYPE(c) = CuentaEmpresa AND c.saldo < 0 "
				+ "ORDER BY c.saldo";

		query = "SELECT c.ncc, c.saldo,c.nombre FROM CuentaEmpresa c " + "WHERE c.saldo < 0 " + "ORDER BY c.saldo";

		resultado = cuentaDAO.executeQuery(query);
		System.out.println("Cuentas morosas (de < a >)");
		resultado.forEach(imprimirResultado);

	}

}

package ejercicio.EmpleYDep;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		List<Departamento>departamentos;
		List<Empleado>empleados;
		
		//Empleado jefe = new Empleado("001","Marcos","masculino",LocalDate.of(1950, 5, 12),LocalDate.now(),2000,5,"jefe", java.util.Optional.empty());
		//empleados.add("001","Marcos","masculino",LocalDate.of(2000, 12, 18),LocalDate.now(),2000,5,"programador",)
		
		Departamento ventas = new Departamento("D001", "Ventas", "Madrid");
        Departamento ett = new Departamento("D002", "IT", "Barcelona");
        Departamento rrhh = new Departamento("D003", "Recursos Humanos", "Valencia");
        
        // Creación de empleados y asociación a departamentos
        Empleado jefeVentas = new Empleado("12345678A", "Ana García", "F", 
        		LocalDate.of(1950, 5, 12),LocalDate.now(),2000, 5000, "Jefe de Ventas", Optional.empty());

	}

}

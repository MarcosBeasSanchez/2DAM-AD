package ejercicio.EmpleYDep;


import java.time.LocalDate;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Empleado {
	
	private String dni;
	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIncorporacion;
	private float salario;
	private int comision;
	private String cargo;
	private Optional<Empleado> jefeEmpleado;
	

	public Empleado(String dni, String nombre, String sexo, LocalDate date, LocalDate date2, int salario, int comision,
			String cargo, Optional<Empleado> jefe) {
		this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = date;
        this.fechaIncorporacion = date2;
        this.salario = salario;
        this.comision = comision;
        this.cargo = cargo;
        this.jefeEmpleado = jefe;
	}

}

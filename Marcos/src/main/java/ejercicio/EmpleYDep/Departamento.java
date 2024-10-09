package ejercicio.EmpleYDep;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Departamento {
	
	private String codigo;
	private String nombreDepartamento;
	private String ciudad;
	private List<Empleado>empleados;
	
	public Departamento(String codigo, String nombre, String ciudad) {
        this.codigo = codigo;
        this.nombreDepartamento = nombre;
        this.ciudad = ciudad;
        this.empleados = new ArrayList<>();
    }

}

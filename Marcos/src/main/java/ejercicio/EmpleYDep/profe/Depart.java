package ejercicio.EmpleYDep.profe;
import java.util.HashSet;
import java.util.Set;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Depart {
	@EqualsAndHashCode.Include
	private String codigo;
	private String nombre;
	private String ciudad;
	private Set<Emple> empleados;

	public Depart(String codigo, String nombre, String ciudad) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.empleados = new HashSet<Emple> ();
	}

	
	public boolean addEmple (Emple empleado)
	{
		return empleados.add(empleado);
	}

	
}

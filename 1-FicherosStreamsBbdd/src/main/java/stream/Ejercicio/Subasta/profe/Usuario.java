package stream.Ejercicio.Subasta.profe;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@Setter(AccessLevel.PRIVATE)

public class Usuario {
	final private String nombre;
	private float credito;
	final private String email;

	public void incrementarCredito (float cantidad)
	{
		if (cantidad > 0)
			credito += cantidad;
	}
	
	public void decrementarCredito (float cantidad)
	{
		if (cantidad > 0)
			credito -= cantidad;
	}


}

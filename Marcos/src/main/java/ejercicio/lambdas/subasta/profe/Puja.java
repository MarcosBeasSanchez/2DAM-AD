package ejercicio.lambdas.subasta.profe;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@Setter(AccessLevel.PRIVATE)

public class Puja {
	private Usuario pujador;
	private float cantidad;
	private Subasta subasta;
	

	@Override
	public String toString() {
		return "Puja [pujador=" + pujador 
				+ ", cantidad=" + cantidad + 
				", subasta=" + subasta.getProducto() + "]";
	}
	
	
}

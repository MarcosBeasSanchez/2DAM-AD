package stream.Ejercicio.Subasta.profe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@Setter(AccessLevel.PRIVATE)

public class Subasta {
	final private String producto;
	final private Usuario propietario;
	private List<Puja> pujas;
	private boolean abierta;
	
	
	public Subasta(String producto, Usuario propietario) {
		this.producto = producto;
		this.propietario = propietario;
		this.pujas = new ArrayList<Puja>();
		abierta = true;
	}
		
	
	public boolean isAbierta() {
		return abierta;
	}


	private void cerrarSubasta ()
	{
		abierta = false;
	}
	
	public Optional<Puja> getPujaMayor()
	{
		
		return pujas.stream().max((p1,p2) -> Float.compare(p1.getCantidad(), p2.getCantidad()));
	}
	
	public boolean pujar (Usuario pujador,float cantidad )
	{
		boolean aceptada = false;
		Puja nueva;
		
		if (isAbierta () &&
			pujador.getCredito() >= cantidad &&
			!pujador.getNombre().equalsIgnoreCase(propietario.getNombre()) &&
			getPujaMayor().map(Puja::getCantidad).orElse(0f)< cantidad)
		{
			aceptada = true;

			nueva = Puja.builder().
						pujador(pujador).
						cantidad(cantidad).
						subasta(this).
						build();
			
			pujas.add(nueva);
		}
				
		
		return aceptada;
	}
	
	public boolean pujar (Usuario pujador)
	{
		
		float cantidad = getPujaMayor().map(Puja::getCantidad).orElse(0f);
		
		cantidad ++;
		
		return pujar (pujador,cantidad);
	}
	
	public boolean ejecutar ()
	{
		boolean exito = false;
		float cantidad;
		Puja pujaMayor;
		
		
		if (isAbierta () && !pujas.isEmpty())
		{
			pujaMayor = getPujaMayor().get();
			cantidad = pujaMayor.getCantidad();
			
			propietario.incrementarCredito(cantidad);
			
			pujaMayor.getPujador().decrementarCredito(cantidad);
			
			exito = true;
			cerrarSubasta ();
		}
		
		return exito;
	}

}

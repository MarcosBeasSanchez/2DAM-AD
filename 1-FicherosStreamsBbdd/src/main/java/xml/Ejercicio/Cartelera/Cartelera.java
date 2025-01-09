package xml.Ejercicio.Cartelera;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
//Elemento raiz
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Cartelera {
	
	@XmlElement(name = "pelicula") // elemento repetido del contenedor
	List<Pelicula> peliculas;

	public void addPeli(Pelicula peli) {
		
		if (peliculas == null)
				peliculas = new ArrayList<>();
			
			peliculas.add(peli);
		
	}

	
}

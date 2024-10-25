package xml.Ejercicio.Sevilla;


import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlAccessorType(XmlAccessType.FIELD)

public class DatosRegistrados {
	
	@XmlAttribute
	private LocalDateTime actualizacion;
	
	private List<Dato>dato;

}

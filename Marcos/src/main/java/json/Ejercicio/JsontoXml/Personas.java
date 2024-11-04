package json.Ejercicio.JsontoXml;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement()

public class Personas {
	@XmlElement(name="persona")
	private List<Persona>personas;

	

}

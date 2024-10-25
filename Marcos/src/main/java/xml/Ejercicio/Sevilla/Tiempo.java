package xml.Ejercicio.Sevilla;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Tiempo {
	
	@Singular
	private List<Elementos> elementos;

}

package json.Ejercicio.JsonToXml2;

import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement

public class ContedorPruebaIdiomas {
	@XmlElement(name="prueba_nivel")
	List<PruebaIdiomas>lista;

}

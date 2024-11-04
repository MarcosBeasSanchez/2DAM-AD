package json.Ejercicio.JsontoXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"calle","numero","pais"})

public class Direccion {
	
	private String calle,numero,pais;

}

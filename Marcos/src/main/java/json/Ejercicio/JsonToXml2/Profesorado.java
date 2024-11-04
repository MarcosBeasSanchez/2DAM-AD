package json.Ejercicio.JsonToXml2;

import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

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
@XmlType(propOrder={"dolarId","nombreCompleto"})

public class Profesorado {
	
	@SerializedName(value="$id")
	@XmlElement(name="$id")
	private String dolarId;
	
	@SerializedName(value="NombreCompleto")
	@XmlElement(name="NombreCompleto")
	private String nombreCompleto;

}

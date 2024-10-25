package xml.Ejercicio.Sevilla;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

@XmlAccessorType(XmlAccessType.FIELD)

public class Dato {
	// quizas hay que hacer un LocalTimeDateAdapter
	@XmlAttribute
	private LocalDateTime fecha;

	private Float temperatura;

	private Viento viento;

	private Float precipitacion;

	private Float presion;

	private int humedad;

}

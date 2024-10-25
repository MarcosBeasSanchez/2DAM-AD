package xml.Ejercicio.Sevilla;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
@XmlType(propOrder = { "maxima", "minima", "condiciones", "icono", "viento", "probabilidadPrecipitacion",
		"precipitacion", "humedadMax", "humedadMin", "amanecer", "ocaso" })
public class Dia {

	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdapterSevilla.class)
	private LocalDate fecha;

	private int maxima;
	private int minima;
	private String condiciones;
	private String icono;
	private Viento viento;
	@XmlElement(name = "probabilidad_precipitacion")
	private int probabilidadPrecipitacion;
	private Float precipitacion;
	@XmlElement(name = "humedad_max")
	private int humedadMax;
	@XmlElement(name = "humedad_min")
	private int humedadMin;
	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	private LocalTime amanecer;
	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	private LocalTime ocaso;

}

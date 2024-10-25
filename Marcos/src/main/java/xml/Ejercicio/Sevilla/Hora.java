package xml.Ejercicio.Sevilla;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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

public class Hora {
	
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	private LocalTime id;
	
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdapterSevilla.class)
	private LocalDate fecha;
	
	private int temperatura;
	
	@XmlElement(name="sensacion_termica")
	private int sensacionTermica;
	
	private String icono;
	private String condiciones;
	
	private Viento viento;
	
	@XmlElement(name="probabilidad_precipitacion")
	private int probabilidadPrecipitacion;
	
	private Float precipitacion;
	
	private int humedad;
	
	
	

}

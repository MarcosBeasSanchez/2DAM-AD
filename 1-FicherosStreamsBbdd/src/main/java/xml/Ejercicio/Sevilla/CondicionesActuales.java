package xml.Ejercicio.Sevilla;

import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.JsonAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xml.Ejercicio.Cartelera.profe.LocalDateAdapter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "ultimaObservacion", "temperatura", "sensacionTermica", "condiciones", "icono", "viento", "precipitacion",
		"presion", "humedad", "visibilidad", "indice_ultravioleta" ,"puntoRocio"})
public class CondicionesActuales {
	
	@XmlElement(name = "ultima_observacion")
	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	@JsonAdapter(LocalTimeAdapterSevillaJson.class)
	private LocalTime ultimaObservacion;

	private int temperatura;
	
	@XmlElement(name="sensacion_termica")
	private int sensacionTermica;
	
	private String condiciones;
	private String icono;
	private Viento viento;
	private Float precipitacion;
	private String presion;
	private String humedad;
	private Float visibilidad;
	private int indice_ultravioleta;
	
	@XmlElement(name = "punto_rocio")
	private int puntoRocio;
}

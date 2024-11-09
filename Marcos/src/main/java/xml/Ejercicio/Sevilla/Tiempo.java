package xml.Ejercicio.Sevilla;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.JsonAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import xml.Ejercicio.Cartelera.profe.Pelicula;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@XmlRootElement(name="tiempo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "localizacion", "condicionesActuales", "alerta", "pronosticoDias", "pronosticoHoras", "datosRegistrados" })
public class Tiempo {
	
	
	private List<Localizacion> localizacion;

	@XmlElement(name = "condiciones_actuales")
	private List<CondicionesActuales> condicionesActuales;

	private Alerta alerta; //mirar importante

	@XmlElement(name = "pronostico_dias")
	private List<Dia> pronosticoDias;

	@XmlElement(name = "pronostico_horas")
	private List<Hora> pronosticoHoras;
	//ok
	@XmlElement(name = "datos_registrados")
	private DatosRegistrados datosRegistrados;

}

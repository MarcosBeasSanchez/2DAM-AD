package xml.Ejercicio.Sevilla;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "localizacion", "condicinesActuales", "alerta", "pronosticoDias", "pronosticoHoras", "datosRegistrados" })
public class Elementos {

	private List<Localizacion> localizacion;

	@XmlElement(name = "condiciones_actuales")
	private List<CondicionesActuales> condicionesActuales;

	private Alerta alerta;

	@XmlElement(name = "pronostico_dias")
	private List<Dia> pronosticoDias;

	@XmlElement(name = "pronostico_horas")
	private List<Hora> pronosticoHoras;

	@XmlElement(name = "datos_registrados")
	private DatosRegistrados datosRegistrados;

}

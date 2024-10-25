package xml.Ejercicio.Cartelera;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import xml.Ejercicio.Cartelera.profe.EnumGeneroAdapterXML;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

//Anotaciones XML
@XmlType(propOrder = { "titulo", "tituloOriginal", "nacionalidad", "genero", 
		"clasificacion", "sinopsis", "director","actores", "web", "cartel" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Pelicula {
	@XmlAttribute
	private String codigo;
	@XmlAttribute
	private int duracion;
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdaptador.class)
	private LocalDate fecha;
	String titulo;
	@XmlElement(name = "titulo_original")
	private String tituloOriginal;
	private String nacionalidad;
	private String genero;
	private Clasificacion clasificacion;
	String sinopsis;
	String director;
	@XmlElementWrapper(name = "reparto")
	@XmlElement(name = "actor")
	private List<Actor> actores;
	private String web;
	private String cartel;

}

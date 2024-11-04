package json.Ejercicio.JsonToXml2;

import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.JsonAdapter;
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
@XmlType(propOrder= {"dolarId","mCer","nivel","id","titulo","horario","inicioImparticion",
		"finImparticion","horas","url","tipoFormacion","ects","categoria","profesores"})

public class PruebaIdiomas {
	@XmlElement(name="$id")
	@SerializedName(value="$id")
	private String dolarId;
	
	@XmlElement(name="MCER")
	@SerializedName(value="MCER")
	private String mCer;
	
	@XmlElement(name="Nivel")
	@SerializedName(value="Nivel")
	private String nivel;
	
	@XmlElement(name="ID")
	@SerializedName(value="ID")
	private String id;
	
	@XmlElement(name="Titulo")
	@SerializedName(value="Titulo")
	private String titulo;
	
	@XmlElement(name="Horario")
	@SerializedName(value="Horario")
	private String horario;
	
	@XmlElement(name="InicioImparticion")
	@SerializedName(value="InicioImparticion")
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@JsonAdapter(LocalDateTimeAdapterIdiomas.class)
	private LocalDateTime inicioImparticion;
	
	@XmlElement(name="FinImparticion")
	@SerializedName(value="FinImparticion")
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@JsonAdapter(LocalDateTimeAdapterIdiomas.class)
	private LocalDateTime finImparticion;
	
	@XmlElement(name="Horas")
	@SerializedName(value="Horas")
	private int horas;
	
	@XmlElement(name="URL")
	@SerializedName(value="URL")
	private String url;
	
	@XmlElement(name="TipoFormacion")
	@SerializedName(value="TipoFormacion")
	@XmlJavaTypeAdapter(TipoFormacionAdapter.class)
	@JsonAdapter(EnumTipoFormacionAdapter.class)
	private TipoFormacion tipoFormacion;
	
	@XmlElement(name="ECTS")
	@SerializedName(value="ECTS")
	private String ects;
	
	@XmlElement(name="Categoria")
	@SerializedName(value="Categoria")
	@XmlJavaTypeAdapter(CategoriaAdapter.class)
	@JsonAdapter(EnumCategoriaAdapter.class)
	private Categoria categoria;
	
	@XmlElement(name="Profesorado")
	@SerializedName(value="Profesorado")
	private List<Profesorado>profesores;
	
}

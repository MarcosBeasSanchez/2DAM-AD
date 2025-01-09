package json.Ejercicio.JsontoXml;

import java.util.List;

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
@XmlType(propOrder= {"nombre","altura","peso","pasatiempos","soltero","direccion"})

public class Persona {
	
	 private String nombre;
	 private float altura;
	 private int peso;
	 private List<String>pasatiempos;
	 private boolean soltero;
	 private Direccion direccion;

}

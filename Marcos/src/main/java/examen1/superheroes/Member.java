package examen1.superheroes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.JsonAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"age","secretIdentity","powers"})

public class Member {
	
	@XmlAttribute
	private String name;
	
	private int age;
	
	private String secretIdentity;
	
	@XmlElement(name = "powers")
	@JsonAdapter(PowersJsonAdapter.class)
	private List<String>powers;

}

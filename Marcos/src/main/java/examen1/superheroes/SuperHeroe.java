package examen1.superheroes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement()

public class SuperHeroe {
	
	private String squadName;
	private String homeTown;
	private String formed;
	
	@JsonAdapter(SecretBaseJson.class)
	private SecretBase secretBase;
	
	@JsonAdapter(BooleanToJson.class)
	private Boolean active;
	
	@XmlElement(name="member")
	private List<Member>members;
}

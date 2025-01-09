package examen1.superheroes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum SecretBase {
	@XmlEnumValue(value = "top")
	TOP,
	@XmlEnumValue(value = "down")
	DOWN,
	@XmlEnumValue(value = "left")
	LEFT,
	@XmlEnumValue(value = "right")
	RIGHT;

}

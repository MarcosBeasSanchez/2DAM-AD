package json.Ejercicio.JsonToXml2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>{
	
	//private DateTimeFormatter a = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss");

	@Override
	public LocalDateTime unmarshal(String v) throws Exception { //Leer
		
		return LocalDateTime.parse(v);
	}

	@Override
	public String marshal(LocalDateTime v) throws Exception {
		return v.toString();
	}

}

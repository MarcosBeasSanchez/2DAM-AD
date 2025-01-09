package xml.Ejercicio.Sevilla;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapterSevilla extends XmlAdapter<String, LocalDateTime>{

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
		LocalDateTime l;
		l = LocalDateTime.parse(v);
		return l;
	}

	@Override
	public String marshal(LocalDateTime v) throws Exception {
		String s;
		s = v.toString();
		return s;
	}

}

package json.Ejercicio.JsonToXml2;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TipoFormacionAdapter extends XmlAdapter<String, TipoFormacion>{

	@Override
	public TipoFormacion unmarshal(String v) throws Exception {
		
		return TipoFormacion.crearFormacion(v);
	}

	@Override
	public String marshal(TipoFormacion v) throws Exception {
		// TODO Auto-generated method stub
		return v == null? null: v.toString();
	}

}

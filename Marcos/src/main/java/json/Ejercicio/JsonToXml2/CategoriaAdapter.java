package json.Ejercicio.JsonToXml2;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CategoriaAdapter extends XmlAdapter<String, Categoria> {

	@Override
	public Categoria unmarshal(String v) throws Exception {

		return Categoria.crearCategoria(v);
	}

	@Override
	public String marshal(Categoria v) throws Exception {
		// TODO Auto-generated method stub
		return v == null ? null : v.toString();
	}

}

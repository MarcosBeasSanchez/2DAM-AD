package json.Ejercicio.JsonToXml2;

import java.util.Arrays;

public enum TipoFormacion {

	PRESENCIAL{
		public String toString() {
			return "Presencial";
		}
	},
	NOPRESENCIAL{
		public String toString() {
			return "No Presencial";
		}
	};

	public static TipoFormacion crearFormacion(String v) {
		return Arrays.stream(TipoFormacion.values())
				.filter(g -> g.toString().equalsIgnoreCase(v))
				.findFirst()
				.orElse(PRESENCIAL);
		
	}
}

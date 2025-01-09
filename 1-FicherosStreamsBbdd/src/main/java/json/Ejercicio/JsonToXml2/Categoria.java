package json.Ejercicio.JsonToXml2;

import java.util.Arrays;

public enum Categoria {

	ZONAMETROPOLITANA {
		public String toString() {
			return "Zona Metropolitana";
		}
	},
	ZONARURAL {
		public String toString() {
			return "Zona Rural";
		}
	},
	ZONAEMPRESARIAL {
		public String toString() {
			return "Zona Empresarial";
		}
	};

	public static Categoria crearCategoria(String v) {
		return Arrays.stream(Categoria.values()).filter(g -> g.toString().equalsIgnoreCase(v)).findFirst()
				.orElse(ZONAMETROPOLITANA);

	}
}

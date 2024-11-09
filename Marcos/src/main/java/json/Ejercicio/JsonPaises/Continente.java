package json.Ejercicio.JsonPaises;

import java.util.Arrays;

public enum Continente {
	EUROPA{
		public String toString() {
			return "Europa";
		}
	},
	AMERICA{
		public String toString() {
			return "América";
		}
	},
	ASIA{
		public String toString() {
			return "Asia";
		}
	},
	AFRICA{
		public String toString() {
			return "África";
		}
	},
	OCEANIA{
		public String toString() {
			return "Oceanía";
		}
	},
	ANTARTIDA{
		public String toString() {
			return "Antártida";
		}
	};
	
	public static Continente crearContinente(String v) {
		return Arrays.stream(Continente.values())
				.filter(c -> c.toString().equalsIgnoreCase(v))
				//el to.string es el toString del ENUM
				.findFirst()
				.orElse(AMERICA);
		
	}
	
}


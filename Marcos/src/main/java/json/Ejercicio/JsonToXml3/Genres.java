package json.Ejercicio.JsonToXml3;

import java.util.Arrays;

public enum Genres {
	CRIME{
		public String toString() {
			return "Crime";
		}
	},
	DRAMA{
		public String toString() {
			return "Drama";
		}
	},
	BIOGRAPHY{
		public String toString() {
			return "Biography";
		}
	},
	HISTORY{
		public String toString() {
			return "History";
		}
	};
	
	public static Genres crearGenres(String g) {
		return Arrays.stream(Genres.values())
				.filter(q -> q.toString().equalsIgnoreCase(g))
				.findFirst()
				.orElse(BIOGRAPHY);
		
	}
}

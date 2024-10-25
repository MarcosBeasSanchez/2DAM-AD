package xml.Ejercicio.Sevilla;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppSevilla {

	public static void main(String[] args) {
		
		LocalDateTime hora = null;
		
		hora = LocalDateTime.now();
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		
		System.out.println(hora.format(formatter));
	}

}

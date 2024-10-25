package json.Ejemplo;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppEmpleado {

    public static void main(String[] args) {
    	List<Empleado>empleados = new ArrayList<Empleado>();
    	
    	Gson gsonBuild = new GsonBuilder().setPrettyPrinting().create();
    	
    	/*//Otra manera
    	Gson gson ;
        GsonBuilder gsonBuild = new GsonBuilder().setPrettyPrinting()
        		.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        
        gson = gsonBuild.create();
       */
    	
        Empleado e = Empleado.builder()
                .id("1")
                .dept("d1")
                .nombre("e1")
                .sueldo(1200)
                .fecha(LocalDate.of(2000, 02, 18))
                .build();
        Empleado e2 = Empleado.builder()
                .id("2")
                .dept("d2")
                .nombre("e2")
                .sueldo(700)
                .fecha(null)
                .build();
        
        empleados.add(e);
        empleados.add(e2);
        
        //Lectura
        String json = gsonBuild.toJson(empleados);
        System.out.println("JSON representation:");
        System.out.println(json);

        //Escitura del json
        try (FileWriter writer = new FileWriter("empleados.json")) {
        	gsonBuild.toJson(empleados, writer);
            System.out.println("JSON creado correctamente.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

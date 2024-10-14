package ejercicio.institutoOpencsv;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uso.opencsv.Alumno;


@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Instituto {

	private static final String SEPARADOR = ":"; //SEPARADOR DE LOS CAMPOS DE INSTITUTO 
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindByPosition(position = 1)
	private String codigo;
	@CsvBindByPosition(position = 2)
	private String numeroTlf;
	@CsvBindByPosition(position = 3)
	private Float presupesto;
	@CsvBindAndSplitByPosition(position = 4, elementType = Alumno.class, splitOn = "@", // los alumnos se separaran por;
			converter = AlumnotoText.class, writeDelimiter = "@")
	private List<Alumno> alumnos;
	
	public Instituto() {  //constructor vacio
		this.nombre = "";
		this.codigo = "";
		this.numeroTlf = "";
        this.alumnos = new ArrayList<>();
    }

	public Instituto(String nombre, String codigo, String numerotlf) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.numeroTlf = numerotlf;
		this.alumnos = new ArrayList<Alumno>();
	}

	public boolean addAlumno(Alumno a) {
		if (alumnos == null) {
			this.alumnos = new ArrayList<Alumno>();
		}
		return alumnos.add(a);
	}
	
	

}

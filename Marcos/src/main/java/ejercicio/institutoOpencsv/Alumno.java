package ejercicio.institutoOpencsv;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import ejercicio.EmpleYDep.profe.CSVToEmple;
import ejercicio.EmpleYDep.profe.Emple;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/*
 * Se desea acceder a los datos de una BBDD de institutos. Se conoce que de cada
 * instituto se guarda su nombre, su código de centro, su número de teléfono y
 * presupuesto. Se distinguen los institutos por su código de centro. Además se
 * guarda información sobre las personas que trabajan y estudian en él.
 * 
 * De cada persona se guarda sus teléfonos de contacto (compañía de
 * telecomunicaciones, número de teléfono y sistema operativo), junto a estos
 * datos también se guarda información sobre su nombre, NIF ,fecha de nacimiento
 * y en el caso de que te tengan vehículo se guarda su modelo, su color y su
 * matrícula. Se distinguen las personas por su NIF.
 */

public class Alumno {

	private static final String SEPARADOR = "@";//SEPARADOR DE UN ALUMNO CON OTRO
	@CsvBindByPosition(position = 0)
	private String nif;
	@CsvBindByPosition(position = 1)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@CsvBindAndSplitByPosition(position = 2, elementType = Contacto.class, splitOn = "$", // los Contactos se separaran por;
			converter = ContactotoText.class, writeDelimiter = "$")
	private List<Contacto>contactos;
	
	public Alumno() {
		this("");
	}

	public Alumno(String dni) {
		this.nif = dni;
		this.fechaNacimiento = LocalDate.now().minusYears(18); //MAYOR DE EDAD POR DEFECTO
		this.contactos = new ArrayList<Contacto>();
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws IllegalArgumentException {

		if (fechaNacimiento == null)
			throw new IllegalArgumentException("alumno sin datos de fecha de nacimiento");
		if (fechaNacimiento.plusYears(18).isAfter(LocalDate.now()))
			throw new IllegalArgumentException("alumno menor de edad");

		this.fechaNacimiento = fechaNacimiento;
	}
	
	

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
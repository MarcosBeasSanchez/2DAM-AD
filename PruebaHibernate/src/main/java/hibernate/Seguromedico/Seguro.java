package hibernate.Seguromedico;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

public class Seguro {
	@Id
	@Column(length = 10)
	int idSeguro;
	@Column(length = 9)
	String nif;
	@Column(length = 20)
	String nombre;
	@Column(length = 20)
	String ape1;
	@Column(length = 20)
	String ape2;
	@Column
	int edad;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	boolean casado;
	int numHijos;
	boolean embarazada;
	LocalDate fechaCreacion;

	//OnetoOne
	Coberturas coberturas;
	//OnetoOne
	Enfermedades enfermedades;
	//OnetoMany
	AsistenciaMedica asistencia;
	
	
	
}

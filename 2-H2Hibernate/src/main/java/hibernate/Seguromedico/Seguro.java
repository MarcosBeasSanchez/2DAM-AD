package hibernate.Seguromedico;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Entity
//@Table(name="SEGURO")

@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

public class Seguro {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_SEGURO")
	int idSeguro;
	@Column(name ="NIF" ,length = 9, unique = true)
	String nif;
	@Column(name="NOMBRE",length = 20)
	String nombre;
	@Column(name="APELLIDO1",length = 20)
	String ape1;
	@Column(name="APELLIDO2",length = 20)
	String ape2;
	int edad;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	boolean casado;
	int numHijos;
	boolean embarazada;
	
	LocalDate fechaCreacion;

	//@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="idCoberturas")
	@Embedded
	Coberturas coberturas;
	
	//@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="idEnfermedades")
	@Embedded
	Enfermedades enfermedades;
	
	@Singular
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="idAsistencias")
	List<AsistenciaMedica> asistencias;
	
	
	
}

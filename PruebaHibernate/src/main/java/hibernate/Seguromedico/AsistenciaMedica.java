package hibernate.Seguromedico;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idAsistenciaMedica;
	
	String breveDescripcion;
	String lugar;
	String explicacion;
	String tipoAsistencia;
	LocalDateTime fechaYHora;
	int importe;
	

}

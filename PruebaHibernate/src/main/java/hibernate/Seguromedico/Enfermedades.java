package hibernate.Seguromedico;

import javax.persistence.Entity;

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
public class Enfermedades {
	boolean corazon;
	boolean estomacal;
	boolean rinyones;
	boolean alergia;
	String nombreAlergia;

}

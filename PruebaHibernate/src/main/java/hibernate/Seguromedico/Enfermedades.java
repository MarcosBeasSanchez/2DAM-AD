package hibernate.Seguromedico;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//@Entity
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Enfermedades {
	private boolean corazon;
	private boolean estomacal;
	private boolean rinyones;
	private boolean alergia;
	@Column(length = 30)
	String nombreAlergia;

}

package hibernate.Seguromedico;

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
public class Coberturas {
	@EqualsAndHashCode.Include
	boolean oftalmologia;
	boolean dental;
	boolean fecundacionInVitro;

}

package hibernate.muchosamuchos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@EntityListeners(ProfesorListener.class) // Trigger para borrar profesor
@Entity
public class Profesor {
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 10)
	private String dni;

	@Column(length = 30)
	private String nombre;

	@Column(length = 30)
	private String especialidad;

}

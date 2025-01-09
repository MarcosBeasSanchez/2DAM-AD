package hibernate.muchosauno.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Grupos")
public class Grupo {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id_grupo")
	private long idGrupo;
	@Column(nullable = false,length = 20)
	private String nombre;
	@Column(nullable = false,length = 20)
	private String tutor;
	@Column(nullable = false)
	private int curso;

}


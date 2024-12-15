package hibernate.muchosauno.modelo;


import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Alumnos")
public class Alumno {

	@EqualsAndHashCode.Include
    @Id
    @Column(name="ID_ALUMNO")
    @GeneratedValue (strategy = GenerationType.TABLE)
    private Integer id;
    
    @Column(name="NOMBRE",length=20)
    private String firstName;
    
    @Column(name="FECHA_NACIMIENTO")
    private LocalDate fecha;
    
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="id_grupo")
    private Grupo grupo;	
	
}


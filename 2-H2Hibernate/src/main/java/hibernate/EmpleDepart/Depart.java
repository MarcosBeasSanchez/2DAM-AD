package hibernate.EmpleDepart;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//@NamedQuery(name = "findAllDepartamentos", query = "Aqui metemos la query")

@Entity

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Depart {
	
	/*
	 * Departamento (codDepto, nombreDpto, ciudad, codDirector)
	 * 
	 * codDepto varchar (4) PRIMARY KEY, 
	 * nombreDpto varchar (20) NOT NULL, 
	 * ciudad varchar (15), 
	 * codDirector varchar (12) FOREIGN KEY (codDirector) REFERENCES Empleado;
	 */
	
	@EqualsAndHashCode.Include
	@Id
    @Column(name = "coddepto", length = 4, nullable = false)
	private String codDepto;

    @Column(name = "nombredepto", length = 20, nullable = false)
	private String nombreDpto;

    @Column(name = "ciudad", length = 15)
	private String ciudad;

	@ManyToOne
	@JoinColumn(name = "coddirector", referencedColumnName = "nidemp")
	private Emple codDirector; 

}

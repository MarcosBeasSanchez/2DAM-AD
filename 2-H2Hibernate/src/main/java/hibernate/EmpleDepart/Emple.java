package hibernate.EmpleDepart;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlEnumValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Emple {
	
	/*	Empleado (nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comis, codSuc,jefeID, cargo, codDepto)
			
			nDIEmp VARCHAR( 12 ) NOT NULL PRIMARY KEY,
			nomEmp VARCHAR( 30 ) NOT NULL ,
			sexEmp CHAR( 1 ) NOT NULL CHECK (sexEmp IN ('F', 'M') ),
			fecNac DATE NOT NULL ,
			fecIncorporacion DATE NOT NULL,
			salEmp FLOAT NOT NULL,
			comisionE FLOAT NOT NULL,
			cargoE VARCHAR( 15 ) NOT NULL,
			jefeID VARCHAR( 12 ),
			codDepto VARCHAR( 4 ) NOT NULL,
			
			-- Declaración de las claves ajenas
			FOREIGN KEY (jefeID) REFERENCES Empleado,
			FOREIGN KEY (codDepto) REFERENCES Departamento
			*/
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "nidemp",length = 12 ,nullable = false)
	private String nDIEmp; 
	
	@Column(name = "nomemp",length = 30 ,nullable = false)
	private String nomEmp ;
	
	@Enumerated( EnumType.STRING )
	@Column(name = "sexemp")
	private SexEmp sexEmp;
	
	@Column(name = "fecnac",nullable = false)
	private LocalDate fecNac;
	
	@Column(name = "fecincorporacion",nullable = false)
	private LocalDate fecIncorporacion;
	
	@Column(name = "salemp",nullable = false)
	private float salEmp;
	
	@Column(name = "comisione",nullable = false)
	private float comisionE;
	
	@Column(name = "cargoe",length = 15 ,nullable = false)
	private String cargoE;
	
	@ManyToOne
    @JoinColumn(name = "jefeid",referencedColumnName = "nidemp")
    private Emple jefeID;
	
    @Column( name = "coddepto",length = 4, nullable = false)
	private String codDepto;

}

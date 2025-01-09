package hibernate.herencia.UnicaTabla;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorType;


@SuperBuilder // Usar con herencia en lugar de Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Persona implements Serializable
{
	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad) {
    	this.nombre = nombre;
        this.edad = edad;
    }

   

}

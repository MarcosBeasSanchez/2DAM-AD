package hibernate.herencia.UnicaTabla;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)


@Entity
@DiscriminatorValue(value="TC")
public class Tecnologo extends Persona
{

    private int aniosDeEstudios;
    
    public Tecnologo(String nombre, int edad, int aniosDeEstudios) {
        super(nombre, edad); // Llama al constructor de la clase padre (Tecnologo)
        this.aniosDeEstudios = aniosDeEstudios;
    }

    
    
}

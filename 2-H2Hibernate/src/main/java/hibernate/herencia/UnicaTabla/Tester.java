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
@DiscriminatorValue(value="TS")
public class Tester extends Tecnologo
{

    private String herramientaDeTesteo;
    
    public Tester(String nombre, int edad, int aniosDeEstudios, String herramientaDeTesteo) {
        super(nombre, edad, aniosDeEstudios); // Llama al constructor de la clase padre (Tecnologo)
        this.herramientaDeTesteo = herramientaDeTesteo;
    }
     
}

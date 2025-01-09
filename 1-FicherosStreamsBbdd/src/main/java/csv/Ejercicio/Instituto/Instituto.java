package csv.Ejercicio.Instituto;

import java.util.Set;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instituto {
  
    @CsvBindByPosition(position=0)
    private String nombre;
    
    @CsvBindByPosition(position=1)
    private String codigo;
    
    @CsvBindByPosition(position=2)
    private String telefono;
    
    @CsvBindByPosition(position=3)
    private float presupuesto;

    @CsvBindAndSplitByPosition(position = 4, 
            elementType= Persona.class, // tipo de elemento de la colección
            splitOn = "@", // Separador de Personas 
            converter = CsvToPersona.class // Clase convertidora
            ,writeDelimiter = "@")
    @Singular
    private Set<Persona> personas;
    
   
}


package csv.EjercicioRepasoGeneral.subasta;

import lombok.Data;

@Data
public class Usuario {
    
    private String nombre;
    private float credito;
    
    public Usuario(String nombre, float credito) {
        this.nombre = nombre;
        this.credito = credito;
    }
    
    public Usuario(String nombre) {
        this(nombre, 50);
    }

    public Usuario() {
        this("", 0);
    }
    
    public void incrementar(float incremento) {
    	credito += incremento;
    }
    public void decrementar(float decremento) {
    	credito -= decremento;
    }
    
    
    
    
    
}

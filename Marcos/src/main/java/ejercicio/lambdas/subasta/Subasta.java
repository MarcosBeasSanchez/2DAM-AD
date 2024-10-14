package ejercicio.lambdas.subasta;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Subasta {
    private final String nombreProducto;
    private Usuario propietario;
    private boolean abierta;
    private final List<Puja> pujas;

    public Subasta(String nombreProducto, Usuario propietario) {
        this.nombreProducto = nombreProducto;
        this.propietario = propietario;
        this.abierta = true;
        this.pujas = new ArrayList<>();
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public List<Puja> getPujas() {
        return new ArrayList<>(pujas);
    }

    public Puja getPujaMayor() {
        return pujas.stream()
            .max(Comparator.comparingDouble(Puja::getCantidad))
            .orElse(null); // Si no hay puja, retorna null
    }

    public void mostrarPujaMayor() {
        Puja pujaMayor = getPujaMayor();
        if (pujaMayor != null) {
            System.out.println("La puja mayor es de: " + pujaMayor.getPujador().getNombre() + " por " + pujaMayor.getCantidad() + " euros.");
        } else {
            System.out.println("No hay pujas en la subasta.");
        }
    }

    public boolean pujar(Usuario usuario, float cantidad) {
        if (!abierta) {
            System.out.println("La subasta está cerrada.");
            return false; 
        }
        if (usuario == propietario) {
            System.out.println("El propietario no puede pujar en su propia subasta.");
            return false;
        }
        if (usuario.getCredito() < cantidad) {
            System.out.println("El usuario no tiene suficiente crédito.");
            return false; 
        }

        Puja pujaMayor = getPujaMayor(); 
        if (pujaMayor != null && cantidad <= pujaMayor.getCantidad()) {
            System.out.println("La puja debe ser mayor a la puja mayor existente.");
            return false;
        }

        Puja nuevaPuja = new Puja(usuario, cantidad, this);
        pujas.add(nuevaPuja);
        return true;
    }

    public boolean pujar(Usuario usuario) {
        float cantidad = getPujaMayor() != null ? getPujaMayor().getCantidad() + 1 : 1;
        return pujar(usuario, cantidad);
    }

    public boolean ejecutar() {
        if (!abierta || pujas.isEmpty()) {
            System.out.println("No se puede ejecutar la subasta. Está cerrada o no hay pujas.");
            return false;
        }

        Puja pujaMayor = getPujaMayor();
        if (pujaMayor == null) {
            return false;
        }

        Usuario ganador = pujaMayor.getPujador();
        float cantidad = pujaMayor.getCantidad();

        // Transferir crédito solo si el ganador tiene suficiente
        ganador.decrementar(cantidad);
        propietario.incrementar(cantidad);
        
        propietario = ganador;

        abierta = false; // Cerrar la subasta
        return true;
    }
}

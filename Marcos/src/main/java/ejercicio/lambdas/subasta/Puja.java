package ejercicio.lambdas.subasta;

public class Puja {
    private final Usuario pujador;
    private final float cantidad;
    private final Subasta subasta;

    public Puja(Usuario pujador, float cantidad, Subasta subasta) {
        this.pujador = pujador;
        this.cantidad = cantidad;
        this.subasta = subasta;
    }

    public Usuario getPujador() {
        return pujador;
    }

    public float getCantidad() {
        return cantidad;
    }

    public Subasta getSubasta() {
        return subasta;
    }
}

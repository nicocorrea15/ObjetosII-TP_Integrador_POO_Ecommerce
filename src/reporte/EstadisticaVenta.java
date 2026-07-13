package reporte;

public class EstadisticaVenta {

    private int cantidad;
    private double sumaPrecios;

    public EstadisticaVenta() {
        this.cantidad = 0;
        this.sumaPrecios = 0;
    }

    public void agregarVenta(double precio) {
        cantidad++;
        sumaPrecios += precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioPromedio() {
        return sumaPrecios / cantidad;
    }

}
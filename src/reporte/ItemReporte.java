package reporte;

public class ItemReporte {

    private String nombre;
    private int cantidadVendida;
    private double precioPromedio;

    public ItemReporte(String nombre, int cantidadVendida, double precioPromedio) {
        this.nombre = nombre;
        this.cantidadVendida = cantidadVendida;
        this.precioPromedio = precioPromedio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public double getPrecioPromedio() {
        return precioPromedio;
    }

}
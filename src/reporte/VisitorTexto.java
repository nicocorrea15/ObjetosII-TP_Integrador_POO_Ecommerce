package reporte;

public class VisitorTexto implements VisitorReporte {

    private String resultado;

    @Override
    public void visitar(ReporteMasVendidos reporte) {

        String texto = "";

        for(ItemReporte item : reporte.getItems()) {

            texto += item.getNombre()
                    + " - Ventas: "
                    + item.getCantidadVendida()
                    + " - Precio promedio: "
                    + item.getPrecioPromedio()
                    + "\n";
        }

        this.resultado = texto;
    }

    public String getResultado() {
        return resultado;
    }
}
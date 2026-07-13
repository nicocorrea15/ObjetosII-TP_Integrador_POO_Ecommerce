package reporte;

public class VisitorTexto implements VisitorReporte {

    @Override
    public void visitar(ReporteMasVendidos reporte) {

        for(ItemReporte item : reporte.getItems()) {

            System.out.println(
                item.getNombre()
                + " - "
                + item.getCantidadVendida()
                + " unidades - $"
                + item.getPrecioPromedio()
            );
        }
    }
}
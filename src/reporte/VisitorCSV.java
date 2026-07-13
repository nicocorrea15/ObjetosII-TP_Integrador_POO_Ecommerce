package reporte;

public class VisitorCSV implements VisitorReporte {


    @Override
    public void visitar(ReporteMasVendidos reporte) {

        System.out.println(
            "Nombre,Cantidad,Precio Promedio"
        );

        for(ItemReporte item : reporte.getItems()) {

            System.out.println(
                item.getNombre()
                + ","
                + item.getCantidadVendida()
                + ","
                + item.getPrecioPromedio()
            );

        }

    }

}
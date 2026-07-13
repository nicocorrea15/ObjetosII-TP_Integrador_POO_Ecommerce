package reporte;

public class VisitorCSV implements VisitorReporte {

    private String resultado;
    
    @Override
    public void visitar(ReporteMasVendidos reporte) {

        String csv = "Nombre,Cantidad,Precio Promedio\n";

        for(ItemReporte item : reporte.getItems()) {

            csv += item.getNombre()
                    + ","
                    + item.getCantidadVendida()
                    + ","
                    + item.getPrecioPromedio()
                    + "\n";
        }

        this.resultado = csv;
    }


    public String getResultado() {
        return resultado;
    }
}
package reporte;

public class VisitorHTML implements VisitorReporte {

    private String resultado;

    @Override
    public void visitar(ReporteMasVendidos reporte) {

        String html = "<html><body>";
        
        html += "<table border='1'>";
        
        html += "<tr>";
        html += "<th>Nombre</th>";
        html += "<th>Cantidad</th>";
        html += "<th>Precio Promedio</th>";
        html += "</tr>";

        for(ItemReporte item : reporte.getItems()) {

            html += "<tr>";

            html += "<td>" + item.getNombre() + "</td>";
            html += "<td>" + item.getCantidadVendida() + "</td>";
            html += "<td>" + item.getPrecioPromedio() + "</td>";

            html += "</tr>";
        }

        html += "</table>";
        html += "</body></html>";

        this.resultado = html;
    }

    public String getResultado() {
        return resultado;
    }
}
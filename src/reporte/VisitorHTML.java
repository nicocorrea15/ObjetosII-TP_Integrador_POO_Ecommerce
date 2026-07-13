package reporte;

public class VisitorHTML implements VisitorReporte {

    @Override
    public void visitar(ReporteMasVendidos reporte) {

        System.out.println("<table>");

        for(ItemReporte item : reporte.getItems()) {

            System.out.println(
                "<tr>"
                +"<td>"+item.getNombre()+"</td>"
                +"<td>"+item.getCantidadVendida()+"</td>"
                +"<td>"+item.getPrecioPromedio()+"</td>"
                +"</tr>"
            );

        }

        System.out.println("</table>");
    }
}

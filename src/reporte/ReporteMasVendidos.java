package reporte;

import java.util.ArrayList;

import java.util.*;
import itemCatalogo.*;

public class ReporteMasVendidos {
	
	private Catalogo catalogo; 
	
    public ReporteMasVendidos(Catalogo catalogo) {
    	this.catalogo = catalogo;
    }
    
    public ArrayList<ItemReporte> getItems() {
    	return generar(catalogo);
    }

    public ArrayList<ItemReporte> generar(Catalogo catalogo) {

        ArrayList<Venta> ventas = catalogo.obtenerVentas();

        HashMap<String, EstadisticaVenta> map = new HashMap<>();

        for(Venta venta : ventas) { // por cada venta 

            EstadisticaVenta estadistica = map.get(venta.getNombre());  // obtengo la clave, parecido a lookupM 

            if(estadistica == null) {  // busco si la clave esta o no. Si no esta la estadistica(clave), la crea. Si esta, saltea 
                estadistica = new EstadisticaVenta();  // la crea 
                map.put(venta.getNombre(), estadistica); // y arma el map con el nombre de la venta (clave) y una estadistica nueva
            }

            estadistica.agregarVenta(venta.getPrecio()); // suma 1 a la cantidad y el precio en ese momento del item 
        }

        ArrayList<ItemReporte> resultado = new ArrayList<>();

        for(String nombre : map.keySet()) { // para cada clave del map 

            EstadisticaVenta estadistica = map.get(nombre); // obtenemos la estadistica, que esta porque venimos del map creado anterior

            resultado.add(					// agrego 
                new ItemReporte(			// creo un itemReporte
                        nombre,				// nombre 	
                        estadistica.getCantidad(),	// cantidad de ventas 
                        estadistica.getPrecioPromedio()));	// precio promedio 
        }

        this.ordenarPorVentas(resultado);  // ordena por cantidad vendida 

        return resultado;
    }
    
    public void ordenarPorVentas(ArrayList<ItemReporte> items) {

        for(int i = 0; i < items.size() - 1; i++) { // estamos parados en el primer elemento, buscando el mayor, cuando lo encuentra, busca el 2 mejor , recursion

            for(int j = i + 1; j < items.size(); j++) { // busca el mayor de j posicion, recursion

                if(items.get(i).getCantidadVendida() < items.get(j).getCantidadVendida()) { // si el primero es mas chico que el segundo, tengo que subir el mayor

                    ItemReporte aux = items.get(i);	// guardar elemento a pisar i = posicion 0

                    items.set(i, items.get(j));		// pongo j(itemReporte en posicion j) en la posicion de i

                    items.set(j, aux);				// pongo aux abajo de j (aux es el elemento menor)
                }
            }
        }
    }
    
    public void aceptar(VisitorReporte visitor) {
        visitor.visitar(this);
    }
}
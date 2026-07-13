package itemCatalogo;

import java.util.*;

import busquedaCatalogo.*;
import pedido.*;
import reporte.Venta;

public class Catalogo {
	
	private ArrayList<ItemCatalogo> items; 
	private ArrayList<Pedido> pedidos;
	
	public Catalogo() {
		this.items = new ArrayList<>();
		this.pedidos = new ArrayList<>();
	}
	
	public ArrayList<ItemCatalogo> getCatalogo() {
		return items; 
	}
	
	public ArrayList<ItemCatalogo> buscar(CriterioBusqueda criterio){

		ArrayList<ItemCatalogo> resultado = new ArrayList<>();

	    for(ItemCatalogo item : items){

	        if(criterio.cumple(item))
	            resultado.add(item);
	    }

	    return resultado;
	}
	
	public void agregarItem(ItemCatalogo item) {
		items.add(item);
	}
	
	public void eliminarItem(ItemCatalogo item) {
		items.remove(item);
	}
	
	public void agregarPedido(Pedido pedido) {
	    pedidos.add(pedido);
	}
	
	public ArrayList<Venta> obtenerVentas() {
		
		ArrayList<Venta> ventas = new ArrayList<>();
		
		for(Pedido p: pedidos) {
			if(p.getEstado().getEstadoString().equals("Entregado")) {
				ventas.addAll(p.reporteDeVentas());
			}
		}
		
		return ventas;
	}
}

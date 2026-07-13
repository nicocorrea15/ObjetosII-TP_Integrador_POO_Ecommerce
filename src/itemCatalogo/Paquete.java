package itemCatalogo;

import java.util.ArrayList;

public class Paquete implements ItemCatalogo{
	
	private String nombre;
	private ArrayList<ItemCatalogo> catalogo;
	private double descuento;
	private String categoria;
	
	public Paquete (String nombre1, double descuento1,String categoria1) {
		this.nombre = nombre1;
		this.catalogo = new ArrayList<>();
		this.descuento = descuento1;
		this.categoria = categoria1;
		
	}
	
	@Override
	public String getCategoria() {
		return categoria;
	}

	@Override
	public double getPrecioFinal() {
		return this.getPrecioBase() * (1 - descuento);
	}

	@Override
	public double getPrecioBase() {
		double total = 0; 
		
		for (ItemCatalogo ic: catalogo) {
			total += ic.getPrecioFinal();
		}
		return total;
	}

	@Override
	public String getDescripcion() {
		return "Nombre: " + nombre;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void disminuirStock(int n) {

	    for(ItemCatalogo item : catalogo) {
	        item.disminuirStock(n);
	    }
	}
	
	public void addProducto(ItemCatalogo p) {
		catalogo.add(p);
	}
	
	public void deleteProducto(ItemCatalogo p) {
		catalogo.remove(p);
	}
	
	public ArrayList<ItemCatalogo> getCatalogo() {
		return catalogo;
	}
	
	public int cantItems() {
		return catalogo.size();
	}

	@Override
	public void aumentarStock(int n) {

	    for(ItemCatalogo item : catalogo) {
	        item.aumentarStock(n);
	    }
	}
	
	@Override 
	public int getPeso() {
		
		int total = 0; 
		
		for(ItemCatalogo ic: catalogo) {
			total += ic.getPeso();
		}
		return total;
	}
	
	@Override
	public int getStock() {
		
		int total = 0; 
		
		for (ItemCatalogo ic: catalogo) {
			total += ic.getStock(); 
		}
		
		return total;
	}
}

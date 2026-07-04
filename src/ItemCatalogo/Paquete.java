package ItemCatalogo;

import java.util.ArrayList;

public class Paquete implements ItemCatalogo{
	
	private String nombre;
	private ArrayList<ItemCatalogo> catalogo;
	private double descuento;
	
	public Paquete (String nombre, ArrayList<ItemCatalogo> catalogo, double descuento) {
		this.nombre = nombre;
		this.catalogo = new ArrayList<>();
		this.descuento = descuento;
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

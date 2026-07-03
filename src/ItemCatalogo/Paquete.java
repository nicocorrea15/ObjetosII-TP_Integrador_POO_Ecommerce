package ItemCatalogo;

import java.util.ArrayList;

public class Paquete implements ItemCatalogo{
	
	private String nombre;
	private ArrayList<ItemCatalogo> catalogo = new ArrayList<>();
	private double descuento;
	
	public Paquete (String nombre, ArrayList<ItemCatalogo> catalogo, double descuento) {
		this.nombre = nombre;
		this.catalogo = catalogo;
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
	
	public void addProducto(ItemCatalogo p) {
		catalogo.add(p);
	}
	
	public int cantItems() {
		return catalogo.size();
	}

}

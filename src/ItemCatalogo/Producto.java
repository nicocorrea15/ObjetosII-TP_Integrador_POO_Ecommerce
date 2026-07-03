package ItemCatalogo;

public class Producto implements ItemCatalogo{
	
	private String id; 
	private String nombre;
	private String marca; 
	private String categoria; 
	private double precio; 
	private double descuentoPromocional;
	
	public Producto(String id, String nombre, String marca, String categoria, double precio, double desc) {
		this.id = id; 
		this.nombre = nombre;
		this.marca = marca; 
		this.categoria = categoria; 
		this.precio = precio; 
		this.descuentoPromocional = desc;
	}
	
	@Override
	public double getPrecioFinal() {
		return precio * (1 - descuentoPromocional);
	}
	
	@Override
	public double getPrecioBase() {
		return precio;
	}
	
	@Override
	public String getDescripcion() {
		return "Nombre: " + nombre + ", Categoria: " + categoria + ", Marca: " + marca;
		
	}
	
	@Override
	public String getNombre() {
		return nombre;
	} 
	
	public String getID() {
		return id;
	}

}

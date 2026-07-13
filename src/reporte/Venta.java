package reporte;

public class Venta {
	
	private String nom; 
	private double precio;
	
	public Venta(String nombre,double precio) {
		this.nom = nombre;	
		this.precio = precio;
	}
	
	public String getNombre() {
		return nom;
	}
	
	public double getPrecio() {
		return precio;
	}

}

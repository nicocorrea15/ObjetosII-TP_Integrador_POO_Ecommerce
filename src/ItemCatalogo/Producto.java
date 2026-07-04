package ItemCatalogo;

import java.util.*;

public class Producto implements ItemCatalogo{
	
	private String id; 
	private String nombre;
	private String marca; 
	private String categoria; 
	private double precio; 
	private double descuentoPromocional;
	private ArrayList<Atributo> atributos = new ArrayList<>();
	private int stock;
	private int peso;
	
	public Producto(String id, String nombre, String marca, 
				String categoria, double precio, double desc, 
				ArrayList<Atributo> atributos, int stock,int peso) {
		this.id = id; 
		this.nombre = nombre;
		this.marca = marca; 
		this.categoria = categoria; 
		this.precio = precio; 
		this.descuentoPromocional = desc;
		this.atributos = atributos;
		this.stock = stock;
		this.peso = peso;
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
	
	public boolean validar() {
		
		if (nombre == null || id == null) {
			return false;
		}
		
		for (Atributo a: atributos) {
			if (a.valor() == 0) {
				return false;
			}
		}
		return true;
	}
	
	public String getID() {
		return id;
	}
	
	public ArrayList<Atributo> getAtributo() {
		return atributos;
	}
	
	public void agregarAtributo(Atributo a) {
		atributos.add(a);
	}
	
	@Override
	public int getPeso() {
		return peso;
	}
	
	@Override
	public int getStock() {
		return stock;
	}

	@Override
	public void disminuirStock(int n) {
		stock -= n;
	}
	
	@Override
	public void aumentarStock(int n) {
		stock += n;
	}

}

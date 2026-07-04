package Pedido;

import ItemCatalogo.*;

public class Pedido {
	
	private EstadoPedido estado;
	private Paquete carrito;
	
	public Pedido(EstadoPedido estado, Paquete carrito) {
		this.estado = estado;
		this.carrito = carrito;
	}
	
	public EstadoPedido getEstado() {
		return estado; 
	}
	
	public float getPeso() {
		return carrito.getPeso();
	}
	
	public void setEstado(EstadoPedido newEstado) {
		estado = newEstado;
	}
	
	public Paquete getCarrito() {
		return carrito;
	}
	
	public void agregarProducto(ItemCatalogo ic) {
		carrito.addProducto(ic);
	}
	
	public void eliminarProducto(ItemCatalogo ic) {
		carrito.deleteProducto(ic);
	}
	
	public void disminuirStock() {
		carrito.disminuirStock(1);
	}
	
	public void reponerStock() {
		
	}
	
	public void generarNotaCredito() {
	}
	
	public void generarNotaCreditoProductos() {
	}
	
	public double costoProductos() {
		return carrito.getPrecioFinal();
	}
}

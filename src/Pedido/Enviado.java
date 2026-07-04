package Pedido;

import ItemCatalogo.ItemCatalogo;

public class Enviado extends EstadoPedido {
	
	public Enviado(Pedido pedido) {
		super(pedido);
	}

	@Override
	public void agregarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El producto ya fue enviado!");
	}
	
	@Override
	public void eliminarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El producto ya fue enviado!");
	}

	@Override
	public void cancelado() {
		pedido.setEstado(new Cancelado(pedido));
		pedido.generarNotaCreditoProductos();
	}

	@Override
	public void enPreparacion() {
		throw new RuntimeException("¡El producto ya fue enviado!");
	}

	@Override
	public void entregado() {
		pedido.setEstado(new Entregado(pedido));
	}

	@Override
	public void confirmar() {
		throw new RuntimeException("¡El producto ya fue enviado!");
	}

	@Override
	public void enviado() {
		throw new RuntimeException("¡El producto ya fue enviado!");
	}
}

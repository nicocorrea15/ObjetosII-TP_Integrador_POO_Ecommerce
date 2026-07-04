package Pedido;

import ItemCatalogo.ItemCatalogo;

public class Entregado extends EstadoPedido {
	
	public Entregado(Pedido pedido) {
		super(pedido);
	}

	@Override
	public void agregarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El producto ya fue entregado!");
	}

	@Override
	public void eliminarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El producto ya fue entregado!");
	}

	@Override
	public void confirmar() {
		throw new RuntimeException("¡El producto ya fue entregado!");
	}

	@Override
	public void cancelado() {
		throw new RuntimeException("¡El producto ya fue entregado!");
	}

	@Override
	public void enviado() {
		throw new RuntimeException("¡El producto ya fue entregado!");
	}

	@Override
	public void enPreparacion() {
		throw new RuntimeException("¡El producto ya fue entregado!");
	}

	@Override
	public void entregado() {
		throw new RuntimeException("¡El producto ya fue entregado!");
	}
}

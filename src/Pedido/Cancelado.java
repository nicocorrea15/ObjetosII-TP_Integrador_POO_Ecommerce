package Pedido;

import ItemCatalogo.*;

public class Cancelado extends EstadoPedido {
		
	public Cancelado(Pedido pedido) {
		super(pedido);
	}

	@Override
	public void agregarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El pedido está cancelado!");
	}

	@Override
	public void eliminarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El pedido está cancelado!");	
	}

	@Override
	public void confirmar() {
		throw new RuntimeException("¡El pedido está cancelado!");
	}

	@Override
	public void cancelado() {
		throw new RuntimeException("¡El pedido está cancelado!");
	}

	@Override
	public void enviado() {
		throw new RuntimeException("¡El pedido está cancelado!");
	}

	@Override
	public void enPreparacion() {
		throw new RuntimeException("¡El pedido está cancelado!");
	}

	@Override
	public void entregado() {
		throw new RuntimeException("¡El pedido está cancelado!");
	}
}

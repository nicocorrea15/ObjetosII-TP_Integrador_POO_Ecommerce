package Pedido;

import ItemCatalogo.ItemCatalogo;

public class Confirmado extends EstadoPedido {

	public Confirmado(Pedido pedido) {
		super(pedido);
	}

	@Override
	public void agregarProducto(ItemCatalogo ic) {
		throw new RuntimeException("No es posible agregar productos en este estado");
	}

	@Override
	public void eliminarProducto(ItemCatalogo ic) {
		throw new RuntimeException("No es posible eliminar productos en este estado");
	}

	@Override
	public void confirmar() {
		throw new RuntimeException("Ya estamos en este estado");
	}

	@Override
	public void cancelado() {
		pedido.reponerStock();
		pedido.setEstado(new Cancelado(pedido));
	}

	@Override
	public void enviado() {
		throw new RuntimeException("No es posible enviar en este estado");		
	}

	@Override
	public void enPreparacion() {
		pedido.setEstado(new EnPreparacion(pedido));
	}

	@Override
	public void entregado() {
		throw new RuntimeException("No es posible enviar en este estado");
	}
}

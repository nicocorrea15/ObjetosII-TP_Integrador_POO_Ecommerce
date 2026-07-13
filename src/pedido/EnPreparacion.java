package pedido;

import itemCatalogo.ItemCatalogo;

public class EnPreparacion extends EstadoPedido {

	public EnPreparacion(Pedido pedido) {
		super(pedido);
		this.nombre = "EnPreparacion";
	}

	@Override
	public void agregarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El pedido se esta preparando!");	}

	@Override
	public void eliminarProducto(ItemCatalogo ic) {
		throw new RuntimeException("¡El pedido se esta preparando!");
	}

	@Override
	public void confirmar() {
		throw new RuntimeException("¡El pedido se esta preparando!");
	}

	@Override
	public void cancelado() {
	    pedido.reponerStock();
	    pedido.generarNotaCredito();
	    pedido.setEstado(new Cancelado(pedido));
	}

	@Override
	public void enviado() {
		pedido.setEstado(new Enviado(pedido));
	}

	@Override
	public void enPreparacion() {
		throw new RuntimeException("¡El pedido se esta preparando!");
	}

	@Override
	public void entregado() {
		throw new RuntimeException("¡El pedido se esta preparando!");
	}
}

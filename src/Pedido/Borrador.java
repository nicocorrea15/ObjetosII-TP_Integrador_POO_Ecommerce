package Pedido;

import ItemCatalogo.*;

public class Borrador extends EstadoPedido {
	
	public Borrador(Pedido pedido) {
		super(pedido);
	}

	@Override
	public void agregarProducto(ItemCatalogo ic) {
		pedido.agregarProducto(ic);		
	}

	@Override
	public void eliminarProducto(ItemCatalogo ic) {
		pedido.eliminarProducto(ic);		
	}

	@Override
	public void confirmar() {
		pedido.disminuirStock();
		pedido.setEstado(new Confirmado(pedido));
	}

	@Override
	public void cancelado() {
		pedido.setEstado(new Cancelado(pedido));
	}

	@Override
	public void enviado() {
		throw new RuntimeException("No es posible enviar todavia");
	}

	@Override
	public void enPreparacion() {
		throw new RuntimeException("No es posible pasar a preparacion en este estado");
	}

	@Override
	public void entregado() {
		throw new RuntimeException("No es posible entregar en este estado");
	}
}

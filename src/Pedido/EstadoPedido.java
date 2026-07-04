package Pedido;

import ItemCatalogo.*;

public abstract class EstadoPedido {

    protected Pedido pedido;

    public EstadoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

	public abstract void agregarProducto(ItemCatalogo ic);
	public abstract void eliminarProducto(ItemCatalogo ic);
	public abstract void confirmar(); 
	public abstract void cancelado();
	public abstract void enviado();
	public abstract void enPreparacion();
	public abstract void entregado();

}

package pedido;

import java.util.*;

import itemCatalogo.*;
import metodoDeEnvio.MetodoEnvio;
import metodoDePago.Cliente;
import metodoDePago.MetodoDePago;
import notificacionDePedido.ObservadorPedido;
import reporte.Venta;

public class Pedido {
	
	private EstadoPedido estado;
	private Paquete carrito;
	private List<ObservadorPedido> observadores;
	private Cliente cliente;
	private MetodoEnvio envio;
	private MetodoDePago pago;
	private NotaDeCredito nota;
	
	public Pedido(EstadoPedido estado, Paquete carrito,Cliente cliente1,MetodoEnvio envio1,MetodoDePago pago1,NotaDeCredito nota1) {
		this.estado = estado;
		this.carrito = carrito;
		this.observadores = new ArrayList<>();
		this.cliente = cliente1;
		this.envio = envio1;
		this.pago = pago1;
		this.nota = nota1;
	}
	
	public void cambiarMetodoDePago(MetodoDePago pago1) {
		pago = pago1;
	}
	public MetodoDePago getMetodoPago() {
		return pago;
	}
	
	public MetodoEnvio getEnvio() {
		return envio;
	}
	
	public List<ObservadorPedido> getObservadores() {
		return observadores;
	}
	
	public void agregarObservador(ObservadorPedido observador) {
	    observadores.add(observador);
	}

	public void eliminarObservador(ObservadorPedido observador) {
	    observadores.remove(observador);
	}
	
	private void notificarObservadores(EstadoPedido estado) {

		for (ObservadorPedido o : observadores) {
			o.actualizar(this,estado);
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public EstadoPedido getEstado() {
		return estado; 
	}
	
	public float getPeso() {
		return carrito.getPeso();
	}
	
	public void setEstado(EstadoPedido newEstado) {

		estado = newEstado;
		
		notificarObservadores(estado);
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
	
	public ArrayList<Venta> reporteDeVentas() {
		
		ArrayList<ItemCatalogo> items = carrito.getCatalogo();
		ArrayList<Venta> ventas = new ArrayList<>();
		
		for(ItemCatalogo ic: items) {
			
			String nombre = ic.getNombre();
			double precio = ic.getPrecioBase();
			
			Venta venta = new Venta(nombre,precio);
			
			ventas.add(venta);
		}
		
		return ventas;
	}
	
	public void generarNotaCredito() {
		nota.generarNotaCredito();
	}
	
	public void generarNotaCreditoProductos() {
		nota.generarNotaCreditoProductos();
	}
	
	public double costoDeEnvio() {
		return envio.costoEnvio(this);
	}
	
	 public int diasDeEntrega() {
	    return envio.diasDeEntrega(this);
	 }
	 
	 public void setMetodoEnvio(MetodoEnvio metodoEnvio) {
	    this.envio = metodoEnvio;
	 }
	
	public double costoProductos() {
		return carrito.getPrecioFinal();
	}
}

package Envio;

import Pedido.*;

public class EnvioExpress extends Envio {
	
	private double costoBase;
	private double porcentajeFijo;
	
	public EnvioExpress(Pedido pedido,double costoBase1,double porcentajeFijo1) {
		super(pedido);
		this.costoBase = costoBase1;
		this.porcentajeFijo = porcentajeFijo1;
	}

	@Override
	public float costoEnvio() {
		return (float) (porcentajeFijo * pedido.costoProductos() + costoBase);
	}

	@Override
	public int diasDeEntrega() {
		return 1;
	}
}

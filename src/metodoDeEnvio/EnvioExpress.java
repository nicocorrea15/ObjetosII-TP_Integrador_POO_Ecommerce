package metodoDeEnvio;

import pedido.*;

public class EnvioExpress implements MetodoEnvio {
	
	private double costoBase;
	private double porcentajeFijo;
	
	public EnvioExpress(double costoBase1,double porcentajeFijo1) {
		this.costoBase = costoBase1;
		this.porcentajeFijo = porcentajeFijo1;
	}

	@Override
	public double costoEnvio(Pedido pedido) {
		return (float) (porcentajeFijo * pedido.costoProductos() + costoBase);
	}

	@Override
	public int diasDeEntrega(Pedido pedido) {
		return 1;
	}
}

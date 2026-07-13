package metodoDeEnvio;

import pedido.Pedido;

public class EnvioEstandar implements MetodoEnvio {
	
	private Direccion dirEntrega;
	private Correo correo;

	public EnvioEstandar(Direccion dirEntrega1,Correo correo1) {
		this.dirEntrega = dirEntrega1;
		this.correo = correo1;
	}
	
	public Direccion getDir() {
		return dirEntrega;
	}

	@Override
	public double costoEnvio(Pedido pedido) {
		return correo.estimarEnvio(pedido.getPeso(), dirEntrega);
	}

	@Override
	public int diasDeEntrega(Pedido pedido) {
		return correo.diasDeEntrega(dirEntrega);
	}
	
	

}

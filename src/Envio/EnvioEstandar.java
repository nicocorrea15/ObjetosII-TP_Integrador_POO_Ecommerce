package Envio;

import Pedido.Pedido;

public class EnvioEstandar extends Envio{
	
	private Direccion dirEntrega;
	private Correo correo;

	public EnvioEstandar(Pedido pedido,Direccion dirEntrega1,Correo correo1) {
		super(pedido);
		this.dirEntrega = dirEntrega1;
		this.correo = correo1;
	}
	
	public Direccion getDir() {
		return dirEntrega;
	}

	@Override
	public float costoEnvio() {
		return correo.estimarEnvio(pedido.getPeso(), dirEntrega);
	}

	@Override
	public int diasDeEntrega() {
		return correo.diasDeEntrega(dirEntrega);
	}
	
	

}

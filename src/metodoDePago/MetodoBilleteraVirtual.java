package metodoDePago;

public class MetodoBilleteraVirtual extends MetodoDePago {
	
	private APIBilleteraVirtual billeVirtual;
	
	public MetodoBilleteraVirtual(Cliente c, APIBilleteraVirtual bVirtual) {
		super(c);
		this.billeVirtual = bVirtual;
	}

	@Override
	public boolean validarDatos(Cliente c) {
		return billeVirtual.tieneSaldo(c);
	}

	@Override
	public void reservarFondos(Cliente c) {
		billeVirtual.bloquearSaldo(c);
	}

	@Override
	public void ejecutarTransaccion(Cliente c) {
		billeVirtual.acreditarAlDestinatario(c);
	}
	
	@Override 
	public void notificar(Cliente c) {
		billeVirtual.enviarNotificacionAlCliente(c);
	}
}

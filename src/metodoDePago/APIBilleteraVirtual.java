package metodoDePago;

public interface APIBilleteraVirtual {
	
	public boolean tieneSaldo(Cliente cliente);
	public void bloquearSaldo(Cliente cliente);
	public void acreditarAlDestinatario(Cliente cliente);
	public void enviarNotificacionAlCliente(Cliente cliente);
	
	}

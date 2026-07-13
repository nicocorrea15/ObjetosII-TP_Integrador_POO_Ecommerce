package metodoDePago;

public abstract class MetodoDePago {
	
	protected Cliente cliente;
	
	public MetodoDePago(Cliente c) {
		this.cliente = c;
	}
	
	public final void procesarPago() {
		
		if (!validarDatos(cliente)) {
            throw new RuntimeException("No es posible continuar, datos invalidos");
        }

        reservarFondos(cliente);
        ejecutarTransaccion(cliente);
        notificar(cliente);
    }
	
	public abstract boolean validarDatos(Cliente cliente); 
	public abstract void reservarFondos(Cliente cliente);
	public abstract void ejecutarTransaccion(Cliente cliente);
	
	public void notificar(Cliente cliente) {
		generarComprobanteGuardarYEnviarAlCliente(cliente);
	}
	
	public void generarComprobanteGuardarYEnviarAlCliente(Cliente c) {}

} 
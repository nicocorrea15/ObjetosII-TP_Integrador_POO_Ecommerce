package metodoDePago;

public class MetodoTransferenciaBancaria extends MetodoDePago {

	private APIBanco banco;
	
	public MetodoTransferenciaBancaria(Cliente c, APIBanco banco) {
		super(c);
		this.banco = banco;
	}
	
	@Override
	public boolean validarDatos(Cliente c) {
		return banco.esBancoValido(c);
	}

	@Override
	public void reservarFondos(Cliente c) {
	}

	@Override
	public void ejecutarTransaccion(Cliente c) {
		banco.transferir(c);
	}
}

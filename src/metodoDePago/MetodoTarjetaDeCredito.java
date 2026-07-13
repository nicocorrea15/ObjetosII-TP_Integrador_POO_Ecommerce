package metodoDePago;

public class MetodoTarjetaDeCredito extends MetodoDePago{
	
	private APITarjetaDeCredito tarjeta;
	
	public MetodoTarjetaDeCredito(Cliente c, APITarjetaDeCredito tarjeta1) {
		super(c);
		this.tarjeta = tarjeta1;
	}

	@Override
	public boolean validarDatos(Cliente c) {
		return tarjeta.esTarjetaValida(c);
	}

	@Override
	public void reservarFondos(Cliente c) {
		tarjeta.preservarFondos(c);
	}

	@Override
	public void ejecutarTransaccion(Cliente c) {
		tarjeta.transferenciaInmediata(c);
	}
}
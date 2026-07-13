package metodoDePago;

public interface APITarjetaDeCredito {
	
	public boolean esTarjetaValida(Cliente c);
	public void preservarFondos(Cliente c);
	public void transferenciaInmediata(Cliente c);
	public void cuponDePago(Cliente c);
}

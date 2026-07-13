package metodoDePago;

public interface APIBanco {
	
	public boolean esBancoValido(Cliente c);
	public void transferir(Cliente c);
	public void comprobanteDePago(Cliente c);

}

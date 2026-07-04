package Envio;

public interface Correo {
	
	public float estimarEnvio(float peso, Direccion direccionEnvio);
	public int diasDeEntrega(Direccion direccionEnvio);

}

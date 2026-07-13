package metodoDePago;

import metodoDeEnvio.*;

public interface Cliente {
	
	public Direccion getDireccion();
	public String getEmail();
	public String getNombre();
}

package ItemCatalogo;

public interface ItemCatalogo {
	
	public double getPrecioFinal();
	public double getPrecioBase();
	public String getDescripcion();
	public String getNombre();
	public void disminuirStock(int n);
	public void aumentarStock(int n);
	public int getStock();

}

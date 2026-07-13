package busquedaCatalogo;

import itemCatalogo.*;

public class PorNombre implements CriterioBusqueda {
	
	private String nombre;
	
	public PorNombre(String nombre1) {
		this.nombre = nombre1;
	}

	@Override
	public boolean cumple(ItemCatalogo item) {
		return item.getNombre().equals(nombre);
	}
}

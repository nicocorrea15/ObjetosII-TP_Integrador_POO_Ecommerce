package busquedaCatalogo;

import itemCatalogo.ItemCatalogo;

public class PorStock implements CriterioBusqueda {
	
	public PorStock() {
	}

	@Override
	public boolean cumple(ItemCatalogo item) {
		return item.getStock() > 0;
	}
}

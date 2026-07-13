package busquedaCatalogo;

import itemCatalogo.*;

public class NOT implements CriterioBusqueda {

    private CriterioBusqueda criterio;
    
    public NOT(CriterioBusqueda crit) {
    	criterio = crit;
    }

    @Override
    public boolean cumple(ItemCatalogo item){
    	return !criterio.cumple(item);
    }
}
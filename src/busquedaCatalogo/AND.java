package busquedaCatalogo;

import java.util.*;

import itemCatalogo.ItemCatalogo;

public class AND implements CriterioBusqueda {

    private ArrayList<CriterioBusqueda> criterios;
    
    public AND() {
    	criterios = new ArrayList<>();
    }

    @Override
    public boolean cumple(ItemCatalogo item){

        for(CriterioBusqueda c : criterios){

            if(!c.cumple(item))
                return false;
        }
        return true;
    }
    
    public void agregarCriterio(CriterioBusqueda cb) {
    	criterios.add(cb);
    }
}

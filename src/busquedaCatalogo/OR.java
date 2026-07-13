package busquedaCatalogo;

import java.util.*;

import itemCatalogo.*;

public class OR implements CriterioBusqueda {

    private ArrayList<CriterioBusqueda> criterios;
    
    public OR() {
    	criterios = new ArrayList<>();
    }

    @Override
    public boolean cumple(ItemCatalogo item){

        for(CriterioBusqueda c : criterios){

            if(c.cumple(item))
                return true;
        }
        
        return false;
    }
    
    public void agregarCriterio(CriterioBusqueda cb) {
    	criterios.add(cb);
    }

}

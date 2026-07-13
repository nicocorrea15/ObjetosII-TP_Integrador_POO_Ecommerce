package busquedaCatalogo;

import itemCatalogo.ItemCatalogo;

public class PorCategoria implements CriterioBusqueda {

    private String categoria;
    
    public PorCategoria(String cat) {
    	this.categoria = cat;
    }

    @Override
    public boolean cumple(ItemCatalogo item){
        return item.getCategoria().equals(categoria);
    }

}

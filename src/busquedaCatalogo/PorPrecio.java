package busquedaCatalogo;

import itemCatalogo.ItemCatalogo;

public class PorPrecio implements CriterioBusqueda {

    private double precioMax;

    public PorPrecio(double precioMax){
        this.precioMax = precioMax;
    }

    @Override
    public boolean cumple(ItemCatalogo item){
        return item.getPrecioBase() <= precioMax;
    }

}
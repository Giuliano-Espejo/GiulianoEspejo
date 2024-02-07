package ge.ec.Dto;

import ge.ec.Entity.Producto;

public class ProductoConverter {

    public static ProductoSinUser toDto(Producto p){
        return new ProductoSinUser(
                p.getId(),
                p.getTitulo(),
                p.getDescripcion(),
                p.getImagen()
        );
    }
}

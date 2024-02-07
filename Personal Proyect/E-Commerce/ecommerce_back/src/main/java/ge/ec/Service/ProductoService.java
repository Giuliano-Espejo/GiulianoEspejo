package ge.ec.Service;

import ge.ec.Dto.ProductoSinUser;
import ge.ec.Entity.Producto;

import java.util.List;

public interface ProductoService {
    public List<ProductoSinUser> findAll();
    public ProductoSinUser findById(Long id);
    public Producto update(Long id, Producto productoNuevo);
    public Producto save(Producto producto);
    public void delete(Long id);
}

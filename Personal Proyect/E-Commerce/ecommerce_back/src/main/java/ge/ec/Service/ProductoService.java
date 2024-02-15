package ge.ec.Service;


import ge.ec.Entity.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto update(Long id, Producto productoNuevo);
    public Producto save(Producto producto);
    public void delete(Long id);
    public List<Producto> buscar(String busqueda);
}

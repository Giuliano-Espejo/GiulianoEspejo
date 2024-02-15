package ge.ec.Repository;

import ge.ec.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public List<Producto> findByDeletedFalse();

    @Query("SELECT e FROM Producto e WHERE (e.titulo LIKE %:busqueda% OR e.descripcion LIKE %:busqueda%) AND e.deleted = false")
    List<Producto> findByTituloOrDescripcion(@Param("busqueda") String busqueda);

}

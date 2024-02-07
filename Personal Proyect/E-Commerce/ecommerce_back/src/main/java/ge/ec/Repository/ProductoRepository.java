package ge.ec.Repository;

import ge.ec.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public List<Producto> findByDeletedFalse();
}

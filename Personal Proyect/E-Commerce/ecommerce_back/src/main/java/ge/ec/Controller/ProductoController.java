package ge.ec.Controller;

import ge.ec.Dto.ProductoSinUser;
import ge.ec.Entity.Producto;
import ge.ec.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerce")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();
        try{
            List<ProductoSinUser> productos = productoService.findAll();
            response.put("productos: ", productos);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            ProductoSinUser productos = productoService.findById(id);
            response.put("producto", productos);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/producto")
    public ResponseEntity<?> save(@RequestBody Producto producto){
        Map<String, Object> response = new HashMap<>();
        try{
            Producto productos = productoService.save(producto);
            response.put("producto creado exitosamente: ", productos);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Producto producto){
        Map<String, Object> response = new HashMap<>();
        try{
            Producto productos = productoService.update(id, producto);
            response.put("producto editado exitosamente: ", productos);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            productoService.delete(id);
            response.put("producto eliminado exitosamente: ", "");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}

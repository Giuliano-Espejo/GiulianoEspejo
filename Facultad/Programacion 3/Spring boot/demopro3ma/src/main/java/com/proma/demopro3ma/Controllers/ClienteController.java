package com.proma.demopro3ma.Controllers;

import com.proma.demopro3ma.Models.ClienteModel;
import com.proma.demopro3ma.Service.ClienteService;
import com.proma.demopro3ma.entites.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Cliente> clientes = clienteService.findAll();
            response.put("Clientes: ", clientes );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Fallo ", " Error al buscar Clientes");
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }


    @GetMapping("/find/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Cliente> cliente = clienteService.findById(id);
            response.put("Clientes: ", cliente );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Fallo ", " Error al buscar Cliente");
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ClienteModel clienteModel){
        Map<String, Object> response = new HashMap<>();
        try {
            clienteService.crear(clienteModel);
            response.put("", "Cliente creado" );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Fallo ", " Error al crear cliente");
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}

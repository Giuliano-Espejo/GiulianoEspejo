package com.facu.restfacu.Controller;


import com.facu.restfacu.Entity.Persona;
import com.facu.restfacu.Service.PersonaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\"" + e.getMessage()));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findByid(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\"" + e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\"" + e.getMessage()));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> getOne(@RequestBody Persona persona){
        try {
            System.out.println("Recibo los datos en el controlador " + persona.getNombre());
            return ResponseEntity.status(HttpStatus.OK).body(personaService.save(persona));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\"" + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona persona){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, persona));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\"" + e.getMessage()));
        }
    }
}

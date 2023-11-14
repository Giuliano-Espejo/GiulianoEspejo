package com.facu.dummy.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/personas")
public class PersonaController {

    @GetMapping("dummy")
    public ResponseEntity<String> getDummy(){
        try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body("Lo que me solicitaste soy dummy");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\" error :\"Error. Por favor intente de nuevo luego\" }");
        }
    }

    @GetMapping("subRuta")
    public ResponseEntity<String> getChau (){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Lo que me solicitaste soy dummy del chau");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\" error :\"Error. Por favor intente de nuevo luego\" }");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Te devuelvo un registro de la base de datos con el ID buscado");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\" error :\"Error. Por favor intente de nuevo luego\" }");
        }
    }
    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody String persona){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Te devuelvo la persona creada " + persona);
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\" error :\"Error. Por favor intente de nuevo luego\" }");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody String persona){

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(" Te devuelvo la presona actualizada : " + persona);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(" Eliminaste el registro : " + id);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
}

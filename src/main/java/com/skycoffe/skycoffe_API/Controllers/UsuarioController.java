package com.skycoffe.skycoffe_API.Controllers;

import com.skycoffe.skycoffe_API.Models.Producto;
import com.skycoffe.skycoffe_API.Models.Usuario;
import com.skycoffe.skycoffe_API.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Usuario>GetAll(){
        return service.GetAll();
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity <Usuario> create (@RequestPart ("usuario")Usuario usuario, @RequestPart (value = "imagen", required = false) MultipartFile imagen) throws IOException {
        Usuario nuevo = service.create(usuario, imagen);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<Usuario> update (@PathVariable Integer id, @RequestPart("usuario") Usuario usuario, @RequestPart (value = "imangen", required = false) MultipartFile imagen) throws IOException {
        Usuario actualizado = service.update(id, usuario, imagen);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}

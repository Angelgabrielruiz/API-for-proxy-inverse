package com.skycoffe.skycoffe_API.Controllers;

import com.skycoffe.skycoffe_API.Models.Usuario;
import com.skycoffe.skycoffe_API.Services.UsuarioService;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return service.create(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id,@RequestBody Usuario usuario){
        return service.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}

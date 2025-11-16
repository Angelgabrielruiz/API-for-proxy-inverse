package com.skycoffe.skycoffe_API.Controllers;
import com.skycoffe.skycoffe_API.Models.Producto;
import com.skycoffe.skycoffe_API.Services.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    private final ProductoService service;

    public ProductoController ( ProductoService service){
        this.service = service;
    }

    @GetMapping
    public List<Producto> getAll(){
        return service.GetAll();
    }

    @PostMapping
    public Producto create (@RequestBody Producto producto){
        return service.create(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Integer id, @RequestBody Producto producto){
        return service.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}

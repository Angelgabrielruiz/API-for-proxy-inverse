package com.skycoffe.skycoffe_API.Controllers;
import com.skycoffe.skycoffe_API.Models.Producto;
import com.skycoffe.skycoffe_API.Services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity <Producto> create(@RequestPart ("producto") Producto producto, @RequestPart ( value = "imagen", required = false)MultipartFile imagen) throws  Exception {
    Producto nuevo = service.create(producto, imagen);
    return ResponseEntity.ok(nuevo);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<Producto> update (@PathVariable Integer id, @RequestPart("producto") Producto producto, @RequestPart (value = "imagen", required = false) MultipartFile imagen) throws IOException{

        Producto actualizado = service.update(id, producto, imagen);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}

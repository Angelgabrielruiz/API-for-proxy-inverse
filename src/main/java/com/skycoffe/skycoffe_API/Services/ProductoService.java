package com.skycoffe.skycoffe_API.Services;

import com.skycoffe.skycoffe_API.Models.Producto;
import com.skycoffe.skycoffe_API.Repositorys.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService (ProductoRepository repo){
        this.repo = repo;
    }

    public List<Producto>GetAll(){
        return repo.findAll();
    }

    public Producto create(Producto producto){
        return repo.save(producto);
    }

    public Producto update(Integer id, Producto newProducto){
        Producto producto = repo.findById(id).orElseThrow();

        producto.setNombre(newProducto.getNombre());
        producto.setPrecio(newProducto.getPrecio());
        producto.setCategoria(newProducto.getCategoria());
        producto.setDescripcion(newProducto.getDescripcion());
        producto.setImagen(newProducto.getImagen());

        return repo.save(producto);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}

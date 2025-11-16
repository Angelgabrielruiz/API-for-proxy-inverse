package com.skycoffe.skycoffe_API.Services;

import com.skycoffe.skycoffe_API.Models.Producto;
import com.skycoffe.skycoffe_API.Repositorys.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;
    private final CloudinaryService cloudinaryService;
    private final ProductoRepository productoRepository;

    public ProductoService (ProductoRepository repo, CloudinaryService cloudinaryService, ProductoRepository productoRepository){
        this.repo = repo;
        this.cloudinaryService = cloudinaryService;
        this.productoRepository = productoRepository;
    }

    public List<Producto>GetAll(){
        return repo.findAll();
    }

    public Producto create(Producto producto, MultipartFile imagen) throws Exception {
        if (imagen != null && !imagen.isEmpty()){
            String url = cloudinaryService.uploadImage(imagen);
            producto.setImagen(url);

        }
        return productoRepository.save(producto);

    }

    public Producto update(Integer id, Producto newProducto, MultipartFile imagen) throws IOException {
        Producto producto = repo.findById(id).orElseThrow();

        producto.setNombre(newProducto.getNombre());
        producto.setPrecio(newProducto.getPrecio());
        producto.setCategoria(newProducto.getCategoria());
        producto.setDescripcion(newProducto.getDescripcion());

        if (imagen != null && !imagen.isEmpty()){
            String url = cloudinaryService.uploadImage(imagen);
            producto.setImagen(url);
        }

        return repo.save(producto);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}

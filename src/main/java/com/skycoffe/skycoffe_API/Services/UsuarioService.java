package com.skycoffe.skycoffe_API.Services;

import com.skycoffe.skycoffe_API.Models.Usuario;
import com.skycoffe.skycoffe_API.Repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CloudinaryService cloudinaryService;

    public UsuarioService(UsuarioRepository usuarioRepository, CloudinaryService cloudinaryService){
        this.usuarioRepository = usuarioRepository;
        this.cloudinaryService = cloudinaryService;
    }

    public List<Usuario>GetAll(){
        return usuarioRepository.findAll();
    }

    public Usuario create(Usuario usuario, MultipartFile imagen) throws IOException {
        if (imagen != null && !imagen.isEmpty()){
            String url = cloudinaryService.uploadImage(imagen);
            usuario.setFoto_perfil(url);

        }
        return usuarioRepository.save(usuario);
    }

    public Usuario update (Integer id, Usuario newUsuario, MultipartFile imagen) throws IOException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNombre(newUsuario.getNombre());
        usuario.setCorreo(newUsuario.getCorreo());
        usuario.setTelefono(newUsuario.getTelefono());

        if (imagen != null && !imagen.isEmpty()){
            String url = cloudinaryService.uploadImage(imagen);
            usuario.setFoto_perfil(url);
        }

        return usuarioRepository.save(usuario);
    }

    public void delete(Integer id){
        usuarioRepository.deleteById(id);
    }

}

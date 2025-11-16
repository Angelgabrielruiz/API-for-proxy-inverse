package com.skycoffe.skycoffe_API.Services;

import com.skycoffe.skycoffe_API.Models.Usuario;
import com.skycoffe.skycoffe_API.Repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo){
        this.repo = repo;
    }

    public List<Usuario>GetAll(){
        return repo.findAll();
    }

    public Usuario create(Usuario usuario){
        return repo.save(usuario);
    }

    public Usuario update (Integer id, Usuario newUsuario){
        Usuario usuario = repo.findById(id).orElseThrow();

        usuario.setNombre(newUsuario.getNombre());
        usuario.setCorreo(newUsuario.getCorreo());
        usuario.setTelefono(newUsuario.getTelefono());
        usuario.setFoto_perfil(newUsuario.getFoto_perfil());

        return repo.save(usuario);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

}

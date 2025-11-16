package com.skycoffe.skycoffe_API.Repositorys;

import com.skycoffe.skycoffe_API.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

package com.skycoffe.skycoffe_API.Repositorys;

import com.skycoffe.skycoffe_API.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Integer> {


}
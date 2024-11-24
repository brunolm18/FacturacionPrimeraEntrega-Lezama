package com.coderhouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto,Long> {

	List<Producto> findByIdIn(List<Long> ids);
}

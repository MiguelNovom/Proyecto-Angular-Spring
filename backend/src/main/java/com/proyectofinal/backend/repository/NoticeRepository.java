package com.proyectofinal.backend.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectofinal.backend.entity.models.Noticias;

public interface NoticeRepository extends JpaRepository<Noticias, Serializable> {
	@Query("select n from Noticias n order by create_at desc")
	public List<Noticias> findAllOrderByDate();

}

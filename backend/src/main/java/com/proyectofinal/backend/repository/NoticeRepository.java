package com.proyectofinal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.backend.entity.models.Noticias;

public interface NoticeRepository extends JpaRepository<Noticias, Long> {

}

package com.Biblioteca.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.App.Model.Autor;

@Repository
public interface AutorRepository extends  JpaRepository<Autor, Integer> { } 



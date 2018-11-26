package com.Biblioteca.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.App.Model.Livro;

@Repository
public interface LivroRepository extends  JpaRepository<Livro, Integer> { } 



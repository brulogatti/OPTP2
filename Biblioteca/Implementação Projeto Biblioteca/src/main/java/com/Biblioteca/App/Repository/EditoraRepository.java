package com.Biblioteca.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.App.Model.Editora;

@Repository
public interface EditoraRepository extends  JpaRepository<Editora, Integer> { } 



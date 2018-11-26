package com.Biblioteca.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.App.Model.Resenha;

@Repository
public interface ResenhaRepository extends JpaRepository<Resenha, Integer> { } 


package com.Biblioteca.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.App.Model.Pessoa;

@Repository
public interface PessoaRepository extends  JpaRepository<Pessoa, Integer> { }   



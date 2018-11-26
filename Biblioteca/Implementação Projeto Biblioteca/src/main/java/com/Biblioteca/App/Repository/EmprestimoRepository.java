package com.Biblioteca.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.App.Model.Emprestimo;

@Repository
public interface EmprestimoRepository extends  JpaRepository<Emprestimo, Integer> { }  



package com.example.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
package com.example.mercado.controller;

import com.example.mercado.model.Produto;
import com.example.mercado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // Permite que seu front em Thymeleaf acesse a API
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // LISTAR TODOS
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    // CADASTRAR
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {

        return repository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    return repository.save(produto);
                })
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado com ID: " + id)
                );
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Produto removido com sucesso!";
        } else {
            return "Produto com ID " + id + " não encontrado.";
        }
    }
}

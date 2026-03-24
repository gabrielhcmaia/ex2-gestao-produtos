package com.ex2.ex2.Controller;

import com.ex2.ex2.Entity.Produto;
import com.ex2.ex2.Service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> postProduto(Produto prod){
        Produto savedProduct =produtoService.postProduto(prod);
        URI location = URI.create("/produtos"+savedProduct.getId());
        return ResponseEntity.created(location).body(savedProduct);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getAllProdutos(){
        return ResponseEntity.ok(produtoService.getAllProdutos());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id){
        return produtoService.getProdutoById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }


}

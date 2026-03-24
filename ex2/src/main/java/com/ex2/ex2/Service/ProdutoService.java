package com.ex2.ex2.Service;

import com.ex2.ex2.Entity.Produto;
import com.ex2.ex2.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto postProduto(Produto prod){
        return produtoRepository.save(prod);
    }

    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long prodId){
        return produtoRepository.findById(prodId);
    }

    public void deleteProduto(Long prodId){
        produtoRepository.deleteById(prodId);
    }

}

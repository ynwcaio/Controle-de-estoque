package com.api.products.service;

import com.api.products.DTO.ProdutcsDTO;
import com.api.products.model.entities.Products;
import com.api.products.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public List<ProdutcsDTO> findAll(){
        List<Products> result = productsRepository.findAll();
        return result.stream().map(ProdutcsDTO :: new).toList();
    }
}

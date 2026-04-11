package com.api.products.service;

import com.api.products.DTO.ProductDTO;
import com.api.products.exceptions.advice.ResourceNotFoundException;
import com.api.products.model.entities.Product;
import com.api.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productsRepository;

    public ProductService(ProductRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> result = productsRepository.findAll();
        return result.stream().map(ProductDTO:: new).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product entity = productsRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("product not found"));
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO insert(ProductDTO produtcsDTO){
        Product products = new Product();

        products.setName(produtcsDTO.getName());
        products.setType(produtcsDTO.getType());
        products.setQuantity(produtcsDTO.getQuantity());
        products.setPrice(produtcsDTO.getPrice());

        products = productsRepository.save(products);

        return new ProductDTO(products);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        Product products = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found"));

        products.setName(dto.getName());
        products.setType(dto.getType());
        products.setQuantity(dto.getQuantity());
        products.setPrice(dto.getPrice());

        products = productsRepository.save(products);

        return new ProductDTO(products);
    }

    @Transactional
    public void delete(Long id){
        Product products = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found"));

        productsRepository.delete(products);
    }
}

package com.api.products.controller;


import com.api.products.DTO.ProdutcsDTO;
import com.api.products.service.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping
    public List<ProdutcsDTO> findAll(){
        return productsService.findAll();
    }
}

package com.devsuperior.dscommerce.controller;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("{id}")
    public ProductDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
    @GetMapping("/all")
    public Page<ProductDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}

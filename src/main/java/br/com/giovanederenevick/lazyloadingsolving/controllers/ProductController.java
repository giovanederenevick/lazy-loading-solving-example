package br.com.giovanederenevick.lazyloadingsolving.controllers;

import br.com.giovanederenevick.lazyloadingsolving.dto.ProductDTO;
import br.com.giovanederenevick.lazyloadingsolving.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {

        Page<ProductDTO> list = productService.find(pageable);

        return ResponseEntity.ok(list);
    }
}

package br.com.giovanederenevick.lazyloadingsolving.services;

import br.com.giovanederenevick.lazyloadingsolving.dto.ProductDTO;
import br.com.giovanederenevick.lazyloadingsolving.repositories.ProductRepository;
import br.com.giovanederenevick.lazyloadingsolving.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> find(Pageable pageable) {

        Page<Product> page = productRepository.findAll(pageable);
        productRepository.findProductsCategories(page.stream().collect(Collectors.toList()));

        return page.map(ProductDTO::new);
    }
}

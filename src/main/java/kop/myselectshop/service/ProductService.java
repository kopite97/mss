package kop.myselectshop.service;

import kop.myselectshop.dto.ProductRequestDto;
import kop.myselectshop.dto.ProductResponseDto;
import kop.myselectshop.entity.Product;
import kop.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));

        return new ProductResponseDto(product);
    }
}

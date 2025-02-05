package kop.myselectshop.service;

import java.util.ArrayList;
import java.util.List;
import kop.myselectshop.dto.ProductMyPriceRequestDto;
import kop.myselectshop.dto.ProductRequestDto;
import kop.myselectshop.dto.ProductResponseDto;
import kop.myselectshop.entity.Product;
import kop.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public static final int MIN_MY_PRICE = 100;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));

        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductMyPriceRequestDto requestDto) {
        int myPrice = requestDto.getMyprice();
        if (myPrice < MIN_MY_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심가격");
        }

        Product product = productRepository.findById(id).orElseThrow(() ->
            new NullPointerException("해당 상품은 찾을 수 없습니다."));

        product.update(requestDto);

        return new ProductResponseDto(product);
    }

    public List<ProductResponseDto> getProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> responseDtoList = new ArrayList<>();

        for (Product product : productList) {
            responseDtoList.add(new ProductResponseDto(product));
        }

        return responseDtoList;
    }
}

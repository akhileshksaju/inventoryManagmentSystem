package com.akhi.microservices.product.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akhi.microservices.product.Exceptions.ResourceAlreadyExistsException;
import com.akhi.microservices.product.Model.Product;
import com.akhi.microservices.product.Repository.ProductRepository;
import com.akhi.microservices.product.dto.ProductRequest;
import com.akhi.microservices.product.dto.ProductResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;

  public ProductResponse createProduct(ProductRequest productRequest) {
    Product product = Product.builder().id(productRequest.getId()).name(productRequest.getName())
        .description(productRequest.getDescription()).price(productRequest.getPrice()).build();
    productRepository.findById(product.getId()).ifPresent(p -> {
      throw new ResourceAlreadyExistsException("resourse already exist ");
    });

    productRepository.save(product);
    log.info("product created");
    return ProductResponse.builder().id(product.getId()).name(product.getName()).description(product.getDescription())
        .price(product.getPrice()).build();
  }

  public List<ProductResponse> getAllProducts() {
    // TODO Auto-generated method stub
    Pageable pageable = PageRequest.of(0, 10);
    List<Product> products = productRepository.findAll(pageable).getContent();

    List<ProductResponse> productResponses = products.stream().map(m -> ProductResponse.builder().id(m.getId())
        .name(m.getName()).description(m.getDescription()).price(m.getPrice()).build()).collect(Collectors.toList());

    return productResponses;

  }

  public void createProducts(List<ProductRequest> productRequests) {
    // TODO Auto-generated method stub

    List<Product> products = productRequests.stream()
        .map(x -> Product.builder().name(x.getName()).description(x.getDescription()).price(x.getPrice()).build())
        .collect(Collectors.toList());

    productRepository.saveAll(products);

  }

}

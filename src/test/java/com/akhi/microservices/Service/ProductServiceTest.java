package com.akhi.microservices.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.akhi.microservices.product.Model.Product;
import com.akhi.microservices.product.Repository.ProductRepository;
import com.akhi.microservices.product.Service.ProductService;
import com.akhi.microservices.product.dto.ProductRequest;
import com.akhi.microservices.product.dto.ProductResponse;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

  @Mock
  public ProductRepository productRepository;

  @InjectMocks
  public ProductService productService;

  @Test
  public void productServiceTest() {
    when(productRepository.save(any(Product.class))).thenReturn(getProductResponse());

    ProductResponse prodResp = productService.createProduct(getProductRequests());

    assertEquals(getProductRequests().getName(), prodResp.getName());

  }

  private Product getProductResponse() {
    // TODO Auto-generated method stub
    return Product.builder().name("i phone 13").id("1").description("good phone").price(BigDecimal.valueOf(2000))
        .build();
  }

  private ProductRequest getProductRequests() {
    // TODO Auto-generated method stub
    return ProductRequest.builder().id("1").name("i phone 13").description("good phone").price(BigDecimal.valueOf(2000))
        .build();
  }

}

package com.akhi.microservices.product.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.akhi.microservices.product.Service.ProductService;
import com.akhi.microservices.product.dto.ProductRequest;
import com.akhi.microservices.product.dto.ProductResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping()
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
    // TODO: process POST request

    return productService.createProduct(productRequest);
  }

  @GetMapping()
  public List<ProductResponse> getAllProduct() {
    return productService.getAllProducts();
  }

  @PostMapping("/admin")
  @ResponseStatus(HttpStatus.OK)
  public String createProducts(@RequestBody List<ProductRequest> productRequests) {
    // TODO: process POST request

    productService.createProducts(productRequests);

    return "products added success fully";
  }

}

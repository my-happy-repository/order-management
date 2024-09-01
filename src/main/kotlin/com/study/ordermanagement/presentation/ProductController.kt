package com.study.ordermanagement.presentation

import com.study.ordermanagement.application.ProductService
import com.study.ordermanagement.presentation.dto.ProductResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService,
) {

    @GetMapping("/products")
    fun getProducts() : List<ProductResponse> =
        productService.findAllProducts().map { product -> ProductResponse.toProductResponse(product = product) }

}
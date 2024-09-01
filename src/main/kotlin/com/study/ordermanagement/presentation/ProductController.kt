package com.study.ordermanagement.presentation

import com.study.ordermanagement.application.ProductService
import com.study.ordermanagement.presentation.dto.ProductResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService,
) {

    @GetMapping("/products")
    fun getProducts() : List<ProductResponse> =
        productService.findAllProducts().map { product -> ProductResponse.toProductResponse(product = product) }

    @GetMapping("/products/{productId}")
    fun getProductById (
        @PathVariable(name = "productId") id: Long
    ): ProductResponse =
        ProductResponse.toProductResponse(
            product = productService.findProductById(id = id)
        )
}
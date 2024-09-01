package com.study.ordermanagement.application

import com.study.ordermanagement.domain.Product
import com.study.ordermanagement.infrastructure.ListProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ListProductRepository,
) {

    fun findAllProducts(): List<Product> = productRepository.findAll()

    fun findProductById(id: Long): Product = productRepository.findById(id)

}

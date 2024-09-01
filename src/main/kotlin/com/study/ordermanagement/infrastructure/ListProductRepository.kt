package com.study.ordermanagement.infrastructure

import com.study.ordermanagement.domain.Product
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Repository

@Repository
class ListProductRepository {
    @PostConstruct
    fun initProducts() {
        val product1 = Product(id = 1L, name = "상품1", price = 10000, amount = 100)
        val product2 = Product(id = 2L, name = "상품2", price = 25000, amount = 300)
        val product3 = Product(id = 3L, name = "상품3", price = 30000, amount = 500)

        products.add(product1)
        products.add(product2)
        products.add(product3)
    }

    fun findById(id: Long): Product {
        return products.first { product -> product.id == id } ?: throw RuntimeException("Product with id $id not found")
    }

    fun findAll(): List<Product> = products

    companion object {
        val products: MutableList<Product> = mutableListOf<Product>()
    }
}

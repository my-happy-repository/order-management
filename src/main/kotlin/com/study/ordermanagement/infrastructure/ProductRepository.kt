package com.study.ordermanagement.infrastructure

import com.study.ordermanagement.domain.Product

interface ProductRepository {

    fun findAll(): List<Product>

    fun findById(id: Long): Product?

    fun update(product: Product): Product
}
package com.study.ordermanagement.presentation.dto

import com.study.ordermanagement.domain.Product

data class ProductResponse(
    val id: Long,
    val name: String,
    val price: Int,
    val amount: Int,
) {
    companion object {
        fun toProductResponse(product: Product): ProductResponse {
            return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                amount = product.amount,
            )
        }
    }
}

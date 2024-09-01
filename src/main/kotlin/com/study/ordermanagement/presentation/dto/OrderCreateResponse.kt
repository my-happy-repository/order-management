package com.study.ordermanagement.presentation.dto

import com.study.ordermanagement.domain.OrderCreate
import com.study.ordermanagement.domain.OrderStatusCode

data class OrderCreateResponse (
    val id: Long,
    val orderProducts: List<ProductResponse>,
    val totalPrice: Long,
    val status: OrderStatusCode,
) {
    companion object {
        fun toOrderCreateResponse(orderCreate: OrderCreate): OrderCreateResponse {
            return OrderCreateResponse(
                id = orderCreate.id,
                orderProducts =
                    orderCreate.orderedProducts.map { product -> ProductResponse.toProductResponse(product = product) },
                totalPrice = orderCreate.totalPrice,
                status = orderCreate.status,
            )
        }
    }
}
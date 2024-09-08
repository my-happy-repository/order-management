package com.study.ordermanagement.domain

import com.study.ordermanagement.type.OrderStatusCode

data class OrderCreate(
    val id: Long,
    val orderedProducts: List<Product>,
    val totalPrice: Long,
    val status: OrderStatusCode,
)

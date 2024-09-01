package com.study.ordermanagement.domain

data class OrderCreate(
    val id: Long,
    val orderedProducts: List<Product>,
    val totalPrice: Long,
    val state: OrderStatusCode,
)

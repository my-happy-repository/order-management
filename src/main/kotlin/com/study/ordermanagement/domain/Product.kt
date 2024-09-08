package com.study.ordermanagement.domain

import org.springframework.http.HttpStatus

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    var amount: Int,
) {
    fun checkOrderAmountOrThrow(orderAmount: Int) {
        if (orderAmount > this.amount) {
            throw OrderManagementException.ProductAmountNotEnoughToOrder(
                status = HttpStatus.BAD_REQUEST,
                message = "주문 수량이 재고 수량보다 많아 주문이 불가 합니다.",
            )
        }
    }

    fun decreaseStockAmountByOrderAmount(orderAmount: Int) {
        this.amount -= orderAmount
    }
}

fun List<Product>.totalProductOrderPrice() =
    this.sumOf { it.price * it.amount }

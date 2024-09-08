package com.study.ordermanagement.domain

import com.study.ordermanagement.presentation.dto.OrderCreateRequest

data class OrderRequest(
    val id: Long,
    val amount: Int,
) {
    companion object {
        fun of(orders: List<OrderCreateRequest>): List<OrderRequest> {
            return orders.map { order ->
                OrderRequest(
                    id = order.id,
                    amount = order.amount,
                )
            }
        }
    }
}

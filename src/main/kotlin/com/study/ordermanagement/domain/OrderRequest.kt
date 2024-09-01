package com.study.ordermanagement.domain

import com.study.ordermanagement.presentation.dto.OrderCreateRequest

data class OrderRequest(
    val id: Long,
    val amount: Int,
) {
    companion object {
        fun of(order: OrderCreateRequest): OrderRequest {
            return OrderRequest(
                id = order.id,
                amount = order.amount,
            )
        }
    }
}

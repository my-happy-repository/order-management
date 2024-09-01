package com.study.ordermanagement.domain

import com.study.ordermanagement.presentation.dto.OrderCreateRequestDto

data class OrderRequest(
    val id: Long,
    val amount: Int,
) {
    companion object {
        fun of(order: OrderCreateRequestDto): OrderRequest {
            return OrderRequest(
                id = order.id,
                amount = order.amount,
            )
        }
    }
}

package com.study.ordermanagement.application

import com.study.ordermanagement.domain.OrderCreate
import com.study.ordermanagement.domain.OrderRequest
import com.study.ordermanagement.domain.OrderStatusCode
import com.study.ordermanagement.infrastructure.ListProductRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val listProductRepository: ListProductRepository,
) {
    fun createOrder(orderRequest: OrderRequest): OrderCreate {
        return OrderCreate(
            id = 1,
            orderedProducts = emptyList(),
            totalPrice = 1,
            status = OrderStatusCode.CREATED,
        )
    }
}

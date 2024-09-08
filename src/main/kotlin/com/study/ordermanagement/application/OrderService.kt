package com.study.ordermanagement.application

import com.study.ordermanagement.domain.OrderCreate
import com.study.ordermanagement.domain.OrderRequest
import com.study.ordermanagement.domain.Product
import com.study.ordermanagement.domain.totalProductOrderPrice
import com.study.ordermanagement.type.OrderStatusCode
import com.study.ordermanagement.infrastructure.ListProductRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val listProductRepository: ListProductRepository,
) {
    fun createOrders(orderRequests: List<OrderRequest>): OrderCreate {
        // 1. 주문이 가능한 수랭 만큼 있는 지 확인
        val products = orderRequests.map { orderRequest ->
            val product = listProductRepository.findById(id = orderRequest.id)

            // 주문이 가능한지 확인, 만약 주문 수량이 부족하면 Exceptiob
            product.checkOrderAmountOrThrow(orderAmount = orderRequest.amount)

            Product(
                id = product.id,
                name = product.name,
                amount = orderRequest.amount,
                price = product.price,
            )
        }

        // 주문 한 수량 만큼 차감
        decreaseProductsStockAmountByOrderAmount(orderProducts = products)

        return OrderCreate(
            id = 1,
            orderedProducts = products,
            totalPrice = products.totalProductOrderPrice().toLong(),
            status = OrderStatusCode.CREATED,
        )
    }

    fun decreaseProductsStockAmountByOrderAmount(orderProducts: List<Product>) {
        orderProducts.forEach { orderProduct ->
            val product = listProductRepository.findById(id = orderProduct.id)

            product.decreaseStockAmountByOrderAmount(orderAmount = orderProduct.amount)

            listProductRepository.update(product = product)
        }
    }
}

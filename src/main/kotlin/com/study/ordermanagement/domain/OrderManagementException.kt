package com.study.ordermanagement.domain

import org.springframework.http.HttpStatus

sealed class OrderManagementException(
    val status: HttpStatus,
    override val message: String = "",
) : RuntimeException(message) {

    class ProductNotFound(status: HttpStatus, override val message: String) :
        OrderManagementException(status, message)

    class ProductAmountNotEnoughToOrder(status: HttpStatus, override val message: String) :
            OrderManagementException(status, message)
}

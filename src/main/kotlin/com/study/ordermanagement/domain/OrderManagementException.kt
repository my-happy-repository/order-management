package com.study.ordermanagement.domain

sealed class OrderManagementException(
    val status: Int,
    override val message: String = "",
) : RuntimeException(message) {

    class ProductNotFound(status: Int, override val message: String) :
        OrderManagementException(status, message)
}

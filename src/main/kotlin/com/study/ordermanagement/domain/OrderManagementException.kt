package com.study.ordermanagement.domain

sealed class OrderManagementException(override val message: String = "") :
    RuntimeException(message) {
    data class ProductNotFound(override val message: String) :
        OrderManagementException()
}

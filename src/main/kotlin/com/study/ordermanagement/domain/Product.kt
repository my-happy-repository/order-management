package com.study.ordermanagement.domain

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    var amount: Int,
)

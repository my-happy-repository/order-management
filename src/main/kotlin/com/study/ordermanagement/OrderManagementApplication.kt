package com.study.ordermanagement

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class OrderManagementApplication

fun main(args: Array<String>) {
	runApplication<OrderManagementApplication>(*args)
}

//@PostConstruct
//fun initProducts() {
//	val product1 = Product(1L, "상품1", 10000, 100)
//	val product2 = Product(2L, "상품2", 25000, 300)
//	val product3 = Product(3L, "상품3", 30000, 500)
//	products.add(product1)
//	products.add(product2)
//	products.add(product3)
//}

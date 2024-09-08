package com.study.ordermanagement.presentation

import com.study.ordermanagement.application.OrderService
import com.study.ordermanagement.domain.OrderRequest
import com.study.ordermanagement.presentation.dto.OrderCreateRequest
import com.study.ordermanagement.presentation.dto.OrderCreateResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService,
) {
    // 클라이언트에게 주문하려는 상품 번호와 주문 수량을 받아 주문 정보를 생성, 생성 된 주문 정보는 응답 바디에
    // 담겨 클라이언트에게 전송 됨
    // 주문 상태는 생성, 배송중, 완료, 취소
    @PostMapping("/orders")
    fun orderProducts(
        @RequestBody orderRequest: List<OrderCreateRequest>,
    ): OrderCreateResponse =
        OrderCreateResponse.toOrderCreateResponse(
            orderCreate = orderService.createOrders(
                orderRequests =
                    OrderRequest.of(
                        orders = orderRequest
                    )
            )
        )
}

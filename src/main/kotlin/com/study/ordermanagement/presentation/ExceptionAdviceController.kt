package com.study.ordermanagement.presentation

import com.study.ordermanagement.domain.ExceptionResponse
import com.study.ordermanagement.domain.OrderManagementException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdviceController {

    @ExceptionHandler(OrderManagementException::class)
    fun orderManagementExceptionHandler(exception: OrderManagementException): ExceptionResponse {
        return ExceptionResponse(
            httpStatusCode = exception.status.value(),
            httpStatus = exception.status,
            message = exception.message,
        )
    }
}

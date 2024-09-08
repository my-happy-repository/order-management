package com.study.ordermanagement.presentation

import com.study.ordermanagement.domain.ExceptionResponse
import com.study.ordermanagement.domain.OrderManagementException
import org.springframework.http.HttpStatus
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

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(exception: Exception): ExceptionResponse {
        return ExceptionResponse(
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = exception.message.orEmpty(),
        )
    }
}

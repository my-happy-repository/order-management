package com.study.ordermanagement.domain

import org.springframework.http.HttpStatus

data class ExceptionResponse(
    val httpStatusCode: Int,
    val httpStatus: HttpStatus,
    val message: String,
)

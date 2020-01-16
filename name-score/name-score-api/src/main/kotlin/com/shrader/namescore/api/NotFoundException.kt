package com.shrader.namescore.api

class NotFoundException(private val code: Int, msg: String) : ApiException(code, msg)

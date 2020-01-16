package com.shrader.namescore.api

open class ApiException(private val code: Int, msg: String) : Exception(msg)

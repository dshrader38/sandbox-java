package com.shrader.namescore.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.validation.Valid
import javax.validation.constraints.NotNull


interface AddApi {
    @GetMapping("/add")
    fun add(@NotNull @Valid @RequestParam(value = "lhs", required = true) lhs: Long,
            @NotNull @Valid @RequestParam(value = "rhs", required = true) rhs: Long)
            : String //ResponseEntity<Model200>
}
package com.mercadolivro.controller

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.PostCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer")
class CustomerController {

    @GetMapping
    fun getcustomer(): CustomerModel{
        return CustomerModel("1", "brunno", "brunno_012@hotmail.com")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // serve para mudar o status para 201 confirmando a criação do objeto
    fun create(@RequestBody customer: PostCustomerRequest){
        println(customer)
    }
}
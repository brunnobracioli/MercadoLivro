package com.mercadolivro.controller

import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.PostCustomerRequest
import com.mercadolivro.request.PutCustomerRequest
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer")
class CustomerController(val customerService : CustomerService) {

    @GetMapping //query params
    fun allCustomer(@RequestBody name: String?): List<CustomerModel> {
        return customerService.allCustomer(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // serve para mudar o status para 201 confirmando a criação do objeto
    fun createCustomer(@RequestBody customer: PostCustomerRequest){
        customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun findCustomer(@PathVariable id: Int): CustomerModel{
        return customerService.findCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest){
        customerService.updateCustomer(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int){
        customerService.deleteCustomer(id)
    }

}
package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.PostCustomerRequest
import com.mercadolivro.request.PutCustomerRequest
import org.springframework.stereotype.Service


@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun allCustomer(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun createCustomer(customer: PostCustomerRequest){
        val id = if(customers.isEmpty()){
            1
        }else{
            customers.last().id.toInt() + 1
        }.toString()
        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    fun findCustomer(id: String): CustomerModel{
        return customers.filter { it.id == id }.first()
    }

    fun updateCustomer(id: String, customer: PutCustomerRequest){
        customers.filter{it.id == id}.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: String){
        customers.removeIf{it.id == id}
    }

}
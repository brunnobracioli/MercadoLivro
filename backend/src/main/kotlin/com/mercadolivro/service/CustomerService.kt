package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
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

    fun createCustomer(customer: CustomerModel){
        val id = if(customers.isEmpty()){
            1
        }else{
            customers.last().id!!.toInt() + 1
        }
        customer.id = id
        customers.add(customer)
    }

    fun findCustomer(id: Int): CustomerModel{
        return customers.filter { it.id == id }.first()
    }

    fun updateCustomer(customer: CustomerModel ){
        customers.filter{it.id == customer.id}.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: Int){
        customers.removeIf{it.id == id}
    }

}
package com.bsac.buro.web.rest.controller

import com.bsac.buro.model.Customer
import com.bsac.buro.model.Order
import com.bsac.buro.repository.CustomerRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
@Tag(name = "Customer Controller", description = "Контроллер для работы с аказчиками на проектирование многоэтажных домов")
class CustomerControllerRest(private val customerRepository: CustomerRepository) {

    @Operation(summary = "Метод получения всех заказчиков на проектирования многоэтажных домов")
    @GetMapping
    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    @Operation(summary = "Метод получения информации о заказчике на проектирования многоэтажных домов по ее ID")
    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id:Long): Customer {
        return customerRepository.findById(id).get()
    }
}
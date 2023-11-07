package com.bsac.buro.web.rest.controller

import com.bsac.buro.model.Order
import com.bsac.buro.service.web.OrderServiceWeb
import com.bsac.buro.web.dto.req.OrderDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Order Controller", description = "Контроллер для работы с заказами на проектирование многоэтажных домов")
class OrderControllerRest(private val orderServiceWeb: OrderServiceWeb) {

    @Operation(summary = "Метод получения всех заявок на проектирования многоэтажных домов")
    @GetMapping
    fun getAllOrders(): List<Order> {
        return orderServiceWeb.getAllOrders()
    }

    @Operation(summary = "Метод получения информации о заявке на проектирования многоэтажных домов по ее ID")
    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id:Long): Order {
        return orderServiceWeb.getById(id)
    }

    @Operation(summary = "Метод создание заявки на проектирования многоэтажных домов")
    @PostMapping
    fun createOrder(@RequestBody orderDto: OrderDto): Order {
        return orderServiceWeb.createOrder(orderDto)
    }

    @Operation(summary = "Метод удаление заявки на проектирования многоэтажных домов по ее ID")
    @DeleteMapping("{id}")
    fun deleteOrder(@PathVariable id: Long) {
        orderServiceWeb.deleteById(id)
    }
}
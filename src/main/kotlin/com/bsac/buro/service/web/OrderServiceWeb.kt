package com.bsac.buro.service.web

import com.bsac.buro.model.Customer
import com.bsac.buro.model.Order
import com.bsac.buro.model.OrderStatus
import com.bsac.buro.repository.CustomerRepository
import com.bsac.buro.repository.OrderRepository
import com.bsac.buro.web.dto.req.OrderDto
import com.bsac.buro.web.dto.req.OrderDtoEdit
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class OrderServiceWeb(
    private val orderRepository: OrderRepository,
    private val customerRepository: CustomerRepository,
    private val constructorServiceWeb: ConstructorServiceWeb
) {

    @Transactional
    fun createOrder(orderDto: OrderDto): Order {
        var customer = customerRepository.save(Customer(orderDto.customerName, orderDto.customerEmail, orderDto.phone))

        var order = Order(
            OrderStatus.REGISTERED,
            customer,
            orderDto.floors,
            orderDto.apartments,
            orderDto.area,
            orderDto.style,
            orderDto.floorArea,
            orderDto.plan,
            orderDto.ratio,
            orderDto.wishes,
            0.0
        )
        return orderRepository.save(order)
    }

    fun getById(id: Long): Order {
        return orderRepository.findById(id).get()
    }

    fun getAllOrdersByStatus(status: OrderStatus): List<Order> {
        return orderRepository.findAllByStatus(status)
    }

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }

    fun changeOrderStatus(id: Long, status: OrderStatus) {
        var order = orderRepository.findById(id).get();
        order.status = status
        orderRepository.save(order);
    }

    fun deleteById(id: Long) {
        orderRepository.deleteById(id)
    }

    fun editOrder(orderDto: OrderDtoEdit): Order {
        val order = orderRepository.findById(orderDto.id).get()
        order.status = orderDto.status
        order.floors = orderDto.floors
        order.apartments = orderDto.apartments
        order.area = orderDto.area
        order.style = orderDto.style
        order.floorArea = orderDto.floorArea
        order.plan = orderDto.plan
        order.ratio = orderDto.ratio
        order.wishes = orderDto.wishes
        order.cost = orderDto.cost

        val saveOrder = orderRepository.save(order)
        constructorServiceWeb.addOrdersToConstructor(orderDto.constructorId, saveOrder)
        return saveOrder
    }
}
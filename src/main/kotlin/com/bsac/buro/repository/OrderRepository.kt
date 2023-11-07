package com.bsac.buro.repository

import com.bsac.buro.model.Order
import com.bsac.buro.model.OrderStatus
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {

    fun findAllByStatus(status:OrderStatus): List<Order>

}
package com.bsac.buro.service.web

import com.bsac.buro.model.Constructor
import com.bsac.buro.model.Order
import com.bsac.buro.repository.ConstructorRepository
import org.springframework.stereotype.Service

@Service
class ConstructorServiceWeb(private var constructorRepository: ConstructorRepository) {


    fun getAllConstructors(): List<Constructor> {
        return constructorRepository.findAll()
    }

    fun getConstructorById(id: Long): Constructor {
        return constructorRepository.findById(id).get()
    }

    fun addOrdersToConstructor(constructorId: Long, order: Order) {
        var constructor = getConstructorById(constructorId)

        constructor.orders.add(order)

        constructorRepository.save(constructor)
    }
}
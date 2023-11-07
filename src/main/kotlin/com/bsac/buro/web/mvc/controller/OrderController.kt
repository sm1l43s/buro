package com.bsac.buro.web.mvc.controller

import com.bsac.buro.model.OrderStatus
import com.bsac.buro.repository.RoleRepository
import com.bsac.buro.repository.UserRepository
import com.bsac.buro.service.web.ConstructorServiceWeb
import com.bsac.buro.service.web.OrderServiceWeb
import com.bsac.buro.service.web.UserServiceWeb
import com.bsac.buro.web.dto.req.OrderDto
import com.bsac.buro.web.dto.req.OrderDtoEdit
import com.bsac.buro.web.dto.req.UserDto
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
class OrderController(
    private val orderServiceWeb: OrderServiceWeb,
    private val constructorServiceWeb: ConstructorServiceWeb,
    private val userServiceWeb: UserServiceWeb
) {

    @GetMapping("/")
    fun home(): ModelAndView {
        var modelAndView = ModelAndView("index")
        modelAndView.addObject("authority",
            SecurityContextHolder.getContext().authentication.authorities.stream().toList()[0]
        )
        return modelAndView
    }

    @GetMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/users")
    fun getUsers(): ModelAndView {
        var modelAndView = ModelAndView("users")
        modelAndView.addObject("users", userServiceWeb.getAllUsers())
        return modelAndView
    }

    @GetMapping("/users/delete/{id}")
    fun deleteUserById(@PathVariable id: Long): String {
        userServiceWeb.deleteUserById(id)
        return "redirect:/users"
    }

    @GetMapping("/register")
    fun register(): String {
        return "register"
    }

    @PostMapping("/register")
    fun createUser(@ModelAttribute userDto: UserDto): String {
        userServiceWeb.createUser(userDto)
        return "redirect:/login"
    }

    @GetMapping("/orders/{id}")
    fun getOrdersById(@PathVariable id: Long): ModelAndView {
        var modelAndView = ModelAndView("orderInfo")
        modelAndView.addObject("orders", listOf(orderServiceWeb.getById(id)))
        return modelAndView
    }

    @GetMapping("/orders")
    fun getOrdersByStatusRegistered(): ModelAndView {
        var modelAndView = ModelAndView("orders")
        modelAndView.addObject("orders", orderServiceWeb.getAllOrdersByStatus(OrderStatus.REGISTERED))
        return modelAndView
    }

    @GetMapping("/constructors")
    fun getOrderByStatusAssigned(
        @RequestParam(value = "constructorId", required = false, defaultValue = "0") constructorId: Long): ModelAndView {
        var modelAndView = ModelAndView("constructors")

        if (constructorId == 0.toLong()) {
            modelAndView.addObject("orders", orderServiceWeb.getAllOrders())
        } else {
            modelAndView.addObject("orders", constructorServiceWeb.getConstructorById(constructorId).orders)
        }

        modelAndView.addObject("constructors", constructorServiceWeb.getAllConstructors())

        return modelAndView
    }

    @GetMapping("/orders/remove/{id}")
    fun removeOrderById(@PathVariable id: Long): String {
        orderServiceWeb.deleteById(id)
        return "redirect:/"
    }

    @GetMapping("/orders/edit/{id}")
    fun editOrderById(@PathVariable id: Long): ModelAndView {
        var modelAndView = ModelAndView("orderEdit")
        modelAndView.addObject("constructors", constructorServiceWeb.getAllConstructors())
        modelAndView.addObject("order", orderServiceWeb.getById(id))
        return modelAndView
    }

    @PostMapping("/order")
    fun createOrder(@ModelAttribute order: OrderDto): String {
        val order = orderServiceWeb.createOrder(order);
        return "redirect:/orders/" + order.id
    }

    @PostMapping("/orderUpdate")
    fun editOrder(@ModelAttribute order: OrderDtoEdit): String {
        orderServiceWeb.editOrder(order);
        return "redirect:/orders"
    }

    @PostMapping("/orders/{id}")
    fun changeStatus(@PathVariable id: Long, @ModelAttribute status: OrderStatus): String {
        orderServiceWeb.changeOrderStatus(id, status)
        return "redirect:/orders/" + id
    }
}
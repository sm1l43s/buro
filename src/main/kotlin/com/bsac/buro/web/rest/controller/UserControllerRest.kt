package com.bsac.buro.web.rest.controller

import com.bsac.buro.model.Customer
import com.bsac.buro.model.User
import com.bsac.buro.service.web.UserServiceWeb
import com.bsac.buro.web.dto.req.UserDto
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
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "Контроллер для работы с сотрудниками системмы")
class UserControllerRest(private val userServiceWeb: UserServiceWeb) {

    @Operation(summary = "Метод получения всех сотрудников в системе")
    @GetMapping
    fun getAllCustomers(): List<User> {
        return userServiceWeb.getAllUsers()
    }

    @Operation(summary = "Метод добавления сотрудника в систему")
    @PostMapping
    fun createUser(@RequestBody user: UserDto): User {
        return userServiceWeb.createUser(user)
    }

    @Operation(summary = "Метод удаления сотрудника в системе по его ID")
    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id:Long) {
        userServiceWeb.deleteUserById(id)
    }
}
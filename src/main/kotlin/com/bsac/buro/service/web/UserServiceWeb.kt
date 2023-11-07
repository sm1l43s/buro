package com.bsac.buro.service.web

import com.bsac.buro.model.Role
import com.bsac.buro.model.User
import com.bsac.buro.repository.RoleRepository
import com.bsac.buro.repository.UserRepository
import com.bsac.buro.web.dto.req.UserDto
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceWeb(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun createUser(userDto: UserDto): User {
        var role = roleRepository.findByName(userDto.role)
         val user = User(userDto.name, userDto.email, passwordEncoder.encode(userDto.password), role)
        userRepository.save(user)
        return userRepository.save(user)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun deleteUserById(id: Long) {
        return userRepository.deleteById(id)
    }
}
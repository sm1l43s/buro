package com.bsac.buro.repository

import com.bsac.buro.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {

    fun findByName(name: String): Role
}
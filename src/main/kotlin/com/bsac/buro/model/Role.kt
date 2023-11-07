package com.bsac.buro.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "roles")
@Schema(description = "Описывает роль сотрудника в системе")
data class Role(
    @Column(nullable = false)
    @Schema(description = "Наименование должности сотрудника", example = "MANAGER")
    private val name: String

): GrantedAuthority {
    override fun getAuthority(): String {
        return name.uppercase()
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Уникальный ID роли в системе", example = "31")
    private val id: Long = 0
}
package com.bsac.buro.model

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*

@Entity
@Table(name = "users")
@Schema(description = "Описивает сотрудника системы")
class User(
    @Column(nullable = false)
    @Schema(description = "Ф.И.О. сотрудника", example = "Тлиюбаев Д.В.")
    val name: String,

    @Column(nullable = false)
    @Schema(description = "Емайл сострудника", example = "someEmail@mail.com")
    val email: String,

    @JsonIgnore
    @Column(nullable = false)
    @Schema(description = "Пароль сотрудника", example = "Храниться в зашиврованном BCrypt ввиде в БД")
    val password: String,

    @ManyToOne
    @Schema(description = "Роль сотрудника в системе", example = "MANAGER")
    val role: Role
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Уникальный ID сотрудника в системе", example = "131")
    val id: Long = 100
}
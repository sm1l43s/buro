package com.bsac.buro.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*

@Entity
@Table(name = "customers")
@Schema(description = "Описывает пользователя подавшего заявку на проектирование многоэтажных домов в системе")
class Customer(
    @Column(name = "name", nullable = false)
    @Schema(description = "Ф.И.О пользователя в системе", example = "Тлюбаев Дмитрий ")
    var name: String,

    @Column(name = "email", nullable = false)
    @Schema(description = "Емайл пользователя в системе", example = "someEmail@mail.com")
    var email: String,

    @Column(name = "phone", nullable = false)
    @Schema(description = "Телефон пользователя в системе", example = "+375339009876")
    var phone: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Уникальный ID пользователя в системе", example = "1")
    var customerId: Long = 0
}
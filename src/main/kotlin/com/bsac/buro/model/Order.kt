package com.bsac.buro.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*

@Entity
@Table(name = "orders")
@Schema(description = "Описывает заявку на проектирование многоэтажных домов в системе")
class Order(

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @Schema(description = "Текущий статус заявки на проектирование многоэтажных домов в системе", example = "REGISTERED")
    var status: OrderStatus,

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @Schema(description = "Пользователя подавший заявку на проектирование многоэтажных домов в системе")
    var customer: Customer,

    @Column(nullable = false)
    @Schema(description = "Количество этажей", example = "5")
    var floors: Int,

    @Column(nullable = false)
    @Schema(description = "Количество квартир на этаже", example = "3")
    var apartments: Int,

    @Column(nullable = false)
    @Schema(description = "Площадь квартир", example = "75")
    var area: Int,

    @Column(nullable = false)
    @Schema(description = "Стиль квартир", example = "Modern")
    var style: String,

    @Column(nullable = false)
    @Schema(description = "площадь этажа", example = "250")
    var floorArea: Int,

    @Column(nullable = false)
    @Schema(description = "План кострукции этажа", example = "Прямоугольный")
    var plan: String,

    @Column(nullable = false)
    @Schema(description = "Соотношения квартир в доме", example = "40/40/20")
    var ratio: String,

    @Column(nullable = false)
    @Schema(description = "Дополнительные пожелания клиента", example = "Хочу аквариум")
    var wishes: String?,

    @Column(name = "cost")
    @Schema(description = "Цена проектирования дома", example = "10000")
    var cost: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Уникальный ID заявки на проектирование в системе", example = "1")
    var id: Long = 0
}
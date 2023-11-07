package com.bsac.buro.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*

@Entity
@Table(name = "constructors")
@Schema(description = "описывает бригаду конструкторов в системе")
class Constructor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Уникальный ID бригады конструкторов в системе", example = "1")
    val id: Long,

    @Column(name = "name", nullable = false)
    @Schema(description = "Наименование бригады конструкторов в системе", example = "ЛофтСтайл")
    val name: String,

    @ManyToMany
    @JoinColumn(name = "orders_id")
    @Schema(description = "Список заявок назначенных на данную бригаду конструкторов в системе")
    val orders: MutableCollection<Order>
)
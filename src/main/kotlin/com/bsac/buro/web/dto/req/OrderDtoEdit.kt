package com.bsac.buro.web.dto.req

import com.bsac.buro.model.OrderStatus
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Описывает заявку подаваемую на редактирвоание")
class OrderDtoEdit(

    @Schema(description = "Уникальный ID заявки")
    val id: Long,

    @Schema(description = "Уникальный ID заказчика")
    val customerId: Long,

    @Schema(description = "Количество этажей в доме", example = "5")
    val floors: Int,

    @Schema(description = "Количество квартир в доме", example = "16")
    val apartments: Int,

    @Schema(description = "Средняя площадь квартиры", example = "75")
    val area: Int,

    @Schema(description = "Площадь этажа", example = "250")
    val floorArea: Int,

    @Schema(description = "Стиль квартиры", example = "Лофт")
    val style: String,

    @Schema(description = "План конструкции этажа", example = "П-образный")
    val plan: String,

    @Schema(description = "Соотношение квартир в доме (одно-/двух-/трех комнатные)", example = "40/40/20")
    val ratio: String,

    @Schema(description = "Дополнительные пожелния заказчика", example = "Хочу басейн на крыше")
    val wishes: String?,

    @Schema(description = "Статус заявки в системе", example = "ASSIGNED")
    val status: OrderStatus,

    @Schema(description = "Цена заявки на проектирование", example = "10000000")
    val cost: Double,

    @Schema(description = "Уникальный ID бригады назначенной на проектирование", example = "1")
    val constructorId: Long
)
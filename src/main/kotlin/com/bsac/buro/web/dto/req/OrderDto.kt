package com.bsac.buro.web.dto.req

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Описывает подаваемую заявку на проектирование многоквартиронго дома")
class OrderDto(
    @Schema(description = "Ф.И.О заказчика подающего заявку", example = "Тлюбаев Дмитрий")
    val customerName: String,

    @Schema(description = "Емайл заказчика подающего заявку", example = "someEmail@Mail.com")
    val customerEmail: String,

    @Schema(description = "Телефон заказчика подающего заявку", example = "+375 33 367 89 11")
    val phone: String,

    @Schema(description = "Количество этажей в доме", example = "5")
    val floors: Int,

    @Schema(description = "Количество квартир в доме", example = "16")
    val apartments: Int,

    @Schema(description = "Средняя площадь квартиры", example = "75")
    val area: Int,

    @Schema(description = "Стиль квартиры", example = "Лофт")
    val style: String,

    @Schema(description = "Площадь этажа", example = "250")
    val floorArea: Int,

    @Schema(description = "План конструкции этажа", example = "П-образный")
    val plan: String,

    @Schema(description = "Соотношение квартир в доме (одно-/двух-/трех комнатные)", example = "40/40/20")
    val ratio: String,

    @Schema(description = "Дополнительные пожелния заказчика", example = "Хочу басейн на крыше")
    val wishes: String?
) {
    constructor() : this("", "", "", 0, 0, 0, "", 0, "", "", "")
}
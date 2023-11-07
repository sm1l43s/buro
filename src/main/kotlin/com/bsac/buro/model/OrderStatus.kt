package com.bsac.buro.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Описывает статусы заявки в системе")
enum class OrderStatus(val value: String) {
    @Schema(description = "Заявка зарегистрирована", example = "REGISTERED")
    REGISTERED("Заказ зарегистрирован"),

    @Schema(description = "Заявка оплачена", example = "PAID")
    PAID("Заказ оплачен"),

    @Schema(description = "Заявка назначена бригаде конструкторов", example = "ASSIGNED")
    ASSIGNED("Заказ назначен бригаде конструкторов"),

    @Schema(description = "Заявка в процессе выполнения", example = "IN_PROGRESS")
    IN_PROGRESS("Заказ в процессе выполнения"),

    @Schema(description = "Заявка выполнена", example = "COMPLETED")
    COMPLETED("Заказ выполнен");
}
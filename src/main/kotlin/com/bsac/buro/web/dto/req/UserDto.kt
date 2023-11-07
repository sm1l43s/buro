package com.bsac.buro.web.dto.req

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Описывает сущность сотрудника добавляемого в систему")
class UserDto(

    @Schema(description = "Ф.И.О сотрудника", example = "Тлюбаев Д.В.")
    val name: String,

    @Schema(description = "Пароль сотрудника в системе", example = "Любой, зашифруется в BCrypt")
    var password: String,

    @Schema(description = "Емайл сотрудника, выступает в роли логина в системе")
    val email: String,

    @Schema(description = "Роль сотрудника системе", example = "ADMIN, CONSTRUCTOR и MANAGER")
    var role: String
) {
    constructor() : this("", "", "", "")
}
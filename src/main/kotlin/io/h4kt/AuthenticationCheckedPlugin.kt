package io.h4kt

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*

val AuthenticationCheckedPlugin = createApplicationPlugin(
    "AuthenticationCheckedPlugin"
) {

    on(AuthenticationChecked) { call ->

        val (name) = call.principal<UserIdPrincipal>()
            ?: return@on

        call.respondText { "Authentication checked for $name" }

    }

}
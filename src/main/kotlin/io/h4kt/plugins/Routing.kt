package io.h4kt.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.auth.*

fun Application.configureRouting() = routing {

    authenticate {

        get {
            val (name) = call.principal<UserIdPrincipal>()!!
            call.respondText { "Hi, $name" }
        }

    }

}

package io.h4kt

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.h4kt.plugins.*
import io.ktor.server.application.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    configureAuthentication()
    configureRouting()

    install(AuthenticationCheckedPlugin)

}

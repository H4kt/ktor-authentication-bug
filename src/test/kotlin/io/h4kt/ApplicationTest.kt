package io.h4kt

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import io.h4kt.plugins.*

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {

        application {
            configureAuthentication()
            configureRouting()
        }

        val response = client.get("/") {
            basicAuth("admin", "admin")
        }

        response.run {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Authentication checked for admin", bodyAsText())
        }

    }

}

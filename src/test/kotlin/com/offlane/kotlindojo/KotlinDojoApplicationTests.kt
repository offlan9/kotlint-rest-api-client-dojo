package com.offlane.kotlindojo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinDojoApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun sayHiWithParameter() {
        assertEquals("Hello Kotlin!", sayHi("Kotlin"))
    }

    private fun sayHi(s: String): String {
        return "$s Kotlin $s"
    }

    @Test
    fun exampleTest() {
        assertEquals(1, 2)
    }

    @Test
    fun thisIsABook() {
        assertEquals("book", "books")
    }
}

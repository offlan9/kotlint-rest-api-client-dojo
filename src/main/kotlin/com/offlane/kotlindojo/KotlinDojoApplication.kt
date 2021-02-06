package com.offlane.kotlindojo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@SpringBootApplication
class KotlinDojoApplication

@JsonIgnoreProperties(ignoreUnknown = true)
data class User (
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

data class Address (
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

data class Geo (
    val lat: String,
    val lng: String
)

data class Company (
    val name: String,
    val catchPhrase: String,
    val bs: String
)

fun main(args: Array<String>) {
    val url = "https://jsonplaceholder.typicode.com/users"

    val rest = RestTemplate()
    val user = rest.getForObject<User>("$url/1")
    println(user)

    val users = rest.getForObject<List<User>>(url)
    println(users)

    val headers = HttpHeaders()
    headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
    headers["Authorization"] = "Basic xxxxx"
    val userWithHeader = rest.getForObject<User>("$url/1", headers)
    println(userWithHeader)

    val entity: HttpEntity<*> = HttpEntity<Any?>(headers)
    val response: ResponseEntity<User> = rest.exchange("$url/1", HttpMethod.GET, entity, User::class.java)
    println(response.headers)
}

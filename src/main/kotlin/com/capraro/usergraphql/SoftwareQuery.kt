package com.capraro.usergraphql

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class SoftwareQuery : Query {
    fun software() = listOf(Software(name = "Jira", type = SoftwareType.CLOUD),
            Software(name = "SonarQube", type = SoftwareType.ON_PREM),
            Software(name = "Gitlab", type = SoftwareType.ON_PREM))

    fun user(lastNameStartWith: String?) = listOf(
            Admin(lastName = "Smith", firstName = "John", email = "jsmith@acme.org"),
            User(lastName = "Smith", firstName = "Anna ", email = "asmith @acme.org ", roles = listOf(" OWNER ", " REPORTER "), projects = listOf(" SECURITY_API ", " USER_MANAGEMENT ")),
            User(lastName = "John", firstName = "Doe ", email = "jdoe@acme.org ", roles = listOf(" DEVELOPER "), projects = listOf(" CUSTOMERS ", " CONTRACTS "))
    ).filter { it.lastName.startsWith(lastNameStartWith ?: "", ignoreCase = true) }

}

@GraphQLDescription("Type of software installation")
enum class SoftwareType {
    ON_PREM,
    CLOUD
}

data class Software(val name: String, val type: SoftwareType)

interface Person {
    @GraphQLDescription("Person firstName")
    val firstName: String
    @GraphQLDescription("Person lastName")
    val lastName: String
    @GraphQLDescription("Person email")
    val email: String
}

data class User(
        override val firstName: String,
        override val lastName: String,
        override val email: String,
        val projects: List<String>,
        val roles: List<String>) : Person

data class Admin(
        override val firstName: String,
        override val lastName: String,
        override val email: String
) : Person

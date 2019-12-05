package com.capraro.usergraphql

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class PersonQuery: Query {
    fun person() = Person(firstName="Richard", lastName = "Capraro", age = 45)
}

data class Person(
        @GraphQLDescription("Person firstName")
        val firstName: String,
        val lastName: String,
        val age: Int?)

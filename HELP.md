# Getting Started

Open `http://localhost:8080/playground`

Sample query
```
{
  software
  {
    name
    type
  }
  
  user(lastNameStartWith: "Smith") {
    lastName
    firstName
    ... on User {
      email
      projects
      roles
    }
    ... on Admin {
      email
    }
  }
}
```

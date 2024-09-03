Sample Rest API 
- Implements Contact and ContactDetail api with one to many releation
- Code covers concept like Spring boot rest API
- Custom Response code
- Dependancy Injection
- Request Validation
- Error Handling and Exceptions
- Custom DTO
- Transaction Manager
- Request Mapping and routes
- Reduce Boilerplate code with Lombok
- Use of Interface and Repository
- Postgres database connection
- Swagger UI

  User http://localhost:8080/swagger-ui to test the API's
  Make sure you change connection in application.properties to test the project, Once you set the connection string Spring will automatically create required tables
  Sample request body :
  {
    "name": "Jhon",
    "contactDetails": [
        {
            "email": "john.doe@example.com",
            "phone": "1234567890"
        },
        {
            "email": "john.doe.work@example.com",
            "phone": "0987654321"
        }
    ]
}

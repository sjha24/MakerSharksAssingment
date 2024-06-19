<h1 align="center">User Management System</h1>

<p align="center">
    <a href="https://www.java.com/" target="_blank">
        <img src="https://img.shields.io/badge/Java-17-red" alt="Java 17">
    </a>
    <a href="https://maven.apache.org/" target="_blank">
        <img src="https://img.shields.io/badge/Maven-4.0.0-blue" alt="Maven 4.0.0">
    </a>
    <a href="https://spring.io/projects/spring-boot" target="_blank">
        <img src="https://img.shields.io/badge/Spring Boot-3.2.4-brightgreen" alt="Spring Boot 3.2.4">
    </a>
</p>

<hr>
The User Management and Authentication Service is a Spring Boot application designed to handle user registration, authentication, and secure access to protected resources. It leverages JWT (JSON Web Tokens) for stateless authentication and implements security best practices to ensure that user data is handled securely.
<hr>

## Dependencies

- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa): Provides support for Spring Data JPA, enabling easy interaction with databases using JPA.

- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web): Provides basic web support, including embedded Tomcat server and Spring MVC.

- [MySQL Connector/J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j): JDBC driver for connecting to MySQL databases.

- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok): Reduces boilerplate code by providing annotations to generate getters, setters, constructors, and more.
 
- [Springdoc OpenAPI Starter WebMVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui): Integrates OpenAPI documentation into Spring Boot applications.

- [Spring boot Starter validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation): Integrates Spring boot starter validation into Spring Boot applications.

## Features
  - **Register User:** `Users can register by providing a username, email, and password.`
  - **Login User:** `User can login useing email and password.`
  - **Fetch User:** `Authenticated User can Fetch User By User name.`

## Enpoints

### Register New Training center

- **URL:** `/api/user/register`
- **Method:** `POST`
- **Description:** Registers a new User.
- **Request Body:**
    - JSON object representing the User Details to be registered.
    - Includes details such as User Name,email and password etc.
 ```json
{
  "name": "string",
  "email": "string",
  "password": "string"
}
```
![Screenshot (467)](https://github.com/sjha24/MakerSharksAssingment/assets/98340874/d9f32206-f267-4643-8904-3509220d305c)

- **URL:** `/api/auth/login`
- **Method:** `POST`
- **Description:** Login Existing User.
- **Request Body:**
    - JSON object representing the User Details to be Login.
    - Includes details such as email and password .
 ```json
{
  "email": "string",
  "password": "string"
}
```
![Screenshot (468)](https://github.com/sjha24/MakerSharksAssingment/assets/98340874/dc2d9348-3df6-461a-a62f-0bfcdb2716bf)

- **URL:** `/api/user/fetch`
- **Method:** `GET`
- **Description:**Authenticated User Can Fetch Existing User.
- **Request Body:**
 ```json
Query Parameter
{
    Name : String
}
```

![Screenshot (469)](https://github.com/sjha24/MakerSharksAssingment/assets/98340874/6354a92a-3727-4c06-a592-2361c72655da)
![Screenshot (470)](https://github.com/sjha24/MakerSharksAssingment/assets/98340874/5b1ece9a-5ad3-4f5a-9992-5930bad90395)


## Swagger Support for API Documentation

The project includes Swagger support for API documentation. Swagger is a powerful tool that provides interactive documentation for RESTful APIs, enabling developers to explore and test endpoints easily. By integrating Swagger into your project, you can enhance the usability and understanding of your API, making it easier for developers to integrate with your system.

### Key Benefits of Swagger:
- **Interactive Documentation:** Swagger generates interactive documentation that allows developers to explore and test endpoints directly from the documentation interface.
- **Ease of Integration:** Developers can easily understand and integrate with your API by referring to the comprehensive documentation provided by Swagger.
- **Consistency:** Swagger ensures that the API documentation remains consistent with the actual implementation, reducing the chances of discrepancies.
- **Time-Saving:** With Swagger, developers can quickly understand the API structure and functionalities, saving time on integration and troubleshooting.

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/sjha24/MakerSharksAssingment.git
   ```

2. Navigate to the project directory:

   ```bash
   cd UserManagementSystem
   ```
3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```
## Database Setup

To set up the database for the WishlistManagement application, follow these steps:

1. Open the `application.yml` file in the project's `src/main/resources` directory.

2. Configure the datasource properties according to your MySQL database setup:
```
server:
  port: 8802

spring:
  datasource:
    driver: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${DB_HOST_PORT}/${DB_NAME}
    username: ${DB_USER}
    password: ${DB_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: update
    database: MYSQL
  ```

Replace `your_DB_HOST_PORT` , `DB_NAME`, `DB_USER` and `DB_password` with your MySQL database credentials.

## Accessing the Application

You can access the application through your web browser by navigating to `http://localhost:8802`.

## Custom Port Configuration

If you need to define your own port for accessing the application, you can do so by configuring it in the `application.yml` file. Simply specify the desired port number in the configuration file, and the application will listen on that port upon startup.

Example:
```
server:
  port:9000
```

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or features you'd like to see.

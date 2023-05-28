# Medicare Backend - Spring Boot with MySQL

![App Logo](backend_logo.png)

Welcome to the Medicare Backend! This repository contains the backend code for the Medicare Angular Medicine Ecommerce App. The backend is built using Spring Boot and utilizes MySQL as the database.
- To access the live version of the app, visit: [Medicare Live Demo](http://15.207.29.70/)
- To access the admin panel use the following credentials : email : malay@gmail.com password : abc123
## Features

The Medicare backend provides the following features:

- **User Management:** Handle user registration, authentication, and profile management.
- **Product Management:** Manage the catalog of medicines, including CRUD operations for medicines, categories, and brands.
- **Order Management:** Handle order processing, tracking, and history.
- **Authentication and Authorization:** Secure endpoints and authorize access to specific resources.
- **API Documentation:** Well-documented RESTful APIs using Swagger or OpenAPI.

## Technology Used

The backend of the Medicare app utilizes the following technologies:

- **Java:** The primary programming language for developing the Spring Boot application.
- **Spring Boot:** A powerful framework for building Java applications, providing a convenient and efficient development environment.
- **MySQL:** A popular relational database management system for storing and retrieving data.
- **Spring Data JPA:** Simplifies working with databases by providing easy-to-use abstractions and reducing boilerplate code.
- **Spring Security:** Provides authentication and authorization functionalities to secure the backend APIs.
-  **JWT:** Provides token based authentication and authorization functionalities to secure the backend APIs.
- **Swagger or OpenAPI:** Generates interactive API documentation to help developers understand and use the APIs.

## Installation and Setup

To set up the Medicare backend locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/medicare-backend.git`
2. Navigate to the project directory: `cd medicare-backend`
3. Configure the MySQL database connection in the `application.properties` file.
4. Run the application using your preferred IDE or by executing the command: `./mvnw spring-boot:run`

## API Documentation

The Medicare backend provides API documentation using Swagger or OpenAPI. After running the backend application locally, you can access the API documentation at the following URL:


## Deployment

To deploy the Medicare backend, follow these steps:

1. Set up a MySQL database in your deployment environment.
2. Build the backend application using your preferred method (e.g., Maven or Gradle).
3. Configure the MySQL database connection in the deployment environment (e.g., using environment variables or application properties).
4. Deploy the built application to your preferred server or cloud platform (e.g., Tomcat, AWS, or Heroku).
5. Ensure the backend application's base URL is updated in the Angular frontend configuration.

## Contributing

Contributions to the Medicare backend project are welcome! If you encounter any issues or would like to add new features, please follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b my-new-feature`
3. Make your changes and commit them: `git commit -am 'Add some feature'`
4. Push the branch: `git push origin my-new-feature`
5. Submit a pull request explaining your changes.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

We would like to express our gratitude to the following resources and libraries that contributed to the development of this backend:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [Swagger](https://swagger.io/) or [OpenAPI](https://www.openapis.org/)

Please note that you should replace `backend_logo.png` with the actual path or URL to your backend's logo image.

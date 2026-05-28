[![Java CI/CD with docker](https://github.com/SJHelmhout/JavaDemoRefresh/actions/workflows/maven-build.yml/badge.svg)](https://github.com/SJHelmhout/JavaDemoRefresh/actions)
# Spring Boot Refresh
## Stack and Tools used:
- Java 21 (LTS)
- Spring Boot
- Maven
- Cucumber / Gherkin (BDD)
- Docker
- Github Actions (CI / CD)

## 🏗 Architecture & Design

The application follows a Strict Layered Architecture to ensure high testability and a clean separation of concerns:

    Model Layer: Clean POJOs utilizing Lombok to eliminate boilerplate code.

    Service Layer: Contains the core business logic, decoupled from the web layer to allow for easy unit testing.

    Controller Layer: RESTful entry points that handle HTTP mapping and request validation.

Testing Strategy:
The project employs a dual-testing strategy. JUnit 5/Mockito is used for technical unit and integration testing, while Cucumber/Gherkin provides Behavior-Driven Development (BDD) scenarios that act as living documentation for the system's requirements.

## How to run
To compile the project and run the full test suite (including JUnit and Cucumber scenarios):
run the following command in the project root.

``mvn clean test``  

The project is optimized for containerization. To build the production-ready image and run it locally:  

``docker build -t spring-demo-1:latest``  

Running the container:  

``docker run -p 8080:8080 spring-demo-1:latest``  

The application will then be available at ``http://localhost:8080``.

## CI/CD Pipeline
The integrated GitHub Actions workflow automatically performs the following on every push:
- Sets up a JDK 21 environment. 
- Executes all Maven tests. 
- Validates the Docker build process.
- Ensures the project remains in a deployable state.